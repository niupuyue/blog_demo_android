package com.paulniu.spannablestring_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Coder: niupuyue
 * Date: 2019/11/21
 * Time: 11:44
 * Desc:
 * Version:
 */
public class ForgegroundColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_color);

        TextView tvColor = findViewById(R.id.tvColor);
        SpannableStringBuilder sb = new SpannableStringBuilder();
        sb.append("测试字体颜色");
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);
        sb.setSpan(redSpan,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.GREEN);
        sb.setSpan(greenSpan,2,4,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan blueSpan = new ForegroundColorSpan(Color.BLUE);
        sb.setSpan(blueSpan,4,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvColor.setText(sb);
    }
}
