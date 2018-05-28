package com.caches.niupule.uidesgin_demo.classes01.home.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/5/28  下午5:15
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class HomeDrawColorView extends View {
    public HomeDrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //申请画笔
        Paint paint = new Paint();
        //画笔的样式
        paint.setStyle(Paint.Style.FILL);
        //画笔的粗细
        paint.setStrokeWidth(5);
        //画笔的抗锯齿
        paint.setAntiAlias(true);
        //设置画笔颜色
        paint.setColor(Color.RED);

        //设置背景颜色为浅蓝色
        canvas.drawColor(Color.parseColor("#5FACF6"));
    }
}
