package com.paulniu.camerademo

import android.content.Context
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager

/**
 * @author:Niu Puyue
 * e-mail:niupuyue@aliyun.com
 * time:8/30/21 5:26 PM
 * desc:
 */
object DensityUtil {
    /**
     * 获取屏幕高度
     */
    fun getScreenH(aty: Context): Int {
        val wm = aty.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay?.getMetrics(outMetrics)
        return outMetrics.heightPixels
    }

    /**
     * 获取屏幕的宽度
     *
     * @param context 上下文对象
     */
    fun getScreenWidth(context: Context): Int {
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = manager.defaultDisplay
        return display.width
    }

    /**
     * 获取屏幕的高度
     *
     * @param context 上下文对象
     */
    fun getScreenHeight(context: Context): Int {
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = manager.defaultDisplay
        return display.height
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    @JvmStatic
    fun dp2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

}