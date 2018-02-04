package com.caches.niupule.network_demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.caches.niupule.network_demo.untils.HttpNetUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created: niupule
 * Date: 2018/2/4  上午1:59
 * E-mail:niupuyue@aliyun.com
 * des: 原生请求
 */

public class BaseHttpActivity extends Activity {

    public Button btn_get, btn_post;
    public TextView base_show;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //httpclient已经被弃用了，所以这里不写
        setContentView(R.layout.activity_base);

        base_show = findViewById(R.id.base_show);

        btn_get = findViewById(R.id.btn_get);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 异步处理
                 * 但是这样的方式比较low，我们可以写一个工具类
                 */
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        final String data = useGet("http://192.168.1.102:3000/getJobs");
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                base_show.setText(data);
//                            }
//                        });
//                    }
//                }).start();

                HttpNetUtils.get("http://192.168.1.102:3000/getJobs", new HttpNetUtils.NetworkCallback() {
                    @Override
                    public String onResponse(String response) {
                        base_show.setText(response);
                        return null;
                    }
                });

            }
        });

        btn_post = findViewById(R.id.btn_post);
        btn_post.setText("post请求就没有写。自己改");
        btn_post.setEnabled(false);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String data = usePost("我是要发送的内容", "http://www.baidu.com");
                        Log.i("test",data);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                base_show.setText(data);
                            }
                        });
                    }
                }).start();
            }
        });

    }

    public String usePost(String value, String url) {
        HttpURLConnection connection = null;
        try {
            URL mURL = new URL(url);
            connection = (HttpURLConnection) mURL.openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("POST");
            String data = value;
            OutputStream os = connection.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream is = connection.getInputStream();
                String response = getStringFromInputStream(is);
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    public String useGet(String url) {
        HttpURLConnection connection = null;
        try {
            URL mURL = new URL(url);
            connection = (HttpURLConnection) mURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream is = connection.getInputStream();
                String response = getStringFromInputStream(is);
                return response;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    public String getStringFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        is.close();
        String data = baos.toString();
        Log.i("from", data);
        baos.close();
        return data;
    }
}
