package com.caches.niupule.uidesgin_demo.classes01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.caches.niupule.uidesgin_demo.R;
import com.caches.niupule.uidesgin_demo.classes01.home.Home1;
import com.caches.niupule.uidesgin_demo.classes01.home.Home2;
import com.caches.niupule.uidesgin_demo.classes01.home.HomeDrawArc;
import com.caches.niupule.uidesgin_demo.classes01.home.HomeDrawCircle;
import com.caches.niupule.uidesgin_demo.classes01.home.HomeDrawColor;
import com.caches.niupule.uidesgin_demo.classes01.home.HomeDrawOwl;
import com.caches.niupule.uidesgin_demo.classes01.home.HomeDrawPath;
import com.caches.niupule.uidesgin_demo.classes01.home.HomeDrawRect;
import com.caches.niupule.uidesgin_demo.classes01.home.HomeDrawRoundRect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: niupule
 * Date: 2018/5/28  下午4:43
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class MethodHomeWorkActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MethodHomeWorkAdapter adapter;

    List<Fragment> fragments;
    List<String> titles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_homework);

        tabLayout = findViewById(R.id.method_homework_tablayout);
        viewPager = findViewById(R.id.method_homework_viewpager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabTextColors(ContextCompat.getColor(this, android.R.color.darker_gray), ContextCompat.getColor(this, android.R.color.black));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, android.R.color.black));
        ViewCompat.setElevation(tabLayout, 10);
        tabLayout.setupWithViewPager(viewPager);

        titles = new ArrayList<>();
        titles.add("设置背景颜色");
        titles.add("绘制圆");
        titles.add("绘制矩形");
        titles.add("绘制椭圆形");
        titles.add("绘制圆角矩形");
        titles.add("绘制弧形");
        titles.add("绘制路径");
        titles.add("直方图");
        titles.add("饼状图");

        fragments = new ArrayList<>();
        fragments.add(new HomeDrawColor());
        fragments.add(new HomeDrawCircle());
        fragments.add(new HomeDrawRect());
        fragments.add(new HomeDrawOwl());
        fragments.add(new HomeDrawRoundRect());
        fragments.add(new HomeDrawArc());
        fragments.add(new HomeDrawPath());
        fragments.add(new Home1());
        fragments.add(new Home2());

        adapter = new MethodHomeWorkAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


    }

    class MethodHomeWorkAdapter extends FragmentPagerAdapter{

        public MethodHomeWorkAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}


