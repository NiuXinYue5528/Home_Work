package com.example.day11_zhouce;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.day11_zhouce.fragment.HomeFragment;
import com.example.day11_zhouce.fragment.InfoFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rlv;
    private Toolbar toolbar;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {

    }

    private void initView() {
        rlv = (RelativeLayout) findViewById(R.id.rlv);
        tab = (TabLayout) findViewById(R.id.tab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("广场");

        //开启事务
        final FragmentManager fm = getSupportFragmentManager();
        //获取fragment对象
        final HomeFragment homeFragment = new HomeFragment();
        final InfoFragment infoFragment = new InfoFragment();
        //替换内容
        fm.beginTransaction().add(R.id.rlv, homeFragment).add(R.id.rlv, infoFragment).hide(infoFragment).commit();



        tab.addTab(tab.newTab().setText("广场").setIcon(R.drawable.item_seletctor));
        tab.addTab(tab.newTab().setText("公众号").setIcon(R.drawable.item_seletctor));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    //开启事务
                    fm.beginTransaction().hide(infoFragment).show(homeFragment).commit();
                }else {
                    fm.beginTransaction().hide(homeFragment).show(infoFragment).commit();
                }
                toolbar.setTitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
