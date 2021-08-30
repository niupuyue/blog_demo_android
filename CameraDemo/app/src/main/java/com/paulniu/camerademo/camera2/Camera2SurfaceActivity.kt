package com.paulniu.camerademo.camera2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.ImageFormat
import android.hardware.Camera
import android.hardware.camera2.*
import android.media.Image
import android.media.ImageReader
import android.os.*
import android.util.Size
import android.view.Surface
import android.view.SurfaceHolder
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.paulniu.camerademo.AutoFitSurfaceView
import com.paulniu.camerademo.CameraPreviewActivity
import com.paulniu.camerademo.CameraUtil
import com.paulniu.camerademo.R
import com.xizhi_ai.xizhi_common.camera.util.computeExifOrientation
import com.xizhi_ai.xizhi_common.camera.util.getPreviewOutputSize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import okio.buffer
import okio.sink
import java.io.Closeable
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.TimeoutException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @author:Niu Puyue
 * e-mail:niupuyue@aliyun.com
 * time:8/30/21 5:22 PM
 * desc:
 */
class Camera2SurfaceActivity : AppCompatActivity() {

    private lateinit var viewFinder: AutoFitSurfaceView
    private lateinit var shutter: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.camera_2_surface_layout)
        viewFinder = findViewById(R.id.camera2_surface)
        shutter = findViewById(R.id.camera2_shutter_view)

        initCamera2Config()
    }

    private fun initCamera2Config() {
        initOriention()
        initViewFinder()
    }

    /**
     * 初始化surfaceview
     */
    private fun initViewFinder() {
        viewFinder.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                // 当surface创建完成之后，动态设置suerface的大小
                previewSize = getPreviewOutputSize(
                    viewFinder.display, characteristics, SurfaceHolder::class.java
                )
                viewFinder.setAspectRatio(
                    previewSize?.width
                        ?: IMAGE_DEFAULT_WIDTH, previewSize?.height ?: IMAGE_DEFAULT_HEIGHT
                )
                // To ensure that size is set, initialize camera in the view's thread
                viewFinder.post { initializeCamera() }
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) = Unit

            override fun surfaceDestroyed(holder: SurfaceHolder) = Unit
        })
    }

    /**
     * 初始化角度信息 如果相机角度发生改变，会动态修改relativeOrientation
     */
    private fun initOriention() {
        relativeOrientation = OrientationLiveData(this, characteristics)

        relativeOrientation = OrientationLiveData(this, characteristics).apply {
            observe(this@Camera2SurfaceActivity, androidx.lifecycle.Observer { })
        }
    }

    /**
     * 初始化相机相关参数 使用协程 保证在主线程中使用
     */
    @SuppressLint("Recycle")
    private fun initializeCamera() = lifecycleScope.launch(Dispatchers.Main) {
        // 根据参数，获取camera对象
        camera = openCamera(cameraManager, cameraId, cameraHandler)
        // 初始化一个用于捕获静态照片的图像读取器 默认使用最大的分辨率的图片
        // 该方法不再使用，最大分辨率图片比较大，不适用
        val size = characteristics.get(
            CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
        )!!
            .getOutputSizes(ImageFormat.JPEG).maxBy { it.height * it.width }!!
        // 使用固定分辨率大小的ImageReader(此处使用预览的宽高)
        imageReader = ImageReader.newInstance(
            previewSize?.width ?: IMAGE_DEFAULT_WIDTH, previewSize?.height
                ?: IMAGE_DEFAULT_HEIGHT, ImageFormat.JPEG, IMAGE_BUFFER_SIZE
        )
        // 初始化surface集合，用于相机输出帧
        val targets = listOf(viewFinder.holder.surface, imageReader.surface)
        // 开启一个捕捉回话
        session = createCaptureSession(camera, targets, cameraHandler)

        captureRequest = camera.createCaptureRequest(
            CameraDevice.TEMPLATE_PREVIEW
        ).apply { addTarget(viewFinder.holder.surface) }

        // 持续获取捕获的帧对象
        session.setRepeatingRequest(captureRequest.build(), null, cameraHandler)

        // 初始化完成后，为按钮添加点击事件
        // 注意 第一次拍照处理时间会比较长，需要添加一下加载动效
        shutter.setOnClickListener {
            // 点击之后，设置不可再次点击
            it.isEnabled = false
            // 通过协程，控制IO线程执行拍照操作
            lifecycleScope.launch(Dispatchers.IO) {
                // 执行拍照操作
                takephoto().use { result ->
                    // 拿到拍照结果，并将图片保存到本地
                    val output = saveResult(result)
                    // 拍照完成之后，动态修改已经拍照的数据，并生成预览图片 并把图片进行压缩
                    lifecycleScope.launch(Dispatchers.Main) {
                        val intent =
                            Intent(this@Camera2SurfaceActivity, CameraPreviewActivity::class.java)
                        intent.putExtra("bitmap", output?.absolutePath)
                        startActivity(intent)
                    }
                }

                // 拍照操作执行完成后，设置按钮可以点击
                it.isEnabled = true
            }
        }
    }


    /**
     * 将拍照结果CombinedCaptureResult保存成本地图片
     */
    @SuppressLint("Recycle")
    @Suppress("BlockingMethodInNonBlockingContext")
    private suspend fun saveResult(result: CombinedCaptureResult): File? =
        suspendCoroutine { cont ->
            when (result.format) {
                ImageFormat.JPEG, ImageFormat.DEPTH_JPEG -> {
                    val buffer = result.image.planes[0].buffer
                    val bytes = ByteArray(buffer.remaining()).apply { buffer.get(this) }
                    // 拍照成功，展开预览操作
                    val name: String = "Camera1Demo" + System.currentTimeMillis() + ".jpg"
                    val eFile = cacheDir
                    val mDirectory = File(eFile.toString() + File.separator + "Camera1Demo")
                    if (!mDirectory.exists()) {
                        mDirectory.mkdirs()
                    }
                    val rawBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    val resultBitmap = CameraUtil.rotate(rawBitmap, 90f)
                    val imageFile = File(mDirectory, name)
                    imageFile.sink().buffer().write(CameraUtil.toByteArray(resultBitmap)).close()
                    cont.resume(imageFile)
                }
                else -> {
                    // 图片格式错误
                    val exc = RuntimeException("未知图片格式: ${result.image.format}")
                    cont.resumeWithException(exc)
                }
            }
        }

    /**
     * 拍照
     */
    @Suppress("ControlFlowWithEmptyBody", "BlockingMethodInNonBlockingContext")
    private suspend fun takephoto(): CombinedCaptureResult = suspendCoroutine { cont ->
        // 刷新所有还处于缓冲区的image
        while (imageReader.acquireNextImage() != null) {
        }
        // 开启一个新的图片队列
        val imageQueue = ArrayBlockingQueue<Image>(IMAGE_BUFFER_SIZE)
        // 设置对imageReader的监听，当存在有效的图片的时候，向队列中添加图片
        imageReader.setOnImageAvailableListener({ reader ->
            val imageBuf = reader?.acquireNextImage()
            // 将image添加到队列中
            imageQueue.add(imageBuf)
        }, imageReaderHandler)
        // 创建一个captureRequest
        val captureRequest = session.device.createCaptureRequest(
            CameraDevice.TEMPLATE_STILL_CAPTURE
        ).apply { addTarget(imageReader.surface) }
        // 为session会话添加捕获监听
        session.capture(captureRequest.build(), object : CameraCaptureSession.CaptureCallback() {
            override fun onCaptureStarted(
                session: CameraCaptureSession,
                request: CaptureRequest,
                timestamp: Long,
                frameNumber: Long
            ) = Unit

            override fun onCaptureCompleted(
                session: CameraCaptureSession,
                request: CaptureRequest,
                result: TotalCaptureResult
            ) {
                super.onCaptureCompleted(session, request, result)
                // 捕获已经完成
                // 获取捕获的时间戳
                val resultTimestamp = result.get(CaptureResult.SENSOR_TIMESTAMP)
                // 设置如果捕获时间过长的异常处理
                val exc = TimeoutException("拍照相应时间超时，请稍后重试！")
                val timeoutRunnable = Runnable { cont.resumeWithException(exc) }
                imageReaderHandler.postDelayed(timeoutRunnable, IMAGE_CAPTURE_TIMEOUT_MILLIS)

                lifecycleScope.launch(cont.context) {
                    while (true) {
                        // 拿到队列中的第一个图片
                        val image = imageQueue.take()
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
                            image.format != ImageFormat.DEPTH_JPEG &&
                            image.timestamp != resultTimestamp
                        ) continue

                        imageReaderHandler.removeCallbacks(timeoutRunnable)
                        imageReader.setOnImageAvailableListener(null, null)

                        // 如果图片队列的数量大于0，则获取第一张图片close
                        while (imageQueue.size > 0) {
                            imageQueue.take().close()
                        }
                        // 设置图片的旋转角度
                        val rotation = relativeOrientation.value ?: 0
                        val mirrored = characteristics.get(CameraCharacteristics.LENS_FACING) ==
                                CameraCharacteristics.LENS_FACING_FRONT
                        val exifOrientation = computeExifOrientation(rotation, mirrored)
                        // 构建图片数据结果
                        cont.resume(
                            CombinedCaptureResult(
                                image, result, exifOrientation, imageReader.imageFormat
                            )
                        )
                    }
                }
            }


        }, cameraHandler)
    }

    /**
     * 创建一个CameraCaptureSession并返回回话配置
     */
    private suspend fun createCaptureSession(
        device: CameraDevice,
        targets: List<Surface>,
        handler: Handler? = null
    ): CameraCaptureSession = suspendCoroutine { cont ->
        device.createCaptureSession(targets, object : CameraCaptureSession.StateCallback() {
            override fun onConfigured(session: CameraCaptureSession) = cont.resume(session)

            override fun onConfigureFailed(session: CameraCaptureSession) = Unit
        }, handler)
    }

    /**
     * 打开相机，并返回一个相机对象
     */
    @SuppressLint("MissingPermission")
    private suspend fun openCamera(
        cameraManager: CameraManager,
        cameraId: String,
        handler: Handler? = null
    ): CameraDevice = suspendCancellableCoroutine { cont ->
        cameraManager.openCamera(
            cameraId,
            object : CameraDevice.StateCallback() {
                override fun onOpened(camera: CameraDevice) = cont.resume(camera)

                override fun onDisconnected(camera: CameraDevice) = Unit

                override fun onError(camera: CameraDevice, error: Int) = Unit
            }, handler
        )
    }

    private val cameraManager: CameraManager by lazy {
        applicationContext.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    private val characteristics: CameraCharacteristics by lazy {
        cameraManager.getCameraCharacteristics(cameraId)
    }

    private lateinit var imageReader: ImageReader

    private val cameraThread = HandlerThread("CameraThread").apply { start() }

    private val cameraHandler = Handler(cameraThread.looper)

    private val imageReaderThread = HandlerThread("imageReaderThread").apply { start() }

    private val imageReaderHandler = Handler(imageReaderThread.looper)

    private lateinit var camera: CameraDevice

    private lateinit var session: CameraCaptureSession

    private lateinit var relativeOrientation: OrientationLiveData

    private val cameraId: String = CameraCharacteristics.LENS_FACING_FRONT.toString()

    private lateinit var captureRequest: CaptureRequest.Builder

    private var previewSize: Size? = null

    companion object {

        private const val IMAGE_BUFFER_SIZE: Int = 10

        private const val IMAGE_CAPTURE_TIMEOUT_MILLIS: Long = 5000

        private const val IMAGE_DEFAULT_WIDTH = 1080
        private const val IMAGE_DEFAULT_HEIGHT = 1920

        data class CombinedCaptureResult(
            val image: Image,
            val metadata: CaptureResult,
            val orientation: Int,
            val format: Int
        ) : Closeable {
            override fun close() = image.close()
        }
    }

}