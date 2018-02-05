package com.caches.niupule.rxandroid_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created: niupule
 * Date: 2018/2/6  上午12:15
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class RxjavaActivity extends Activity {

    TextView rxjava_tv01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        rxjava_tv01 = findViewById(R.id.rxjava_tv01);

        //被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                e.onNext("Hello World!");
            }
        });

        //观察者
        Observer observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                //Disposable是1.x的Subscription改名的，因为Reactive-Streams规范用这个名称，为了避免重复
                //这个回调方法是在2.0之后新添加的
                //可以使用d.dispose()方法来取消订阅
            }

            @Override
            public void onNext(String o) {
                Log.d("onNext", o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("onComplete", "complete");
            }
        };

        observable.subscribe(observer);

    }
}
