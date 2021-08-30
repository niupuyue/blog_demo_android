package com.paulniu.camerademo

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

/**
 * @author:Niu Puyue
 * e-mail:niupuyue@aliyun.com
 * time:8/30/21 5:58 PM
 * desc:
 */
class CameraPreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camera_preview_layout)
        val bitmap: String? = intent.getStringExtra("bitmap")
        val imageView = findViewById<ImageView>(R.id.camera_preview_image)
        Glide.with(this).load(bitmap).into(imageView)
    }

}