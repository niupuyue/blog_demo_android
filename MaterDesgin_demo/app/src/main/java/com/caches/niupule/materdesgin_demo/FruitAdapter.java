package com.caches.niupule.materdesgin_demo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: niupule
 * Date: 2018/5/25  下午2:36
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private Context context;
    private List<Fruit> fruits = new ArrayList<>();
    private FruitItemClickListener listener;

    public FruitAdapter (Context context,List<Fruit> fruits,FruitItemClickListener listener){
        this.context = context;
        this.fruits = fruits;
        this.listener = listener;
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view,parent,false);
        return new FruitViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
//        Glide.with(context).load(fruits.get(position).getImageId()).into(holder.imageView);
        holder.textView.setText(fruits.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView;
        CardView cardView;

        FruitItemClickListener listener;

        public FruitViewHolder(View itemView,FruitItemClickListener listener) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = itemView.findViewById(R.id.item_image);
            textView = itemView.findViewById(R.id.item_name);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onItemClick(v,getPosition());
        }
    }

}
