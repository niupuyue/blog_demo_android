package com.caches.niupule.network_demo.untils.RetrofitUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created: niupule
 * Date: 2018/2/5  下午11:37
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class RetrofitUtil {

    public static String baseUrl = "http://192.168.1.102:3000/";

    public static Retrofit retrofit;
    public static IRetrofitHttp iRetrofitHttp;

    public static IRetrofitHttp getInstance(){
        if(retrofit == null){
            synchronized (IRetrofitHttp.class){
                if(retrofit == null){
                    retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    iRetrofitHttp = retrofit.create(IRetrofitHttp.class);
                }
            }
        }
        return iRetrofitHttp;
    }

}
