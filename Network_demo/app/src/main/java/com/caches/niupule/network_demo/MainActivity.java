package com.caches.niupule.network_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn01,btn02,btn03,btn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = findViewById(R.id.btn01);
        btn01.setOnClickListener(this);

        btn02 = findViewById(R.id.btn02);
        btn02.setOnClickListener(this);

        btn03 = findViewById(R.id.btn03);
        btn03.setOnClickListener(this);

        btn04 = findViewById(R.id.btn04);
        btn04.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn01){
            startActivity(new Intent(MainActivity.this,AsyncActivity.class));
        }else if(view.getId() == R.id.btn02){
            startActivity(new Intent(MainActivity.this,OKHttpActivity.class));
        }else if(view.getId() == R.id.btn03){
            startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
        }else if(view.getId() == R.id.btn04){
            startActivity(new Intent(MainActivity.this,BaseHttpActivity.class));
        }
    }
}
