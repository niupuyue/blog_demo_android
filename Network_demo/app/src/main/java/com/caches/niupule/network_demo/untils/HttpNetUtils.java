package com.caches.niupule.network_demo.untils;

import android.os.Handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created: niupule
 * Date: 2018/2/4  下午2:07
 * E-mail:niupuyue@aliyun.com
 * des: 原生请求工具类
 */

public class HttpNetUtils {

    public static void get(final String url, final NetworkCallback callback){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String data = useGet(url);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResponse(data);
                    }
                });
            }
        }).start();
    }

    public static void use(final String url,final NetworkCallback callback){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String data = usePost(url);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResponse(data);
                    }
                });
            }
        }).start();
    }

    private static String useGet(String url){
        HttpURLConnection connection = null;
        try {
            URL mURL = new URL(url);
            connection = (HttpURLConnection) mURL.openConnection();

            int responseCode = connection.getResponseCode();
            if(responseCode == 200){
                InputStream is = connection.getInputStream();
                String data = formatStream(is);
                return data;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

    private static String usePost(String url){
        HttpURLConnection connection = null;
        try {
            URL mURL = new URL(url);
            connection = (HttpURLConnection) mURL.openConnection();

            int responseCode = connection.getResponseCode();
            if(responseCode == 200){
                InputStream inputStream = connection.getInputStream();
                String data = formatStream(inputStream);
                return data;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

    private static String formatStream(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        is.close();
        String data = os.toString();
        os.close();
        return data;
    }

    public interface NetworkCallback{
        String onResponse(String response);
    }

}
