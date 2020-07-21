package com.example.day05_lxc5;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.adapter.RvAdapter;
import com.jy.base.BaseActivity;
import com.jy.bean.DatasBean;
import com.jy.presention.MainPresontion;
import com.jy.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresontion> implements MainView {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.btn_cao)
    Button btnCao;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_wan)
    Button btnWan;
    private ArrayList<DatasBean.T1348647909107Bean> list;
    private RvAdapter rvAdapter;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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
        mPresention = new MainPresontion();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void setData(DatasBean datasBean) {
        list.addAll(datasBean.getT1348647909107());
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.e("1111", "showToast: " + str);
    }

     @OnClick({R.id.btn_cao, R.id.btn_delete, R.id.btn_wan})
     public void onViewClicked(View view) {
         switch (view.getId()) {
             case R.id.btn_cao:
                 //操作
                 rvAdapter.isShow=true;//是true显示复选框
                 rvAdapter.notifyDataSetChanged();//刷新适配器
               /*  btnCao.setVisibility(View.GONE);
                btnWan.setVisibility(View.VISIBLE);*/
                break;
            case R.id.btn_delete:
                //删除
                ArrayList<DatasBean.T1348647909107Bean> newList = new ArrayList<>();
                for (int i = 0; i <list.size() ; i++) {
                    DatasBean.T1348647909107Bean bean = list.get(i);
                    if (bean.isCheck()==false){
                        newList.add(bean);//没有被选中的放入新集合
                    }
                }
                list.clear();//清空集合
                list.addAll(newList);//放入新集合
                rvAdapter.isShow = false;//复选框隐藏
                rvAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_wan:
                setwan();
                break;
        }
    }
    private void setwan() {

        for (int i = 0; i < list.size(); i++) {
            DatasBean.T1348647909107Bean bean = list.get(i);
            if (bean.isCheck()){
                bean.setCheck(false);
            }
        }
        rvAdapter.isShow = false;//复选框隐藏
        rvAdapter.notifyDataSetChanged();//刷新适配器
        /*btnCao.setVisibility(View.VISIBLE);
        btnDelete.setVisibility(View.GONE);
        btnWan.setVisibility(View.GONE);*/

    }

   /* public void setDelete(boolean bb) {
        if (bb == true) {
            btnDelete.setVisibility(View.VISIBLE);
        } else {
            btnDelete.setVisibility(View.GONE);
        }

    }*/
}


