package com.example.day06_lxc6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day06_lxc6.adapter.RvAdapter;
import com.example.day06_lxc6.base.BaseActivity;
import com.example.day06_lxc6.bean.EvenBean;
import com.example.day06_lxc6.bean.FoodBean;
import com.example.day06_lxc6.presontion.MainPresontion;
import com.example.day06_lxc6.view.MainView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresontion> implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<FoodBean.DataBean> list;
    private RvAdapter rvAdapter;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }*/

    @Override
    protected void initListener() {
        rvAdapter.setOnItemClick(new RvAdapter.onItemClick() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                EventBus.getDefault().postSticky(new EvenBean(list.get(position).getTitle()));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresontion.setData();
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(this, list);
        rv.setAdapter(rvAdapter);

        toolbar.setTitle("文章列表");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initPresontion() {
        mPresontion=new MainPresontion();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(FoodBean foodBean) {
        list.addAll(foodBean.getData());
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.i("111", "showToast: "+str);
    }
}
