package com.caches.niupule.uidesgin_demo.classes02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/5/28  下午8:46
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class ShaderView extends View {
    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //线性渐变
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Shader shader = new LinearGradient(100,100,400,400, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(250,250,110,paint);

        //辐射渐变
        Paint paint1 =new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        Shader shader1 = new RadialGradient(300,300,200,Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint1.setShader(shader);
        canvas.drawCircle(500,500,120,paint1);

    }
}
