package com.caches.niupule.network_demo.untils;

import com.caches.niupule.network_demo.domain.Info;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
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
 * Date: 2018/2/4  下午7:46
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class RetrofitManager {

    /**
     * retrofit是以REST请求方式发送请求的，因此封装需要两次
     * 1. 对REST请求进行封装
     * 2. retrofit对自身的封装
     */

    /**
     * 这里我使用的是本地的数据，所以，内容样式是固定的
     * 所以这里使用API接口: http://v.juhe.cn/joke/content/list.php?key=488c65f3230c0280757b50686d1f1cd5&&sort=asc&&time=1418816972
     *
     */

    /**
     * 1. 对REST请求的API进行封装
     * Get请求相关
     *
     * @Get：发送Get请求
     * @Query：Get请求参数
     * @QueryMap：Get请求Map参数 Post请求相关
     * @Post：发送Post请求
     * @FormUrlEncoded：采用表单的方式，一般与@Post共用
     * @Field：Post请求参数
     * @FieldMap：Post请求Map参数 Header请求相关
     * @Headers：发送Header信息
     * @Header：Header信息参数
     * @HeaderMap：Header信息的Map参数 Path请求相关
     * @Path：访问路径，最终访问BaseUrl+@Path里面的内容
     */

    public interface IRetrofitServer {

        String getUrl = "list.from";
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

    /**
     * 2. Retrofit自身的封装
     * Retrofit和okHttp一样，采用构造者模式创建，采用单例模式防止使用多个对象
     */
    private static final String baseUrl = "http://japi.juhe.cn/joke/content/";
    private static Retrofit retrofit;
    private static IRetrofitServer iServer;

    public static IRetrofitServer getInstance(){
        if(retrofit == null){
            synchronized (RetrofitManager.class){
                if(retrofit == null){
                    retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    iServer = retrofit.create(IRetrofitServer.class);
                }
            }
        }
        return iServer;
    }


}
