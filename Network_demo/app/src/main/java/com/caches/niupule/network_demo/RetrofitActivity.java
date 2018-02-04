package com.caches.niupule.network_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.caches.niupule.network_demo.domain.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created: niupule
 * Date: 2018/2/4  上午1:44
 * E-mail:niupuyue@aliyun.com
 * des: Retrofit
 */

public class RetrofitActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.1.102:3000")
                .build();
        APIManager api = retrofit.create(APIManager.class);
        Call<UserInfo> call = api.login("牛谱乐","123456");
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                //成功
                Log.i("response",response.body().getUser_name());
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {

            }
        });

    }
}
