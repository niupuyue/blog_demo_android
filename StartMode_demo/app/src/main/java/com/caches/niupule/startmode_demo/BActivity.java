package com.caches.niupule.startmode_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created: niupule
 * Date: 2018/3/25  下午4:05
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class BActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        ((TextView) findViewById(R.id.b_show)).setText(this.toString());

        findViewById(R.id.btn03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, MainActivity.class));
            }
        });

    }
}
