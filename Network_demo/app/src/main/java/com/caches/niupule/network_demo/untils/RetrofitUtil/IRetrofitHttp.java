package com.caches.niupule.network_demo.untils.RetrofitUtil;

import com.caches.niupule.network_demo.domain.Info;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created: niupule
 * Date: 2018/2/5  下午11:37
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public interface IRetrofitHttp {

    String getUrl = "getJobs";
    String postUrl = "list.from";

    /**
     * 传递参数的Get请求
     *
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @GET(getUrl)
    Call<Info> get(
            @Query("key") String key,
            @Query("sort") String sort,
            @Query("time") String time
    );

    /**
     * 已经封装好的url路径
     *
     * @return
     */
    @GET(getUrl + "?key=488c65f3230c0280757b50686d1f1cd5&&sort=asc&&time=1418816972")
    Call<Info> get();

    /**
     * 传递map集合
     *
     * @param params
     * @return
     */
    @GET(getUrl)
    Call<Info> get(
            @QueryMap Map<String, String> params
    );

    /**
     * 传递参数的post请求
     *
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> post(
            @Field("key") String key,
            @Field("sort") String sort,
            @Field("time") String time
    );

    /**
     * 传递Map键值对的Post请求
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> post(
            @FieldMap Map<String, String> params
    );


    /**
     * 传递Map键值对和Header的Post请求
     *
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @Headers({
            "os:Android",
            "version:2.0"
    })
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> postWithHeader(
            @Field("key") String key,
            @Field("sort") String sort,
            @Field("time") String time
    );

    /**
     * 传递Map键值对和Header的Post请求
     *
     * @param os
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> postWithHeader(
            @Header("os") String os,
            @Field("key") String key,
            @Field("sort") String sort,
            @Field("time") String time
    );

    /**
     * 传递Map键值对和Header的Post请求
     *
     * @param params
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> postWithHeader(
            @HeaderMap Map<String, String> params,
            @Field("key") String key,
            @Field("sort") String sort,
            @Field("time") String time
    );

    /**
     * 传递访问路径和键值对的Post请求
     *
     * @param path
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST("{post}")
    Call<Info> post(
            @Path("path") String path,
            @Field("key") String key,
            @Field("sort") String sort,
            @Field("time") String time
    );

}
