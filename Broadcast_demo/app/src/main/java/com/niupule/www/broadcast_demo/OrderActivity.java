package com.niupule.www.broadcast_demo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/3/25  下午4:31
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class OrderActivity extends Activity {


    OrderBroadcast orderBroadcast = new OrderBroadcast();
    OrderBroadcast2 orderBroadcast2 = new OrderBroadcast2();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("myOrderBroadcast");
        intentFilter1.setPriority(100);

        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("myOrderBroadcast");
        intentFilter2.setPriority(101);

        registerReceiver(orderBroadcast,intentFilter1);
        registerReceiver(orderBroadcast2,intentFilter2);

        findViewById(R.id.send_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent("myOrderBroadcast");
                sendOrderedBroadcast(intent,null);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(orderBroadcast);
        unregisterReceiver(orderBroadcast2);
    }
}
