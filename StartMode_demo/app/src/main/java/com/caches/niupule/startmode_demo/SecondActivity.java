package com.caches.niupule.startmode_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created: niupule
 * Date: 2018/3/25  下午4:13
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_second);

        ((TextView)findViewById(R.id.show_second)).setText(this.getTaskId()+"");

    }
}
