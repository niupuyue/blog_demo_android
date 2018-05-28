package com.caches.niupule.uidesgin_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: niupule
 * Date: 2018/5/28  下午2:02
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class SelfViewAdapter extends RecyclerView.Adapter<SelfViewAdapter.SelfViewHolder> {

    private Context context;
    private List<DataBean> dataBeans = new ArrayList<>();
    private SelfViewItemClicklistener listener;

    public SelfViewAdapter(Context context, List<DataBean> dataBeans, SelfViewItemClicklistener listener) {
        this.context = context;
        this.dataBeans = dataBeans;
        this.listener = listener;
    }

    @Override
    public SelfViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_selfviewadapter,parent, false);
        return new SelfViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(SelfViewHolder holder, int position) {
        holder.textView.setText(dataBeans.get(position).getData_name());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class SelfViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;
        SelfViewItemClicklistener listener;

        public SelfViewHolder(View itemView, SelfViewItemClicklistener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            textView = itemView.findViewById(R.id.item_name);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.listener.onItemClicklistener(v, getPosition());
        }
    }

}
