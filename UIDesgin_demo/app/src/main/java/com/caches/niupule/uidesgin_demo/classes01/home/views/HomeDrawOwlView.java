package com.caches.niupule.uidesgin_demo.classes01.home.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/5/28  下午5:27
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class HomeDrawOwlView extends View {
    public HomeDrawOwlView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#D0896B"));
        paint.setAntiAlias(true);

        canvas.drawOval(200,200,500,400,paint);
    }
}
