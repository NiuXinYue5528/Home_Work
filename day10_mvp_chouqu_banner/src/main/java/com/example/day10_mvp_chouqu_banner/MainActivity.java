package com.example.day10_mvp_chouqu_banner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day10_mvp_chouqu_banner.adapter.RvAdapter;
import com.example.day10_mvp_chouqu_banner.base.BaseActivity;
import com.example.day10_mvp_chouqu_banner.bean.FoodBean;
import com.example.day10_mvp_chouqu_banner.presontion.MainPresontion;
import com.example.day10_mvp_chouqu_banner.view.MainView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresontion> implements MainView, OnRefreshLoadMoreListener {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.btn_bian)
    Button btnBian;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.smf)
    SmartRefreshLayout smf;
    private int page = 1;
    private ArrayList<FoodBean.DataBean> list;
    private RvAdapter rvAdapter;

/*    @Override
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
        mPresontion.setData(page);
    }

    @Override
    protected void initView() {

        rv = (RecyclerView) findViewById(R.id.rv);
        smf = (SmartRefreshLayout) findViewById(R.id.smf);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        list = new ArrayList<>();

        rvAdapter = new RvAdapter(this, list);
        rv.setAdapter(rvAdapter);
        smf.setOnRefreshLoadMoreListener(this);

    }

    @Override
    protected void initPresontion() {
        mPresontion = new MainPresontion();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(FoodBean foodBean) {
        list.addAll(foodBean.getData());
        rvAdapter.notifyDataSetChanged();
        smf.finishRefresh();
        smf.finishLoadMore();
    }

    @Override
    public void showToast(String str) {
        Log.i("111", "showToast: " + str);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        initData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        if (list != null && list.size() > 0) {
            list.clear();
            initData();
        }
    }

    public void setDelete(boolean bb) {
        if (bb==true){
            btnDelete.setVisibility(View.VISIBLE);
        }else{
            btnDelete.setVisibility(View.GONE);
        }
    }


    @OnClick({R.id.btn_bian, R.id.btn_cancel, R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bian:
                bian();
                break;
            case R.id.btn_cancel:
                quxiao();
                break;
            case R.id.btn_delete:
                delete();
                break;
        }
    }

    private void delete() {
        ArrayList<FoodBean.DataBean> newList = new ArrayList<>();
        for (int i = 0; i < this.list.size() ; i++) {
            FoodBean.DataBean dataBean = this.list.get(i);
            if (dataBean.isCheck()==false){
                newList.add(dataBean);
            }
        }
        list.clear();
        list.addAll(newList);
        rvAdapter.notifyDataSetChanged();
        quxiao();
    }

    private void quxiao() {
        for (int i = 0; i <list.size() ; i++) {
            FoodBean.DataBean bean = list.get(i);
            if (bean.isCheck()==true){
                bean.setCheck(false);//将没有选中的放在集合
            }
        }
        rvAdapter.isShow=false;
        btnCancel.setVisibility(View.GONE);
        btnDelete.setVisibility(View.GONE);
        btnBian.setVisibility(View.VISIBLE);
        rvAdapter.notifyDataSetChanged();

    }

    private void bian() {
        rvAdapter.isShow=true;
        btnBian.setVisibility(View.GONE);
        btnCancel.setVisibility(View.VISIBLE);
        rvAdapter.notifyDataSetChanged();
    }
}
