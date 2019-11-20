package com.paulniu.selfview_demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Coder: niupuyue
 * Date: 2019/11/20
 * Time: 17:03
 * Desc:
 * Version:
 */
public class LayoutViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_view);

        BarrageView jobDetailBarrageView = findViewById(R.id.jobDetailBarrageView);
        jobDetailBarrageView.setRecentTips(MainActivity.getBarrageData());
        jobDetailBarrageView.start();
    }
}
