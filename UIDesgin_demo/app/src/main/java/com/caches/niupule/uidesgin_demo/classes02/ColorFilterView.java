package com.caches.niupule.uidesgin_demo.classes02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.caches.niupule.uidesgin_demo.R;

/**
 * Created: niupule
 * Date: 2018/5/29  上午10:57
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class ColorFilterView extends View {
    public ColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);

        ColorFilter filter = new LightingColorFilter(0x00ffff, 0x003000);
        paint.setColorFilter(filter);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.photo);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

        canvas.drawCircle(450,350,220,paint);

        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);

        ColorFilter filter1 = new LightingColorFilter(0xfff000,0x340045);
        paint.setColorFilter(filter1);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.photo);
        paint1.setShader(new BitmapShader(bitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP));

        canvas.drawCircle(450,630,220,paint1);


        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.RED);


    }
}
