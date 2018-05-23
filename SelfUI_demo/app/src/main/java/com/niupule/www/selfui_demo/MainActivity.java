package com.niupule.www.selfui_demo;

import android.annotation.SuppressLint;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.niupule.www.selfui_demo.BottomNavigations.BottomNavigationAdapter;
import com.niupule.www.selfui_demo.BottomNavigations.fragments.HomeFragment;
import com.niupule.www.selfui_demo.BottomNavigations.fragments.HottingFragment;
import com.niupule.www.selfui_demo.BottomNavigations.fragments.ProfileFragment;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragments = new ArrayList<>();
    private BottomNavigationAdapter adapter;

    private Toolbar toolbar;
    private ViewPager viewPager;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("标题");
        toolbar.setSubtitle("副标题");
        setSupportActionBar(toolbar);
        //设置左侧的小箭头
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setOnMenuItemClickListener(mainMenuItemClickListener);

        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_item_home:
                        viewPager.setCurrentItem(0,true);
                        return true;
                    case R.id.bottom_item_hotting:
                        viewPager.setCurrentItem(1,true);
                        return true;
                    case R.id.bottom_item_profile:
                        viewPager.setCurrentItem(2,true);
                        return true;
                    case R.id.bottom_item_looking:
                        viewPager.setCurrentItem(3,true);
                        return true;
                }
                return false;
            }
        });

        fragments.add(new HomeFragment());
        fragments.add(new HottingFragment());
        fragments.add(new ProfileFragment());
        adapter = new BottomNavigationAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setCheckable(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    //绑定菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null){
            if (menu.getClass() == MenuBuilder.class){
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu,true);
                }catch (Exception e){

                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }
    private Toolbar.OnMenuItemClickListener mainMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_main_edit:
                    return true;
                case R.id.menu_main_font:
                    return true;
                case R.id.menu_main_keybroad:
                    return true;
                case R.id.menu_main_search:
                    return true;
                case R.id.menu_main_setting:
                    return true;
                case R.id.menu_main_share:
                    return true;
            }
            return false;
        }
    };

}
