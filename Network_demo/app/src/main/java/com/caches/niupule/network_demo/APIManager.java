package com.caches.niupule.network_demo;

import com.caches.niupule.network_demo.domain.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created: niupule
 * Date: 2018/2/4  下午4:06
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public interface APIManager {

    @GET("/login")
    Call<UserInfo> login(
            @Query("username") String username,
            @Query("password") String password
    );

}
