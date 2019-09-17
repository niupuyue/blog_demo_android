package com.paulniu.library.callbacks;

/**
 * Coder: niupuyue
 * Date: 2019/9/17
 * Time: 18:54
 * Desc:
 * Version:
 */
public interface IHttpDownloadcallback {

    void onStart();

    void onResponse(byte[] fileByte);

    void onProgress(int process);

    void onErrorResponse(String content);

    void onFinish();

}
