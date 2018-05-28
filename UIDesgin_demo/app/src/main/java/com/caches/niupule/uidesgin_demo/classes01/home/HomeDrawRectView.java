package com.caches.niupule.uidesgin_demo.classes01.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/5/28  下午5:25
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class HomeDrawRectView extends View {
    public HomeDrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#F7CF5E"));
        paint.setAntiAlias(true);

        canvas.drawRect(200,200,500,300,paint);
    }
}
