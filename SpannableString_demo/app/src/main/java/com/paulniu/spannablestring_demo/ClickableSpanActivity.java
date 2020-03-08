package com.paulniu.spannablestring_demo;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Coder: niupuyue
 * Date: 2019/11/21
 * Time: 14:52
 * Desc:
 * Version:
 */
public class ClickableSpanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickable);

        TextView textView = findViewById(R.id.tvClick);

        SpannableStringBuilder sb = new SpannableStringBuilder();
        String ss = "这是测试文字";
        sb.append(ss);
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(ClickableSpanActivity.this, "点击了文字", Toast.LENGTH_LONG).show();
            }
        };
        sb.setSpan(span, sb.length() - 2, sb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        sb.setSpan(colorSpan, sb.length() - 2, sb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(sb);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
