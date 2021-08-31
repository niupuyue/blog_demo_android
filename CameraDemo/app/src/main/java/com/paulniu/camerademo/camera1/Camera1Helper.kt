package com.paulniu.camerademo.camera1

import android.app.Activity
import android.content.Context
import android.graphics.ImageFormat
import android.hardware.Camera
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.util.Log
import android.util.Size
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.paulniu.camerademo.AutoFitSurfaceView
import com.paulniu.camerademo.DensityUtil
import com.xizhi_ai.xizhi_common.camera.util.getPreviewOutputSize

/**
 * @author:Niu Puyue
 * e-mail:niupuyue@aliyun.com
 * time:6/30/21 4:38 PM
 * desc: camera1 拍照识别图片 工具类
 */
class Camera1Helper(
    activity: Activity,
    surfaceView: AutoFitSurfaceView,
    cameraManager: CameraManager
) : Camera.PreviewCallback {

    private var mActivity = activity
    private var mSurfaceView = surfaceView
    private var mCameraHelperCallback: CameraHelperCallback? = null

    /**
     * 相机相关操作工具对象
     */
    private var mSurfaceHolder: SurfaceHolder = surfaceView.holder
    private lateinit var mCameraParamter: Camera.Parameters
    private var mCamera: Camera? = null
    private var mCameraFacing = Camera.CameraInfo.CAMERA_FACING_BACK   // 摄像头方向
    private var mDisplayOrientation: Int = 0  // 预览相机的旋转角度
    private lateinit var previewSize: Size
    private val cameraId: String = CameraCharacteristics.LENS_FACING_FRONT.toString()
    private val characteristics: CameraCharacteristics by lazy {
        cameraManager.getCameraCharacteristics(cameraId)
    }

    // 默认情况下保存图片的宽高(实际会通过计算)
    private var picWidth = 1080
    private var picHeight = 1920

    private var mFrontCameraInfo: Camera.CameraInfo? = null
    private var mFrontCameraID: Int? = 0
    private var mBackCameraInfo: Camera.CameraInfo? = null
    private var mBackCameraID: Int? = 0

    private fun initCameraInfo() {
        val phoneNumbers = Camera.getNumberOfCameras()
        for (cameraId in 0 until phoneNumbers) {
            val cameraInfo = Camera.CameraInfo()
            Camera.getCameraInfo(cameraId, cameraInfo)
            Log.e("Camera1Helper", cameraInfo.toString())
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                // 前置摄像头
                mFrontCameraID = cameraId
                mFrontCameraInfo = cameraInfo
            } else if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                // 后置摄像头
                mBackCameraID = cameraId
                mBackCameraInfo = cameraInfo
            }
        }
    }

    private fun getFitPreviewOutputSize(camera: Camera): Size {
        val parameters = camera.parameters
        val supportPreviewSize = parameters.supportedPreviewSizes
        var result = Size(1920, 1080)
        supportPreviewSize.forEach { size ->
            Log.e("Camera1Helper", size.toString())
            result = Size(size.width, size.height)
        }
        return result
    }

    override fun onPreviewFrame(data: ByteArray?, camera: Camera?) {
        mCameraHelperCallback?.onPreviewFrame(data)
    }

    /**
     * 初始化相机配置信息
     */
    private fun initCameraConfig() {
        mSurfaceHolder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                previewSize = getPreviewOutputSize(
                    mSurfaceView.display, characteristics, SurfaceHolder::class.java
                )
                mSurfaceView.setAspectRatio(previewSize.width, previewSize.height)
                if (mCamera == null) {
                    // 创建camera对象
                    openCamera(mCameraFacing)
                }
                // 开始预览
                startPreview()
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) = Unit

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                releaseCamera()
            }
        })
    }

    /**
     * 开始相机预览
     */
    private fun startPreview() {
        mCamera?.let {
            it.setPreviewDisplay(mSurfaceHolder)
            // 设置相机旋转角度的问题
            setCameraDisplayOrientation()
            // 开始预览
            it.startPreview()
        }
    }

    /**
     * 根据相机的标志，打开对应的摄像头
     */
    private fun openCamera(cameraFace: Int = Camera.CameraInfo.CAMERA_FACING_BACK): Boolean {
        // 首先判断当前手机/平板 支持的相机
        if (getSupportCamera(cameraFace)) {
            try {
                mCamera = Camera.open(cameraFace)
                getFitPreviewOutputSize(mCamera!!)
                mCamera?.let { initCameraParamter(it) }
                mCamera?.setPreviewCallback(this)
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
        }
        return true
    }

    /**
     * 设置相机对应的参数
     */
    private fun initCameraParamter(camera: Camera) {
        try {
            mCameraParamter = camera.parameters
            // 设置相机预览的参数
            mCameraParamter.previewFormat = ImageFormat.NV21

            // 获取指定的宽高/与指定宽高比例相近的尺寸
            // 设置预览尺寸
            val bestPreviewSize = getBestSize(
                mSurfaceView.width,
                mSurfaceView.height,
                mCameraParamter.supportedPreviewSizes
            )
            // 设置最佳拍照尺寸
            bestPreviewSize?.let { mCameraParamter.setPreviewSize(it.width, it.height) }

            // 设置拍照保存图片的尺寸
            picWidth = DensityUtil.getScreenWidth(mActivity)
            picHeight = DensityUtil.getScreenHeight(mActivity) - DensityUtil.dp2px(mActivity, 100f)
            val bestPicSize =
                getBestSize(picWidth, picHeight, mCameraParamter.supportedPictureSizes)
            bestPicSize?.let {
                mCameraParamter.setPictureSize(it.width, it.height)
            }

            //对焦模式
            if (isSupportFocus(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE))
                mCameraParamter.focusMode = Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE

            // 将相机配置设置给当前相机
            camera.parameters = mCameraParamter
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 查询手机/平板当前支持的相机
     * 通过遍历的方式
     * @param cameraFace 需要查询手机的id
     * @return 是否支持该摄像头
     */
    private fun getSupportCamera(cameraFace: Int): Boolean {
        val cameraInfo = Camera.CameraInfo()
        for (index in 0 until Camera.getNumberOfCameras()) {
            Camera.getCameraInfo(index, cameraInfo)
            if (cameraInfo.facing == cameraFace) return true
        }
        return false
    }

    /**
     * 计算最佳的相机尺寸
     */
    private fun getBestSize(
        targetWidth: Int,
        targetHeight: Int,
        sizeList: List<Camera.Size>
    ): Camera.Size? {
        var bestSize: Camera.Size? = null
        // 计算宽高的比例
        val targetRotia = (targetHeight.toDouble()) / targetWidth
        var minDiff = targetRotia
        // 通过遍历查找与比例最接近的相机拍照尺寸
        sizeList.forEach { cameraSize ->
            if (cameraSize.width == targetWidth && cameraSize.height == targetHeight) {
                // 相机拍照尺寸与默认尺寸相同，则直接使用该对象
                bestSize = cameraSize
                return@forEach
            }
            // 计算相机拍照支持尺寸 对应的比例
            val supportRotia = cameraSize.width.toDouble() / cameraSize.height
            if (Math.abs(supportRotia - targetRotia) < minDiff) {
                minDiff = Math.abs(supportRotia - targetRotia)
                bestSize = cameraSize
            }
        }
        Log.e("CameraHelper", "目标尺寸 ：$targetWidth * $targetHeight ，   比例  $targetRotia")
        Log.e("CameraHelper", "最优尺寸 ：${bestSize?.height} * ${bestSize?.width}")
        return bestSize
    }

    //判断是否支持某一对焦模式
    private fun isSupportFocus(focusMode: String): Boolean {
        var autoFocus = false
        val listFocusMode = mCameraParamter.supportedFocusModes
        for (mode in listFocusMode) {
            if (mode == focusMode)
                autoFocus = true
            Log.e("CameraHelper", "相机支持的对焦模式： $mode")
        }
        return autoFocus
    }

    /**
     * 相机旋转角度问题
     */
    private fun setCameraDisplayOrientation() {
        val cameraInfo = Camera.CameraInfo()
        Camera.getCameraInfo(mCameraFacing, cameraInfo)
        // 获取当前相机默认旋转的角度
        val rotation = mActivity.windowManager.defaultDisplay.rotation
        var screenAngle = 0
        when (rotation) {
            Surface.ROTATION_0 -> screenAngle = 0
            Surface.ROTATION_90 -> screenAngle = 90
            Surface.ROTATION_180 -> screenAngle = 180
            Surface.ROTATION_270 -> screenAngle = 270
        }

        if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            // 如果是前置摄像头
            mDisplayOrientation = (cameraInfo.orientation + screenAngle) % 360
            mDisplayOrientation =
                (360 - mDisplayOrientation) % 360          // compensate the mirror
        } else {
            mDisplayOrientation = (cameraInfo.orientation - screenAngle + 360) % 360
        }

        mCamera?.setDisplayOrientation(mDisplayOrientation)
    }

    /**
     * CameraHelper工具类 回调接口
     */
    interface CameraHelperCallback {
        // 点击拍照之后拍照数据
        fun onTakePic(data: ByteArray?)

        // 拍照之前的预览数据
        fun onPreviewFrame(data: ByteArray?)
    }

    /**
     * 对外暴露的方法
     */
    // 获取Camera对象
    fun getCamera(): Camera? {
        return mCamera
    }

    /**
     * 设置拍照监听回调
     */
    fun setCameraHelperCallback(callback: CameraHelperCallback) {
        this.mCameraHelperCallback = callback
    }

    /**
     * 释放相机资源
     */
    fun releaseCamera() {
        if (mCamera != null) {
            mCamera?.stopPreview()
            mCamera?.setPreviewCallback(null)
            mCamera?.release()
            mCamera = null
        }
    }

    /**
     * 拍照
     */
    fun takePic() {
        mCamera?.let {
            it.takePicture({}, null, { data, _ ->
                it.startPreview()
                mCameraHelperCallback?.onTakePic(data)
            })
        }
    }

    /**
     * 打开和关闭闪光灯
     */
    fun switchFlash(isOpen: Boolean) {
        mCamera?.let {
            val paramter = it.parameters
            paramter.flashMode = if (isOpen) {
                Camera.Parameters.FLASH_MODE_TORCH
            } else {
                Camera.Parameters.FLASH_MODE_OFF
            }
            it.parameters = paramter
        }
    }

    /**
     * 获取相机id
     */
    fun getCameraFacing(): Int {
        return mCameraFacing
    }

    init {
        initCameraConfig()
        initCameraInfo()
    }
}