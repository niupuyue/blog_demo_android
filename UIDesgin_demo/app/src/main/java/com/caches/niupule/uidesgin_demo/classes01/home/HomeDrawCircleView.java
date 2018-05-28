package com.caches.niupule.uidesgin_demo.classes01.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/5/28  下午5:19
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class HomeDrawCircleView extends View {
    public HomeDrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        DisplayMetrics dm = new DisplayMetrics();
        int heigth = dm.heightPixels;
        int width = dm.widthPixels;

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#AFE56E"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);

        canvas.drawCircle(width/2,heigth/2,100,paint);


    }
}
