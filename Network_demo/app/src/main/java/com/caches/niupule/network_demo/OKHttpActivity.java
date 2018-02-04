package com.caches.niupule.network_demo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.caches.niupule.network_demo.untils.OKHttpManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created: niupule
 * Date: 2018/2/4  上午1:43
 * E-mail:niupuyue@aliyun.com
 * des: Okhttp
 */

public class OKHttpActivity extends Activity {

    public Button ok_get,ok_post;
    public TextView ok_show;
    private ImageView ok_img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        ok_show = findViewById(R.id.ok_show);
        ok_img = findViewById(R.id.ok_img);
        ok_get = findViewById(R.id.ok_get);
        ok_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                get("http://192.168.1.102:3000/login?username=牛谱乐&password=123456");
                /**
                 * 对Okhttp网络请求的简单封装
                 */
                OKHttpManager.getAsync("http://192.168.1.102:3000/getJobs", new OKHttpManager.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {

                    }

                    @Override
                    public void requestSuccess(String result) throws Exception {
                        ok_show.setText(result);
                    }
                });
//                OKHttpManager.postAsync();
//                OKHttpManager.downloadAsync();
            }
        });

        ok_post = findViewById(R.id.ok_post);
        ok_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post("http://192.168.1.102:3000/login",null);
            }
        });

    }

    public void get(String url){
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("response",response.body().toString());
                Log.i("test",response.body().string());

                //下载图片并且展示,注意要使用handler
//                InputStream is = response.body().byteStream();
//                Bitmap img = BitmapFactory.decodeStream(is);
//                ok_img.setImageBitmap(img);

            }
        });
    }

    public void post(String url, HashMap<String,String> map){
        OkHttpClient client = new OkHttpClient.Builder().build();
        RequestBody body = new FormBody.Builder().add("username","牛谱乐").add("password","123456").build();
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("response",response.body().string());
            }
        });
    }

}
