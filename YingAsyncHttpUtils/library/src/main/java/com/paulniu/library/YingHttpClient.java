package com.paulniu.library;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestHandle;
import com.paulniu.library.callbacks.IHttpDownloadcallback;
import com.paulniu.library.callbacks.IHttpRequestCallback;
import com.paulniu.library.constants.BaseConstants;
import com.paulniu.library.utils.BaseUtils;

import org.getopt.util.hash.FNV1a32;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.protocol.ClientContext;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.impl.cookie.BasicClientCookie;

/**
 * Coder: niupuyue
 * Date: 2019/9/17
 * Time: 17:46
 * Desc: AsyncHttpClient网络请求框架对象
 * Version:
 */
public class YingHttpClient {

    public static String UserAgent_Key = " ";
    public static final String User_Agent_Format_Before = "%1$s %2$s %3$s %4$s %5$s";
    public static final String User_Agent_Format = "/%1$s (%2$s; %3$s; %4$s; %5$s; cs:%6$s; ch:%7$s; v:%8$s;)";

    public static final String HttpContentType = "application/json;charset=UTF-8";
    public static final String HttpDownLoadContentType = "application/x-www-form-urlencoded";

    // 需要设置的cookie 每次请求都设置一次cookie对象(虽然会比较繁琐，但是请求精确)
    public static HashMap<String, String> yCookies;

    private static Gson gson = null;
    private static ByteArrayEntity postArrayEntity = null;

    private static AsyncHttpClient mHttpClient = null;

    /**
     * 设置agentkey值
     *
     * @param agentKey
     */
    public static void setUserAgentKey(String agentKey) {
        UserAgent_Key = agentKey;
    }

