package com.paulniu.thedrawing;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created: niupule
 * Date: 2018/6/21  下午1:56
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class DisplayUtils {

    /**
     * 获取屏幕尺寸
     */
    public static final int getScreenHeight(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = manager.getDefaultDisplay().getHeight();
        return height;
    }
    public static final int getScreenWidth(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        return width;
    }


}
