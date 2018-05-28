package com.caches.niupule.uidesgin_demo.classes01;

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

/**
 * Created: niupule
 * Date: 2018/5/28  下午4:08
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class MethodDrawPathView extends View {
    //声明一个画笔
    private Paint paint = new Paint();
    //声明一个路径
    private Path path = new Path();
    public MethodDrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("#EF7164"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

        path.addArc(200,200,400,400,-255,255);
        path.arcTo(400,200,600,400,-180,255,false);
        path.lineTo(400,542);

        canvas.drawPath(path,paint);

        //path直接描述路径
        //添加圆
        path.addCircle(100,100,50, Path.Direction.CW);
        paint.setColor(Color.parseColor("#AFE56E"));
        canvas.drawPath(path,paint);

        path.addCircle(150,100,50, Path.Direction.CW);
        paint.setColor(Color.parseColor("#DA3A30"));
        canvas.drawPath(path,paint);


        //path除了可以添加圆形路径之外，还可以画一些比如椭圆形，矩形，圆角矩形等
        path.addOval(220,10,420,160, Path.Direction.CW);
        canvas.drawPath(path,paint);

        path.addRect(20,200,220,350, Path.Direction.CW);
        canvas.drawPath(path,paint);

        path.addRoundRect(240,200,440,350,30,30, Path.Direction.CW);
        canvas.drawPath(path,paint);

        //画线，可以是直线，也可以是曲线
        path.lineTo(50,50);
        canvas.drawPath(path,paint);
        path.rLineTo(100,50);
        canvas.drawPath(path,paint);

        //声明一个新的画笔
        Paint paintMoveTo = new Paint();
        paintMoveTo.setStyle(Paint.Style.STROKE);
        paintMoveTo.setColor(Color.parseColor("#96BF5B"));
        paintMoveTo.setAntiAlias(true);
        paintMoveTo.setStrokeWidth(3);

        //声明一个新的Path
        Path pathMoveTo = new Path();
        pathMoveTo.moveTo(20,300);
        pathMoveTo.lineTo(500,500);
        pathMoveTo.rLineTo(200,0);
        canvas.drawPath(pathMoveTo,paintMoveTo);

    }
}
