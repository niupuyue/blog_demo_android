package com.paulniu.selfview_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Coder: niupuyue
 * Date: 2019/11/20
 * Time: 17:39
 * Desc:
 * Version:
 */
public class DrawBaseView extends View {

    Paint mPaint = new Paint();

    public DrawBaseView(Context context) {
        super(context);
    }

    public DrawBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 这句话不能省略
        super.onDraw(canvas);
        canvas.drawCircle(100,100,50,mPaint);
    }
}
