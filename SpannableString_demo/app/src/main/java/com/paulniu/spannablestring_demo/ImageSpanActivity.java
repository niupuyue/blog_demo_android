package com.paulniu.spannablestring_demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Coder: niupuyue
 * Date: 2019/11/21
 * Time: 11:59
 * Desc:
 * Version:
 */
public class ImageSpanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagespan);
        TextView tvImage = findViewById(R.id.tvImage);

        SpannableStringBuilder sb = new SpannableStringBuilder();
        String ss = "这是测试文字a";
        sb.append(ss);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.aliwx_s001);
        Drawable drawable = new BitmapDrawable(bitmap);
        if (drawable != null){
            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        }
        ResizeImageSpan span = new ResizeImageSpan(drawable);
        sb.setSpan(span, ss.length() - 1, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvImage.setText(sb);
    }
}
