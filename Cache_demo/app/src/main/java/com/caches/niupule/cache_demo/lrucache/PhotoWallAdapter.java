package com.caches.niupule.cache_demo.lrucache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.caches.niupule.cache_demo.R;

import java.util.HashSet;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * Created: niupule
 * Date: 2018/3/23  下午8:54
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class PhotoWallAdapter extends ArrayAdapter<String> implements AbsListView.OnScrollListener {

    //进行图片缓存
    private LruCache<String, Bitmap> mMemoryCache;

    //正在执行或者已经执行下载任务的集合
    private Set<BitmapWorkTask> tasksCollections;

    //当前第一个可以看到的项目数
    private int mFirstVisiableItem;

    //当前可以看到的项目的个数
    private int mVisiableItemCount;

    //当前需要显示的照片墙
    private GridView gridView;

    /**
     * 记录是否刚打开程序，用于解决进入程序不滚动屏幕，不会下载图片的问题。
     */
    private boolean isFirstEnter = true;

    public PhotoWallAdapter(Context context, int textViewResource, String[] objects, GridView gridView) {
        super(context, textViewResource, objects);
        this.gridView = gridView;
        tasksCollections = new HashSet<BitmapWorkTask>();
        //获取系统为当前应用分配的内存空间
        int memorySize = (int) Runtime.getRuntime().maxMemory();
        //设置当前可以用于使用图片的内存大小
        int photoCache = memorySize / 8;
        //给图片缓存集合初始化
        mMemoryCache = new LruCache<String, Bitmap>(photoCache) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
        gridView.setOnScrollListener(this);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final String url = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_lru_gridview, null);
        } else {
            view = convertView;
        }
        final ImageView photo = view.findViewById(R.id.lru_item_photo);
        photo.setTag(url);
        setImageView(url, photo);
        return view;
    }

    //根据当前的imageview设置图片展示，如果有则显示，没有显示默认图片
    private void setImageView(String url, ImageView photo) {
        Bitmap bitmap = getBitmapFromMemoryCache(url);
        if (bitmap != null) {
            photo.setImageBitmap(bitmap);
        } else {
            photo.setImageResource(R.mipmap.ic_launcher);
        }
    }

    //向缓存中添加bitmap对象
    private void addBitmapToMemoryCache(String url, Bitmap bitmap) {
        if (getBitmapFromMemoryCache(url) == null) {
            mMemoryCache.put(url, bitmap);
        }
    }

    //从缓存中获取到图片bitmap对象
    private Bitmap getBitmapFromMemoryCache(String url) {
        return mMemoryCache.get(url);
    }

    /**
     * 当滑动状态发生改变的时候就会触发
     *
     * @param view
     * @param scrollState
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //只有当gridview的滑动停止之后才会，才会加载图片
        if (scrollState == SCROLL_STATE_IDLE) {
            Log.i("onScrollstateChange", "滚动状态发生改变");
            loadBitmap(mFirstVisiableItem, mVisiableItemCount);
        } else {
            cancleAllTasks();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mFirstVisiableItem = firstVisibleItem;
        mVisiableItemCount = visibleItemCount;
        Log.i("onScroll", "当前第一次执行的时候的firstid和totalcount" + firstVisibleItem + ";" + totalItemCount);
        // 下载的任务应该由onScrollStateChanged里调用，但首次进入程序时onScrollStateChanged并不会调用，
        // 因此在这里为首次进入程序开启下载任务。
        if (isFirstEnter && visibleItemCount > 0) {
            Log.i("onScroll", totalItemCount + ":" + firstVisibleItem);
            loadBitmap(firstVisibleItem, visibleItemCount);
            isFirstEnter = false;
        }
    }

    /**
     * 加载Bitmap对象。此方法会在LruCache中检查所有屏幕中可见的ImageView的Bitmap对象，
     * 如果发现任何一个ImageView的Bitmap对象不在缓存中，就会开启异步线程去下载图片。
     *
     * @param firstVisiableId
     * @param visiableCount
     */
    private void loadBitmap(int firstVisiableId, int visiableCount) {
        //
        try {
            for (int i = firstVisiableId; i < firstVisiableId + visiableCount; i++) {
                String imageUrl = Images.imageThumbUrls[i];
                Bitmap bitmap = getBitmapFromMemoryCache(imageUrl);
                if (bitmap == null) {
                    BitmapWorkTask task = new BitmapWorkTask();
                    tasksCollections.add(task);
                    task.execute(imageUrl);
                } else {
                    ImageView imageView = gridView.findViewWithTag(imageUrl);
                    if (imageView != null && bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭当前正在下载的进程
     */
    public void cancleAllTasks() {
        if (tasksCollections != null) {
            for (BitmapWorkTask task : tasksCollections) {
                task.cancel(false);
            }
        }
    }


    class BitmapWorkTask extends AsyncTask<String, Void, Bitmap> {

        //图片的地址
        String imageUrl;

        @Override
        protected Bitmap doInBackground(String... strings) {
            imageUrl = strings[0];
            Bitmap bitmap = downloadBitmap(strings[0]);
            Log.i("doinbackground", imageUrl);
            if (bitmap != null) {
                addBitmapToMemoryCache(strings[0], bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            //根据Tag获取到当前的图片，并且显示出来
            ImageView photo = gridView.findViewWithTag(imageUrl);
            if (photo != null && bitmap != null)
                photo.setImageBitmap(bitmap);
            tasksCollections.remove(this);
        }

        private Bitmap downloadBitmap(String url) {
            Bitmap bitmap = null;
//            Bitmap bitmap = null;
//            HttpURLConnection conn = null;
//            try {
//                URL myurl = new URL(url);
//                conn = (HttpURLConnection) myurl.openConnection();
//                conn.setConnectTimeout(5000);
//                conn.setReadTimeout(10 * 1000);
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//                bitmap = BitmapFactory.decodeStream(conn.getInputStream());
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (conn != null) {
//                    conn.disconnect();
//                }
//            }

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                ResponseBody body = okHttpClient.newCall(request).execute().body();
                bitmap = BitmapFactory.decodeStream(body.byteStream());
            } catch (Exception e) {
                e.printStackTrace();
            }


            return bitmap;
        }
    }

}