    /**
     * 获取Gson对象
     *
     * @return
     */
    public static Gson getGsonInstance() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
        return gson;
    }

    /**
     * 获取AsyncHttpClient请求对象
     *
     * @return
     */
    public static AsyncHttpClient getYingHttpClient() {
        if (mHttpClient == null) {
            mHttpClient = new AsyncHttpClient();
            // 初始化AsyncHttpClient对象
            initAsync();
        }
        return mHttpClient;
    }

    /**
     * 初始化AsyncHttpClient对象
     */
    private static void initAsync() {
        if (mHttpClient == null)
            return;
        // 设置支持最大并发数
        mHttpClient.setMaxConnections(BaseConstants.HTTP_MAX_CONNECTIONS_COUNT);
        // 设置超时
        mHttpClient.setTimeout(BaseConstants.HTTP_TIME_OUT);
        // 设置网络连接失败时重新请求的最大次数和请求超时时间
        mHttpClient.setMaxRetriesAndTimeout(BaseConstants.HTTP_RETRY_COUNT, BaseConstants.HTTP_TIME_OUT);
        // 设置网络SSL工厂，使用默认配置既可
        mHttpClient.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
        // 设置请求url编码,如果设置成true，则url会以铭文的形式展示
        mHttpClient.setURLEncodingEnabled(false);
        // 设置useragnet
//        mHttpClient.setUserAgent();
    }

    public static String getUserAgent(String userAgent) {
        String agent = "";
        try {
            PackageManager info = LibrariesCons.getContext().getPackageManager();
            PackageInfo packageInfo = info.getPackageInfo(LibrariesCons.getContext().getPackageName(), 0);

            String simpleVersionName;
            String[] arrVersionName = packageInfo.versionName.split("\\.");
            if (arrVersionName.length > 3)
                simpleVersionName = arrVersionName[0] + "." + arrVersionName[1] + "." + arrVersionName[2];
            else
                simpleVersionName = packageInfo.versionName;

            final String uuid = BaseUtils.getUUID();
            final String phoneInfo = String.format(User_Agent_Format_Before, simpleVersionName, android.os.Build.MODEL, "Android " + android.os.Build.VERSION.RELEASE, Locale.getDefault().toString(), uuid);
            FNV1a32 fnv1a32 = new FNV1a32();
            fnv1a32.init(phoneInfo + UserAgent_Key);
            final long hash = fnv1a32.getHash();
            final String cs = Long.toHexString(hash);

            agent = userAgent + String.format(User_Agent_Format, simpleVersionName, android.os.Build.MODEL, "Android " + android.os.Build.VERSION.RELEASE, Locale.getDefault().toString(), uuid, cs, packageInfo.versionName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return agent;
    }

    public static void setUserAgent(String userAgent) {
        getYingHttpClient().setUserAgent(getUserAgent(userAgent));
    }

    public static void setHttpCookie(HashMap<String,String> cookies){
        yCookies = cookies;
    }

    /**
     * 设置cookie
     */
    private static void setHttpCookie(String url){
        if (TextUtils.isEmpty(url) || yCookies == null){
            return;
        }
        try {
            PersistentCookieStore myCookieStore = new PersistentCookieStore(LibrariesCons.getContext());
            BasicClientCookie cookie;

            Uri uri = Uri.parse(url);

            for (Map.Entry<String, String> entry : yCookies.entrySet()) {
                cookie = new BasicClientCookie(entry.getKey(), entry.getValue());
                cookie.setDomain(uri.getHost());
                myCookieStore.addCookie(cookie);
            }

            if (!myCookieStore.getCookies().isEmpty()) {
                getYingHttpClient().setCookieStore(myCookieStore);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 设置代理，抓包使用
     * @param hostName
     * @param port
     */
    public static void setProxy(String hostName,int port){
        if (TextUtils.isEmpty(hostName) || port < 1)
            return;

        try {
            getYingHttpClient().setProxy(hostName, port);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取cookie
     */
    public static String getCookie(){
        String strCookie = "";

        try {
            PersistentCookieStore myCookies = (PersistentCookieStore) mHttpClient.getHttpContext().getAttribute(ClientContext.COOKIE_STORE);
            for (int i = 0; i < myCookies.getCookies().size(); i++) {
                strCookie += String.format(";%s=%s", myCookies.getCookies().get(i).getName(), myCookies.getCookies().get(i).getValue());
            }

            if (!TextUtils.isEmpty(strCookie)) {
                strCookie = strCookie.substring(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strCookie;
    }

    /**
     * 清除cookie  退出登录时必须清除
     */
    public static void clearCookie(){
        try {
            getYingHttpClient().setCookieStore(null);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 取消网络请求
     */
    public static void cancelRequests(Context context){
        try {
            getYingHttpClient().cancelRequests(context,true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * get请求
     */
    public static void get(Context context, String url, IHttpRequestCallback callback){
        get(context,url,0,callback);
    }

    public static RequestHandle get(Context context, String url, int retryCounts, final IHttpRequestCallback callback){
        try {
            if (null == context || TextUtils.isEmpty(url)){
                return null;
            }
            // cookie
            setHttpCookie(url);
            if (!BaseUtils.isNetworkAvailable()){
                if (null != callback){
                    callback.onErrorResponse("网络不给力，请稍后重试");
                    callback.onFinish();
                }
                return null;
            }
            if (null != callback){
                callback.onStart();
            }
            return getYingHttpClient().get(context, url, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    if (null != callback){
                        if (null != responseBody){
                            if (statusCode == 200){
                                callback.onResponse(new String(responseBody));
                            }else {
                                callback.onErrorResponse(new String(responseBody));
                            }
                        }
                        callback.onFinish();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    if (null != callback){
                        if (null != error && !TextUtils.isEmpty(error.getMessage())){
                            callback.onErrorResponse(error.getMessage());
                        }
                        callback.onFinish();
                    }
                }

            });
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static void post(Context context,String url,String json,IHttpRequestCallback callback){
        post(context,url,json,BaseConstants.HTTP_TIME_OUT,callback);
    }

    public static RequestHandle post(Context context, String url, String json, int timeout, final IHttpRequestCallback callback){
        if (null == context || TextUtils.isEmpty(url)){
            return null;
        }
        // 设置cookie
        setHttpCookie(url);
        if (!BaseUtils.isNetworkAvailable()){
            if (null != callback){
                callback.onErrorResponse("网络不给力，请稍后重试");
                callback.onFinish();
            }
            return null;
        }
        if (null != callback){
            callback.onStart();
        }
        try {
            postArrayEntity = new ByteArrayEntity(json.getBytes());
        }catch (Exception ex){
            ex.printStackTrace();
            postArrayEntity = null;
        }
        if (null == postArrayEntity){
            if (null != callback){
                callback.onErrorResponse("请求数据格式错误");
                callback.onFinish();
            }
            return null;
        }
        return getYingHttpClient().post(context, url, postArrayEntity, HttpContentType, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (null != callback){
                    callback.onResponse(new String(responseBody));
                    callback.onFinish();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (null != callback){
                    if (null != error && !TextUtils.isEmpty(error.getMessage())){
                        callback.onErrorResponse(error.getMessage());
                    }
                    callback.onFinish();
                }
            }
        });
    }

    /**
     * 下载文件
     */
    public static void download(Context context,String url,IHttpDownloadcallback callback){
        if (null == context || TextUtils.isEmpty(url)){
            return;
        }

    }

}
