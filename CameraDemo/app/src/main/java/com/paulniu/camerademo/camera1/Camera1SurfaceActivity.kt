package com.paulniu.camerademo.camera1

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.hardware.Camera
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.paulniu.camerademo.AutoFitSurfaceView
import com.paulniu.camerademo.CameraPreviewActivity
import com.paulniu.camerademo.CameraUtil
import com.paulniu.camerademo.R
import okio.buffer
import okio.sink
import java.io.File

/**
 * @author:Niu Puyue
 * e-mail:niupuyue@aliyun.com
 * time:8/30/21 5:21 PM
 * desc:
 */
class Camera1SurfaceActivity : AppCompatActivity() {

    private lateinit var surface: AutoFitSurfaceView
    private lateinit var shutter: View

    private lateinit var mCameraHelper: Camera1Helper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.camera_1_surface_layout)
        surface = findViewById(R.id.camera1_surface)
        shutter = findViewById(R.id.camera1_shutter_view)
        initCamera1()
    }

    override fun onStart() {
        super.onStart()
        shutter.setOnClickListener {
            mCameraHelper.takePic()
        }
    }

    private fun initCamera1() {
        val cameraManager =
            applicationContext.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        mCameraHelper = Camera1Helper(this, surface, cameraManager)
        mCameraHelper.setCameraHelperCallback(object : Camera1Helper.CameraHelperCallback {
            override fun onTakePic(data: ByteArray?) {
                // 拍照成功，展开预览操作
                val name: String = "Camera1Demo" + System.currentTimeMillis() + ".jpg"
                val eFile = cacheDir
                val mDirectory = File(eFile.toString() + File.separator + "Camera1Demo")
                if (!mDirectory.exists()) {
                    mDirectory.mkdirs()
                }
                val rawBitmap = BitmapFactory.decodeByteArray(data, 0, data!!.size)
                val resultBitmap =
                    if (mCameraHelper.getCameraFacing() == Camera.CameraInfo.CAMERA_FACING_FRONT)
                        CameraUtil.mirror(CameraUtil.rotate(rawBitmap, 270f))
                    else
                        CameraUtil.rotate(rawBitmap, 90f)
                val imageFile = File(mDirectory, name)
                imageFile.sink().buffer().write(CameraUtil.toByteArray(resultBitmap)).close()
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent =
                        Intent(this@Camera1SurfaceActivity, CameraPreviewActivity::class.java)
                    intent.putExtra("bitmap", imageFile.absolutePath)
                    startActivity(intent)
                }, 2000)
            }

            override fun onPreviewFrame(data: ByteArray?) = Unit
        })
    }

}