package com.example.day08_lxc8.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08_lxc8.Presention.HomePresontion;
import com.example.day08_lxc8.R;
import com.example.day08_lxc8.adapter.TwoRvAdapter;
import com.example.day08_lxc8.base.BaseFragment;
import com.example.day08_lxc8.bean.NameBean;
import com.example.day08_lxc8.view.HomeView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresontion> implements HomeView {


    @BindView(R.id.rv)
    RecyclerView rv;
    private int id;
    private ArrayList<NameBean.BodyBean.ResultBean> list1;
    private TwoRvAdapter twoRvAdapter;

    public HomeFragment(int id) {
        // Required empty public constructor
        this.id = id;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresontion.setDatas(id);
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        list1 = new ArrayList<>();
        twoRvAdapter = new TwoRvAdapter(getContext(), list1);
        rv.setAdapter(twoRvAdapter);
    }

    @Override
    protected void initPresontion() {
        mPresontion=new HomePresontion();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void setData(NameBean nameBean) {
        list1.addAll(nameBean.getBody().getResult());
        twoRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.i("111", "showToast: " + str);
    }


   // @Override
   /* public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        return inflate;
    }*/

}
