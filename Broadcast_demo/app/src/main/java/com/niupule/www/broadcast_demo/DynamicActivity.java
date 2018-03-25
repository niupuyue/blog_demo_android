package com.niupule.www.broadcast_demo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/3/25  下午4:35
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class DynamicActivity extends Activity {

    DynamicBroadcast dynamicBroadcast = new DynamicBroadcast();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        //完成动态广播的注册
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("myIntent");
        registerReceiver(dynamicBroadcast,intentFilter);

        findViewById(R.id.send_dynamic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击之后发送广播
                Intent intent =  new Intent("myIntent");
                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicBroadcast);
    }
}
