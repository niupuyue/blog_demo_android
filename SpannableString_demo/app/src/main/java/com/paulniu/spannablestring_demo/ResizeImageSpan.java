package com.paulniu.spannablestring_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/**
 * Coder: niupuyue
 * Date: 2019/11/21
 * Time: 14:38
 * Desc:
 * Version:
 */
public class ResizeImageSpan extends ImageSpan {

    public ResizeImageSpan(Context context, int res) {
        super(context, res);
    }

    public ResizeImageSpan(Drawable drawable){
        super(drawable);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        try {
            // 获取默认的drawable对象
            Drawable drawable = getDrawable();
            // 默认drawable所占有的矩形空间
            Rect rect = drawable.getBounds();
            // 判断当前尺寸大小
            if (fm != null) {
                Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
                int fontHeight = fmPaint.bottom - fmPaint.top;
                int drHeight = rect.bottom - rect.top;
                int top = drHeight / 2 - fontHeight / 4;
                int bottom = drHeight / 2 + fontHeight / 4;
                // 设置尺寸
                fm.ascent = -bottom;
                fm.top = -bottom;
                fm.bottom = top;
                fm.descent = top;
            }
            return rect.right;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        try {
            Drawable b = getDrawable();
            Paint.FontMetricsInt fm = paint.getFontMetricsInt();
            int transY = (y + fm.descent + y + fm.ascent) / 2 - b.getBounds().bottom / 2;
            canvas.save();
            canvas.translate(x, transY);
            b.draw(canvas);
            canvas.restore();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
