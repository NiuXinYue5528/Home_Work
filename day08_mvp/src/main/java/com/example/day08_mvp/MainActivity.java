package com.example.day08_mvp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day08_mvp.adapter.VpAdapter;
import com.example.day08_mvp.fragment.HomeFragment;
import com.example.day08_mvp.fragment.WebFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //练习册第九题
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new WebFragment());
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页");
        tab.getTabAt(1).setText("我的");
    }
}
