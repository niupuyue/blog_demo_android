package com.caches.niupule.uidesgin_demo.classes01.home.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.io.File;

/**
 * Created: niupule
 * Date: 2018/5/28  下午5:55
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class Home2View extends View {
    public Home2View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#F8F8F8"));

        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(Color.parseColor("#D84F3A"));
        paint1.setAntiAlias(true);
        canvas.drawArc(200,200,600,600,0,30,true,paint1);

        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.parseColor("#F0C22C"));
        paint2.setAntiAlias(true);
        canvas.drawArc(200,200,600,600,30,45,true,paint2);

        Paint pain3 = new Paint();
        pain3.setStyle(Paint.Style.FILL);
        pain3.setColor(Color.parseColor("#8B32AD"));
        pain3.setAntiAlias(true);
        canvas.drawArc(200,200,600,600,75,60,true,pain3);

        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.FILL);
        paint4.setColor(Color.parseColor("#4F9488"));
        paint4.setAntiAlias(true);
        canvas.drawArc(200,200,600,600,135,50,true,paint4);

        Paint paint5 = new Paint();
        paint5.setStyle(Paint.Style.FILL);
        paint5.setColor(Color.parseColor("#5895F0"));
        paint5.setAntiAlias(true);
        canvas.drawArc(200,200,600,600,185,66,true,paint5);

        Paint paint6 = new Paint();
        paint6.setStyle(Paint.Style.FILL);
        paint6.setColor(Color.parseColor("#99486A"));
        paint6.setAntiAlias(true);
        canvas.drawArc(200,200,600,600,251,46,true,paint6);

        Paint paint7 = new Paint();
        paint7.setColor(Color.parseColor("#596D79"));
        paint7.setStyle(Paint.Style.FILL);
        paint7.setAntiAlias(true);
        canvas.drawArc(200,200,600,600,297,63,true,paint7);

        Path path1 = new Path();
        Paint paint41 = new Paint();
        paint41.setStyle(Paint.Style.STROKE);
        paint41.setColor(Color.BLACK);
        paint41.setAntiAlias(true);
        path1.moveTo(400,200);
        path1.rLineTo(70,-130);
        path1.rLineTo(50,0);
        canvas.drawPath(path1,paint41);
        canvas.drawText("一月",540,80,paint41);



    }
}
