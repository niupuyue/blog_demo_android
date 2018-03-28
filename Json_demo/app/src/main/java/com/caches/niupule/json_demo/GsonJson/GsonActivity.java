package com.caches.niupule.json_demo.GsonJson;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.caches.niupule.json_demo.BaseRecycleAdapter;
import com.caches.niupule.json_demo.Bean.Movie;
import com.caches.niupule.json_demo.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created: niupule
 * Date: 2018/3/28  上午11:38
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class GsonActivity extends Activity {

    RecyclerView recyclerView;
    BaseRecycleAdapter adapter ;
    List<Movie.SubjectsBean> movies = new ArrayList<>();

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                recyclerView.setAdapter(adapter = new BaseRecycleAdapter(movies,GsonActivity.this));
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        recyclerView = findViewById(R.id.gson_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //初始化数据
        initData();

    }

    public void initData(){
        String url = "https://api.douban.com/v2/movie/in_theaters";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("gson",json);
                Movie movie = new Gson().fromJson(json,Movie.class);
                movies = movie.getSubjects();
                Message msg = Message.obtain();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        });
    }


}
