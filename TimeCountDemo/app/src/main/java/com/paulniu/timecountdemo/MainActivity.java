package com.paulniu.timecountdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView btn01;
    private TextView btn02;
    private TextView btn03;
    private TextView btn04;
    private TextView btn05;
    private TextView msg;

    private LooperHandler handler;

    static int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new LooperHandler(this);

        btn01 = findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 当点击按钮时发送Message交给handler处理，handler处理之前先去判断计数
                Message message = Message.obtain();
                message.what = 0;
                message.obj = 5;
                handler.sendMessageDelayed(message, 1000);
            }
        });

        btn02 = findViewById(R.id.btn02);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 通过声明一个Timer对象实现
                Timer timer = new Timer();
                final TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        if (MainActivity.this.count >= 0) {
                            Message message = Message.obtain();
                            message.what = 1;
                            message.obj = MainActivity.this.count;
                            handler.sendMessage(message);
                            MainActivity.this.count--;
                        }
                    }
                };
                if (task != null && timer != null)
                    timer.schedule(task, 0, 1000);
            }
        });

        btn03 = findViewById(R.id.btn03);
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 初始化一个线程大小为1的线程池
                ScheduledExecutorService schedul = new ScheduledThreadPoolExecutor(1);
                schedul.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        if (MainActivity.this.count >= 0) {
                            Message m = new Message();
                            m.what = 1;
                            m.obj = MainActivity.this.count;
                            handler.sendMessage(m);
                            MainActivity.this.count--;
                        }
                    }
                }, 0, 1000, TimeUnit.MILLISECONDS);
            }
        });

        btn04 = findViewById(R.id.btn04);
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 通过RxJava

            }
        });

        btn05 = findViewById(R.id.btn05);
        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CountDownTimer
                CountDownTimer timer = new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long time) {
                        MainActivity.this.msg.setText((time/1000)+"s");
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                timer.start();
            }
        });

        msg = findViewById(R.id.msg);
    }

    private static class LooperHandler extends Handler {
        WeakReference<Activity> weakReference;

        public LooperHandler(Activity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            MainActivity activity = (MainActivity) weakReference.get();
            switch (message.what) {
                case 0:
                    int count = (int) message.obj;
                    count--;
                    if (count >= 0) {
                        activity.msg.setText(count + "s");
                        Message m = Message.obtain();
                        m.what = 0;
                        m.obj = count;
                        activity.handler.sendMessageDelayed(m, 1000);
                    }
                    break;
                case 1:
                    activity.msg.setText(message.obj + "s");
                    break;
            }
        }
    }

}
