package com.caches.niupule.json_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caches.niupule.json_demo.Bean.Movie;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created: niupule
 * Date: 2018/3/28  上午11:43
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class BaseRecycleAdapter extends RecyclerView.Adapter<MyHolder> {

    private List<Movie.SubjectsBean> movies;
    private Context context;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 2){
                Bitmap bitmap = (Bitmap) msg.obj;

            }
        }
    };

    public BaseRecycleAdapter(List<Movie.SubjectsBean> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        Movie.SubjectsBean movie = movies.get(position);
        //根据网络图片实现图片的显示
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(movies.get(position).getImages().getSmall()).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] result = response.body().bytes();
                Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
                Message ms = Message.obtain();
                ms.what = 2;
                ms.obj = bitmap;

            }
        });
        holder.name.setText(movie.getTitle());
        holder.director.setText(movie.getDirectors().get(0).getName());
        holder.actor.setText(movie.getCasts().get(0).getName());
    }

    @Override
    public int getItemCount() {
        if (movies.size() > 0) {
            return movies.size();
        } else {
            return 0;
        }
    }


}
