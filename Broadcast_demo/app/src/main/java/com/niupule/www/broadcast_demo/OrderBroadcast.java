package com.niupule.www.broadcast_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created: niupule
 * Date: 2018/3/25  下午5:04
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class OrderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("OrderBroadcast1","广播接收器1接收到了广播");
    }
}
