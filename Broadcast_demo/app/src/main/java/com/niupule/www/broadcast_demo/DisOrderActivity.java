package com.niupule.www.broadcast_demo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created: niupule
 * Date: 2018/3/25  下午4:30
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class DisOrderActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disorder);


    }

    class DisOrderBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //无序广播接收到，就可以直接执行了
            //如果有人打电话则会接收到当前的状态
            Log.i("DisOrderBroadcast","获取到了广播");
        }
    }


}


