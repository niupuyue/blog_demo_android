package com.caches.niupule.json_demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created: niupule
 * Date: 2018/3/28  上午11:50
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class MyHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView name,director,actor;

    public MyHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.itme_image);
        name = itemView.findViewById(R.id.item_name);
        director = itemView.findViewById(R.id.item_director);
        actor = itemView.findViewById(R.id.item_actor);
    }
}
