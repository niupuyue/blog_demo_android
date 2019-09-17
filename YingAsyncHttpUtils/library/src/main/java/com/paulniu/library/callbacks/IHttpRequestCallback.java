package com.paulniu.library.callbacks;

/**
 * Coder: niupuyue
 * Date: 2019/9/17
 * Time: 18:34
 * Desc:
 * Version:
 */
public interface IHttpRequestCallback {

    void onStart();

    void onResponse(String content);

    void onErrorResponse(String content);

    void onFinish();

}
