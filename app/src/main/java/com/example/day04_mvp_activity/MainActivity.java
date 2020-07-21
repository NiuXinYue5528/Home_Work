package com.example.day04_mvp_activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.adapter.RvAdapter;
import com.jy.base.BaseActivity;
import com.jy.bean.FoodBean;
import com.jy.presention.MainPresention;
import com.jy.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresention> implements MainView {

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

    }

    @Override
    protected void initData() {
        mPresention.setData();
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(this, list);
        rv.setAdapter(rvAdapter);
    }

    @Override
    protected void initPresention() {
        mPresention = new MainPresention();
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
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        Log.e("1111", "showToast: "+str );
    }
}
