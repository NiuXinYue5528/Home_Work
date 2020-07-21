package com.example.day11_zhouce.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day11_zhouce.R;
import com.example.day11_zhouce.adapter.RvAdapter;
import com.example.day11_zhouce.base.BaseFragment;
import com.example.day11_zhouce.bean.ProjectBean;
import com.example.day11_zhouce.presontion.HomePresonton;
import com.example.day11_zhouce.view.HomeView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresonton> implements HomeView {


    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<ProjectBean.DataBean.DatasBean> list;
    private RvAdapter rvAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        return inflate;
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
        //获取管理器

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        //分割线
        rv.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(getContext(), list);
        rv.setAdapter(rvAdapter);
    }

    @Override
    protected void initPresontion() {
        mPresontion = new HomePresonton();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(ProjectBean projectBean) {
        list.addAll(projectBean.getData().getDatas());
        Log.i("111", "onSuccess: "+projectBean.getData().getDatas());
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.i("111", "showToast: "+str);
    }
}
