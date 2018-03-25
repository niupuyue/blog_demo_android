package com.niupule.www.broadcast_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created: niupule
 * Date: 2018/3/25  下午4:58
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class DynamicBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收到自定义的无需广播，而且是动态注册
        Log.i("DynamicBroadCast","获取到自定义广播");
    }
}
