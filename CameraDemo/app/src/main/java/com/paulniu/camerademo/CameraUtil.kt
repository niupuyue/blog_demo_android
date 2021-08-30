package com.paulniu.camerademo

import android.graphics.Bitmap
import android.graphics.Matrix
import java.io.ByteArrayOutputStream

/**
 * @author:Niu Puyue
 * e-mail:niupuyue@aliyun.com
 * time:8/30/21 6:12 PM
 * desc:
 */
object CameraUtil {

    fun mirror(rawBitmap: Bitmap): Bitmap {
        val matrix = Matrix()
        matrix.postScale(-1f, 1f)
        return Bitmap.createBitmap(rawBitmap, 0, 0, rawBitmap.width, rawBitmap.height, matrix, true)
    }

    fun rotate(rawBitmap: Bitmap, degree: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree)
        return Bitmap.createBitmap(rawBitmap, 0, 0, rawBitmap.width, rawBitmap.height, matrix, true)
    }

    fun toByteArray(bitmap: Bitmap): ByteArray {
        val os = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os)
        return os.toByteArray()
    }

}