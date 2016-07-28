package com.demo.panguso.demo160714.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by panguso on 2016/7/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Map<String, Object>> list;
    private List<Fragment> fragments = new ArrayList<>();

    private List<String> fragmentTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
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
        return fragmentTitles.get(position);
    }

    public void setFragment(List<Map<String, Object>> fragment) {
        this.list = fragment;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            fragments.add((Fragment) map.get("fragment"));
            fragmentTitles.add((String) map.get("title"));
        }
    }
}
