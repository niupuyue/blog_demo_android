package com.caches.niupule.rxandroid_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created: niupule
 * Date: 2018/2/8  下午8:10
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class RxJavaMergeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_merge);


        findViewById(R.id.btn_merge_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

                        //在这里发送我们额消息，需要被监听的对象，当数据改变的时候，发送消息，被观察者
                        emitter.onNext(1);
                        emitter.onNext(2);
                        emitter.onNext(3);
                        emitter.onNext(4);

                    }
                }).subscribe(new Observer<Integer>() {

                    //当数据发生变化额时候在这里通知，这里就是观察者
                    private int i;
                    private Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i("rxdjavamerge",integer+"");
                        i++;
                        if(i == 2){
                            //如果是执行了两次了，那么这时候可以通过dispose()方法实现截断，然后就不会再接受后面的消息
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });

        findViewById(R.id.btn_merge_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
