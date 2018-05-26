package com.caches.niupule.materdesgin_demo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements FruitItemClickListener{

    public static final String TAG = MainActivity.class.getSimpleName();

    private DrawerLayout drawerLayout;

    private FruitAdapter adapter;

    private Fruit[] fruits = {
            new Fruit("Apple", R.mipmap.ic_launcher), new Fruit("Banana", R.mipmap.ic_launcher),
            new Fruit("Orange", R.mipmap.ic_launcher), new Fruit("Watermelon", R.mipmap.ic_launcher),
            new Fruit("Pear", R.mipmap.ic_launcher), new Fruit("Grape", R.mipmap.ic_launcher),
            new Fruit("Pineapple", R.mipmap.ic_launcher), new Fruit("Strawberry", R.mipmap.ic_launcher),
            new Fruit("Cherry", R.mipmap.ic_launcher), new Fruit("Mango", R.mipmap.ic_launcher)
    };

    private List<Fruit> fruitList = new ArrayList<>();

    private RecyclerView recyclerView;

    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });

        FloatingActionButton float_btn = findViewById(R.id.float_btn);
        float_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "点击了悬浮窗");
                //声明一个snackbar
                Snackbar.make(v, "删除操作", Snackbar.LENGTH_SHORT)
                        .setAction("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i(TAG, "点击了取消按钮");
                            }
                        }).show();
            }
        });

        fruitList.clear();
        for (int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FruitAdapter(this,fruitList,this);
        recyclerView.setAdapter(adapter);


        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruit();
            }
        });

    }

    public void refreshFruit(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //通知UI线程更新数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fruitList.clear();
                        for (int i=0;i<50;i++){
                            Random random = new Random();
                            int index = random.nextInt(fruits.length);
                            fruitList.add(fruits[index]);
                        }
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Log.i(TAG, "backup");
                return true;
            case R.id.delete:
                Log.i(TAG, "delete");
                return true;
            case R.id.setting:
                Log.i(TAG, "setting");
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
        intent.putExtra("name",fruitList.get(position).getName());
        intent.putExtra("image",fruitList.get(position).getImageId());
        startActivity(intent);
    }
}
