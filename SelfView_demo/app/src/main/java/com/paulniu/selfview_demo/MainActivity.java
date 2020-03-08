package com.paulniu.selfview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn01;
    private Button btn02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToLayoutView();
            }
        });

        btn02 = findViewById(R.id.btn02);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToDrawView();
            }
        });
    }

    public void jumpToLayoutView(){
        startActivity(new Intent(MainActivity.this,LayoutViewActivity.class));
    }

    public void jumpToDrawView(){
        startActivity(new Intent(MainActivity.this,DrawViewActivity.class));
    }

    public static List<BarrageView.RecentApplyModel> getBarrageData(){
        List<BarrageView.RecentApplyModel> res = new ArrayList<>();
        BarrageView.RecentApplyModel model1 = new BarrageView.RecentApplyModel();
        model1.name = "张三";
        model1.content = "弹幕内容--1";
        res.add(model1);
        BarrageView.RecentApplyModel model2 = new BarrageView.RecentApplyModel();
        model2.name = "李四";
        model2.content = "弹幕内容--2";
        res.add(model2);
        BarrageView.RecentApplyModel model3 = new BarrageView.RecentApplyModel();
        model3.name = "王五";
        model3.content = "弹幕内容--3";
        res.add(model3);
        BarrageView.RecentApplyModel model4 = new BarrageView.RecentApplyModel();
        model4.name = "赵六";
        model4.content = "弹幕内容--4";
        res.add(model4);
        return res;
    }
}
