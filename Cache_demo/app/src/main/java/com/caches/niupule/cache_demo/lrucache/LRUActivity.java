package com.caches.niupule.cache_demo.lrucache;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;

import com.caches.niupule.cache_demo.R;

/**
 * Created: niupule
 * Date: 2018/3/23  下午8:48
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class LRUActivity extends Activity {

    private GridView lru_gridview;
    private PhotoWallAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lru);

        lru_gridview = findViewById(R.id.lru_gridview);
        adapter = new PhotoWallAdapter(this,0,Images.imageThumbUrls,lru_gridview);
        lru_gridview.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.cancleAllTasks();
    }
}
