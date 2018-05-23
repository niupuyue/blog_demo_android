package com.niupule.www.selfui_demo.BottomNavigations;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: niupule
 * Date: 2018/5/23  下午1:44
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class BottomNavigationAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private FragmentManager manager ;

    public BottomNavigationAdapter(FragmentManager fm) {
        super(fm);
    }

    public BottomNavigationAdapter(FragmentManager manager,List<Fragment> fragments){
        super(manager);
        this.fragments = fragments;
        this.manager = manager;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
