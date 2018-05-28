package com.caches.niupule.uidesgin_demo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.caches.niupule.uidesgin_demo.classes01.MethodDrawActivity;
import com.caches.niupule.uidesgin_demo.classes01.MethodDrawPathActivity;
import com.caches.niupule.uidesgin_demo.classes01.MethodHomeWorkActivity;
import com.caches.niupule.uidesgin_demo.classes02.ShaderActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements SelfViewItemClicklistener{

    public static final String TAG = MainActivity.class.getSimpleName();

    private DrawerLayout drawerLayout;

    private SelfViewAdapter adapter;

    private RecyclerView recyclerView;

    private SwipeRefreshLayout swipeRefreshLayout;

    private Toolbar toolbar;

    private ActionBar actionBar;

    private NavigationView navigationView;

    private List<DataBean> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_sort_by_size);
        }

        drawerLayout = findViewById(R.id.main_drawerlayout);
        navigationView = findViewById(R.id.main_navigationview);
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
        datas.clear();
        //填充数据
        initData();

        recyclerView = findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelfViewAdapter(this,datas,this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        swipeRefreshLayout = findViewById(R.id.main_swiperrefreshlayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(2000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });

    }

    private void initData(){
        datas.add(new DataBean("一切的开始onDraw()",0));
        datas.add(new DataBean("onDrawPath()方法",0));
        datas.add(new DataBean("第一课练习题",0));
        datas.add(new DataBean("shader颜色渐变",0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }

    @Override
    public void onItemClicklistener(View view, int position) {
        switch (position){
            case 0:
                Log.i(TAG,"选中第一个实例");
                startActivity(new Intent(MainActivity.this, MethodDrawActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, MethodDrawPathActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this,MethodHomeWorkActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, ShaderActivity.class));
                break;
        }
    }
}
