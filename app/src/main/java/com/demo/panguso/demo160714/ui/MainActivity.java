package com.demo.panguso.demo160714.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.adapter.ViewPagerAdapter;
import com.demo.panguso.demo160714.fragment.AreaFragment;
import com.demo.panguso.demo160714.fragment.AttentionFragment;
import com.demo.panguso.demo160714.fragment.DiscoverFragment;
import com.demo.panguso.demo160714.fragment.OnAirFragment;
import com.demo.panguso.demo160714.fragment.OperaFragment;
import com.demo.panguso.demo160714.fragment.RecommandFragment;
import com.demo.panguso.demo160714.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ImageView mSetDrawer;
    private RelativeLayout mCommoneToolBar;
    private SlidingTabLayout mTabLayout;
    private List<Map<String, Object>> mFragments;

    private AreaFragment areaFragment;
    private DiscoverFragment discoverFragment;
    private OperaFragment operaFragment;
    private RecommandFragment recommandFragment;
    private AttentionFragment attentionFragment;
    private OnAirFragment onAirFragment;
    private ViewPagerAdapter mAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolBar();
        initFragment();
        initPageAdapter();
    }

    private void initPageAdapter() {
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.setFragment(mFragments);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        if (mViewPager != null) {
            mViewPager.setAdapter(mAdapter);
            mViewPager.setCurrentItem(1);
        }
        mTabLayout.setTabTitleTextSize(14);//标题字体大小
        mTabLayout.setTitleTextColor(Color.WHITE, R.color.colorTextIndica);//标题字体颜色
        mTabLayout.setTabStripWidth(110);//滑动条宽度
        mTabLayout.setDistributeEvenly(true); //均匀平铺选项卡
        mTabLayout.setSelectedIndicatorColors(Color.WHITE);
        mTabLayout.setViewPager(mViewPager);
    }

    private void initFragment() {
        areaFragment = new AreaFragment();
        attentionFragment = new AttentionFragment();
        discoverFragment = new DiscoverFragment();
        operaFragment = new OperaFragment();
        recommandFragment = new RecommandFragment();
        onAirFragment = new OnAirFragment();
        setFragment(onAirFragment, "直播");
        setFragment(recommandFragment, "推荐");
        setFragment(operaFragment, "番剧");
        setFragment(areaFragment, "分区");
        setFragment(attentionFragment, "关注");
        setFragment(discoverFragment, "发现");
    }

    private void setFragment(Fragment fragment, String title) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (fragment != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("fragment", fragment);
            map.put("title", title);
            mFragments.add(map);
        }
    }

    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCommoneToolBar = (RelativeLayout) View.inflate(this, R.layout.common_toolbar, null);
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        mToolbar.addView(mCommoneToolBar);
        mSetDrawer = (ImageView) mCommoneToolBar.findViewById(R.id.drawer_home);
        mSetDrawer.setOnClickListener(this);
        mTabLayout = (SlidingTabLayout) findViewById(R.id.tabLayout);
    }


    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(mNavigationView);
    }

    private void closeDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.isDrawerOpen(GravityCompat.START);
        }
    }

    /**
     * 当选中抽屉按钮的item的时候关闭抽屉
     *
     * @param upDrawerContent
     */
    public void setupDrawerContent(NavigationView upDrawerContent) {
        upDrawerContent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.drawer_home:
                closeDrawer();
                break;
            default:
                break;
        }

    }
}
