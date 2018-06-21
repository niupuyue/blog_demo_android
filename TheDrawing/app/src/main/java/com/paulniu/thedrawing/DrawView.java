package com.paulniu.thedrawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/6/21  上午11:50
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class DrawView extends View {
    float preX;
    float preY;
    private Path path;
    public Paint paint;

    final int VIEW_WIDTH = 320;
    final int VIEW_HEIGHT = 480;

    //声明一个bitmap对象，用来缓存数据
    Bitmap cacheBitmap = null;
    //定义哥cache用来显示所有的基类
    Canvas cacheCanvas = null;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        cacheBitmap = Bitmap.createBitmap(DisplayUtils.getScreenWidth(context),DisplayUtils.getScreenHeight(context), Bitmap.Config.ARGB_8888);

        cacheCanvas = new Canvas();
        path = new Path();
        cacheCanvas.setBitmap(cacheBitmap);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取拖动事件发生的位置
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX,preY,x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path,paint);
                path.reset();
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint bmpPaint = new Paint();
        canvas.drawBitmap(cacheBitmap,0,0,bmpPaint);
        canvas.drawPath(path,paint);
    }
}
