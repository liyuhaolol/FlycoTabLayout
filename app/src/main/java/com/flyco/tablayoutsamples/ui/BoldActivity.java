package com.flyco.tablayoutsamples.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayoutsamples.R;

import java.util.ArrayList;

public class BoldActivity extends AppCompatActivity {
    SlidingTabLayout tab;
    ViewPager vp;
    ArrayList<BoldFragment> fragments;
    ArrayList<String> titles;
    FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bold);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();

        titles.add("测试0");
        titles.add("测试1");
        titles.add("测试2");
        titles.add("测试3");
        titles.add("测试4");
        titles.add("测试5");
        titles.add("测试6");
        titles.add("测试7");
        titles.add("测试8");
        titles.add("测试9");

        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());
        fragments.add(new BoldFragment());

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }

            @Override
            public int getCount() {
                return titles.size();
            }
        };

        vp.setAdapter(fragmentPagerAdapter);

        tab.setViewPager(vp);
        //tab.setupWithViewPager(viewPager);
        //不会重新加载fragment
        vp.setOffscreenPageLimit(titles.size());

        vp.setCurrentItem(0);
        //tab.setCurrentTab(1);
    }
}
