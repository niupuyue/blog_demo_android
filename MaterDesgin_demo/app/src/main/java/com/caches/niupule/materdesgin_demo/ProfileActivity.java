package com.caches.niupule.materdesgin_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created: niupule
 * Date: 2018/5/25  下午3:52
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        String fruitName = intent.getStringExtra("name");
        int fruitImage = intent.getIntExtra("image",0);

        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        CollapsingToolbarLayout collapsibleActionView = findViewById(R.id.collapsing_taolbar);
        ImageView imageView = findViewById(R.id.profile_image);
        TextView textView = findViewById(R.id.fruit_content);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsibleActionView.setTitle(fruitName);
//        Glide.with(this).load(fruitImage).into(imageView);
        String fruitContent = generateFruitContent(fruitName);
        textView.setText(fruitContent);

    }

    private String generateFruitContent(String fruitName){
        StringBuilder fruitContent = new StringBuilder();
        for(int i=0;i<500;i++){
            fruitContent.append(fruitName);
        }

        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
