package com.paulniu.spannablestring_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Coder: niupuyue
 * Date: 2019/11/21
 * Time: 10:57
 * Desc:
 * Version:
 */
public class SetSpanActivity extends AppCompatActivity {

    SpannableStringBuilder sb ;
    ForegroundColorSpan span;
    final String ss = "这是测试的文字";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setspan);

        sb = new SpannableStringBuilder();
        sb.append(ss);
        span = new ForegroundColorSpan(Color.RED);
        sb.setSpan(span,2,4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        EditText et1 = findViewById(R.id.setspan01);
        et1.setText(sb);

        sb = new SpannableStringBuilder();
        sb.append(ss);
        span = new ForegroundColorSpan(Color.RED);
        sb.setSpan(span,2,4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        EditText et2 = findViewById(R.id.setspan01);
        et2.setText(sb);

        sb = new SpannableStringBuilder();
        sb.append(ss);
        span = new ForegroundColorSpan(Color.RED);
        sb.setSpan(span,2,4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        EditText et3 = findViewById(R.id.setspan01);
        et3.setText(sb);

        sb = new SpannableStringBuilder();
        sb.append(ss);
        span = new ForegroundColorSpan(Color.RED);
        sb.setSpan(span,2,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        EditText et4 = findViewById(R.id.setspan01);
        et4.setText(sb);

    }
}
