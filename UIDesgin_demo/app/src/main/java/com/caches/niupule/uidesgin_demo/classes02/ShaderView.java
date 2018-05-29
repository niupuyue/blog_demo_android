package com.caches.niupule.uidesgin_demo.classes02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.caches.niupule.uidesgin_demo.R;

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
        paint1.setShader(shader1);
        canvas.drawCircle(500,500,120,paint1);

        //设置图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.photo);
        //设置当图片的大小不够图形额距离的时候进行拉伸
        Shader shader2 = new BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(5);
        paint2.setShader(shader2);

        canvas.drawCircle(250,600,110,paint2);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Shader shader3 = new BitmapShader(bitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint3.setStrokeWidth(5);
        paint3.setShader(shader3);
        canvas.drawRect(400,100,700,250,paint3);

    }
}
