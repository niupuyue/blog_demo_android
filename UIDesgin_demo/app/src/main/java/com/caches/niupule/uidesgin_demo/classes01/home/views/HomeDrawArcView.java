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
 * Date: 2018/5/28  下午5:32
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class HomeDrawArcView extends View {
    public HomeDrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        paint1.setColor(Color.parseColor("#E75375"));
        canvas.drawArc(200,200,400,400,0,90,true,paint1);

        paint1.setColor(Color.parseColor("#AFE56E"));
        canvas.drawArc(200,200,400,400,90,60,true,paint1);

        paint1.setColor(Color.parseColor("#F7CF5E"));
        canvas.drawArc(200,200,400,400,150,90,true,paint1);

        paint1.setColor(Color.parseColor("#4986D0"));
        canvas.drawArc(200,200,400,400,240,45,true,paint1);

        paint1.setColor(Color.parseColor("#F19C38"));
        canvas.drawArc(200,200,400,400,285,75,true,paint1);

        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.parseColor("#E75375"));
        canvas.drawArc(200,700,400,900,0,90,false,paint2);

        paint2.setColor(Color.parseColor("#AFE56E"));
        canvas.drawArc(200,700,400,900,90,60,false,paint2);

        paint2.setColor(Color.parseColor("#F7CF5E"));
        canvas.drawArc(200,700,400,900,150,90,false,paint2);

        paint2.setColor(Color.parseColor("#4986D0"));
        canvas.drawArc(200,700,400,900,240,45,false,paint2);

        paint2.setColor(Color.parseColor("#F19C38"));
        canvas.drawArc(200,700,400,900,285,75,false,paint2);

    }
}
