package com.niupule.www.broadcast_demo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

/**
 * Created: niupule
 * Date: 2018/3/25  下午4:31
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class LocalBroadcastActivity extends Activity {
    LocalBroadcastReveiver broadcastReveiver = new LocalBroadcastReveiver();
    IntentFilter intentFilter;
    LocalBroadcastManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        intentFilter = new IntentFilter();
        intentFilter.addAction("myLocalBroadcast");

        manager = LocalBroadcastManager.getInstance(this);

        manager.registerReceiver(broadcastReveiver,intentFilter);

        findViewById(R.id.send_local).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("myLocalBroadcast");
                manager.sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.unregisterReceiver(broadcastReveiver);
    }
}
