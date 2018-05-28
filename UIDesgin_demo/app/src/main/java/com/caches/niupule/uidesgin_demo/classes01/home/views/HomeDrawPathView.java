package com.caches.niupule.uidesgin_demo.classes01.home.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/5/28  下午5:43
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class HomeDrawPathView extends View {
    public HomeDrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint1 = new Paint();
        paint1.setColor(Color.parseColor("#D9362C"));
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(5);

        Path path1 = new Path();
        path1.lineTo(250,300);
        path1.rLineTo(50,0);

        canvas.drawPath(path1,paint1);

        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#3E7FE7"));
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(5);
        paint2.setStyle(Paint.Style.STROKE);

        Path path2 = new Path();
        path2.moveTo(100,350);
        path2.rLineTo(80,0);
        path2.rLineTo(200,-150);

        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setColor(Color.BLACK);
        paint3.setAntiAlias(true);

        canvas.drawText("test",390,190,paint3);
        canvas.drawPath(path2,paint2);
    }
}
