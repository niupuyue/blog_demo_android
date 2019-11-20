package com.paulniu.imagetextview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private QuoteTextView mText, mText2, mText3, mText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mText = (QuoteTextView) findViewById(R.id.quote);
        mText.setText("这是一间营业时间从午夜十二点到早上七点的特殊食堂这这是一间营业这这是一间营业时间从午夜十二点到早上七点的特殊食堂这");

        mText2 = (QuoteTextView) findViewById(R.id.quote2);
        mText2.setQuoteTextView("这是一间营业时间从午夜十二点到早上七点的特殊食堂这这是一间营业这这是一间营业时间从午夜十二点到早上七点的特殊食堂这","","<img src='ic_job_goodjob_joblist_chat'/>","...",3);

        mText3 = (QuoteTextView) findViewById(R.id.quote3);
        mText3.setQuoteTextView("这是一间营业时间从午夜十二点到早上七点的特殊食堂这这是一间营业这这是一间营业时间从午夜十二点到早上七点的特殊食堂这", "", "<font color='red' size='20'> 创建</font>","...", 3);

        mText4 = (QuoteTextView) findViewById(R.id.quote4);
        mText4.setQuoteTextView("这是一间营业时间从午夜十二点到早上七点的特殊食堂这这是一间营业这这是一间营业时间从午夜十二点到早上七点的特殊食堂这", "", " <img src='ic_director'/>","...", 2);
    }
}
