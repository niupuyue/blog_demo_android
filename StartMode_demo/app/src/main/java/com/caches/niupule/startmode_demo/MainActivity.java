package com.caches.niupule.startmode_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 默认模式，不管当前的task中是否已经存在想要打开的Activity，都会创建一个新的
         */
        textView = (TextView) findViewById(R.id.show);
//        textView.setText(this.toString());
        textView.setText(MainActivity.this.getTaskId()+"");

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        /**
         * 通过设置清单配置文件中的模式，可以实现栈顶复用模式
         */

        /**
         * 通过设置清单配置文件的模式，可以实现站内复用模式
         * MainActivity  ---  AActivity  ---  BActivity  --- MainActivity
         */
        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AActivity.class));
            }
        });

        findViewById(R.id.btn_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

    }
}
