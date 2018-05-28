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
 * Date: 2018/5/28  下午5:54
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class Home1View extends View {
    public Home1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint4XY = new Paint();
        paint4XY.setStyle(Paint.Style.STROKE);
        paint4XY.setColor(Color.BLACK);
        paint4XY.setStrokeWidth(1);

        Path pathx = new Path();
        pathx.moveTo(20,800);
        pathx.rLineTo(650,0);
        canvas.drawPath(pathx,paint4XY);

        Path path4y = new Path();
        path4y.moveTo(20,800);
        path4y.rLineTo(0,-750);
        canvas.drawPath(path4y,paint4XY);

        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(Color.RED);

        canvas.drawRect(50,300,150,800,paint1);

        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.BLUE);

        canvas.drawRect(190,480,290,800,paint2);

        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(Color.GRAY);

        canvas.drawRect(330,690,430,800,paint3);

        Paint paint4 = new Paint();
        paint4.setColor(Color.parseColor("#F6CD5D"));
        paint4.setStyle(Paint.Style.FILL);

        canvas.drawRect(470,500,570,800,paint4);

        canvas.drawText("一月",80,820,paint1);
        canvas.drawText("二月",220,820,paint2);
        canvas.drawText("三月",360,820,paint3);
        canvas.drawText("四月",500,820,paint4);

    }
}
