package com.example.day05_mvp_chouqu;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.adapter.RvAdpater;
import com.jy.base.BaseActivity;
import com.jy.bean.FoodBean;
import com.jy.presention.MainPresontion;
import com.jy.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresontion> implements MainView {

    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<FoodBean.DataBean> list;
    private RvAdpater rvAdpater;

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
        mPresontion.setData();
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        list = new ArrayList<>();
        rvAdpater = new RvAdpater(this, list);
        rv.setAdapter(rvAdpater);
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
        rvAdpater.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.e("1111 +", "showToast: "+str );
    }
}
