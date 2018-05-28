package com.caches.niupule.uidesgin_demo.classes01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import static java.lang.Math.*;

/**
 * Created: niupule
 * Date: 2018/5/28  下午2:49
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class MethodDrawView extends View {
    //声明一个画笔
    private Paint paint = new Paint();

    public MethodDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //重写onDraw方法既可以实现具体的操作

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        //此处super方法不能不写
        super.onDraw(canvas);
        //设置画笔样式
        paint.setStyle(Paint.Style.FILL);
        //设置画笔颜色
        paint.setColor(Color.RED);
        //设置线条的宽度
        paint.setStrokeWidth(2);
        //设置文字大小
        paint.setTextSize(12);
        //设置是否打开抗锯齿开关
        paint.setAntiAlias(true);

        //设置颜色
        canvas.drawColor(Color.parseColor("#8DCEF1"));
        //除此之外还有两外两种方法设置颜色
        /**
         * canvas.drawRGB(100, 200, 100);
         * canvas.drawARGB(100, 100, 200, 100);
         */

        //画一个圆形
        canvas.drawCircle(200,200,50,paint);
        //此时使用的paint的style是fill，如果改成别的样式就是另外一宗情况了
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500,500,60,paint);
        //如果现在我们想要第一个元和第三个圆紧挨着，那就再写一个环圈
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#AFE56E"));
        canvas.drawCircle(((float)(200+50* Math.sqrt(2))) , ((float)(200 + 50 * Math.sqrt(2))),50,paint);

        //画一个矩形
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#C27E5A"));
        canvas.drawRect(50,400,250,600,paint);

        //画一个点
        //设置画笔的宽度,默认的样子是矩形
        paint.setStrokeWidth(20);
        paint.setColor(Color.parseColor("#2B2B2B"));
        canvas.drawPoint(50,50,paint);

        //设置一个圆形的点
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.parseColor("#E1483C"));
        canvas.drawPoint(70,70,paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(90,90,paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(110,110,paint);

        //也可以一次执行多个点操作

        //画一个椭圆
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(50,650,450,850,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(new RectF(50,900,650,1200),paint);

        //划一根线
        canvas.drawLine(300,100,500,100,paint);

        //画一个圆角的矩形
        canvas.drawRoundRect(350,300,550,460,10,10,paint);

        //画一个扇形
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#F7CF5F"));
        canvas.drawArc(20,300,170,450,0,60,true,paint);

        //实现一个类似于饼状图的内容
        paint.setColor(Color.parseColor("#8FB55C"));
        canvas.drawArc(20,300,170,450,60,120,true,paint);

        paint.setColor(Color.parseColor("#CD93E2"));
        canvas.drawArc(20,300,170,450,180,45,true,paint);

        paint.setColor(Color.parseColor("#EF7164"));
        canvas.drawArc(20,300,170,450,-135,60,true,paint);

        paint.setColor(Color.BLACK);
        canvas.drawArc(20,300,170,450,-75,45,false,paint);
    }
}
