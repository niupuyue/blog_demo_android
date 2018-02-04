package com.caches.niupule.network_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

/**
 * Created: niupule
 * Date: 2018/2/4  上午1:43
 * E-mail:niupuyue@aliyun.com
 * des: sync_http
 * 其实async——http就是把httpClient进行了分装，所以并不是很好用，在2015年刚毕业的时候有使用过一段时间，后面的时候就改成了volley，然后又是OKhttp
 */

public class AsyncActivity extends Activity {

    private Button async_send;
    private TextView async_show;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        async_show = findViewById(R.id.async_show);
        async_send = findViewById(R.id.async_send);
        async_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://192.168.1.102:3000/getJobs", new TextHttpResponseHandler() {


                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.i("test",responseString.toString());
                        async_show.setText(responseString.toString());
                    }
                });
            }
        });

    }
}
