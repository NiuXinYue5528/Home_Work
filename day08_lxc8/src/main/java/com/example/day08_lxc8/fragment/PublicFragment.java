package com.example.day08_lxc8.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08_lxc8.HomeActivity;
import com.example.day08_lxc8.MainActivity;
import com.example.day08_lxc8.Presention.MainPresention;
import com.example.day08_lxc8.R;
import com.example.day08_lxc8.VideoActivity;
import com.example.day08_lxc8.adapter.RvAdapter;
import com.example.day08_lxc8.base.BaseFragment;
import com.example.day08_lxc8.bean.DatasBean;
import com.example.day08_lxc8.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicFragment extends BaseFragment<MainPresention> implements MainView {


    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<DatasBean.BodyBean.ResultBean> list;
    private RvAdapter rvAdapter;

    public PublicFragment() {
        // Required empty public constructor
    }


   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_public, container, false);
        initView(inflate);
        initData();
        return inflate;
    }
*/
    @Override
    protected void initListener() {
        rvAdapter.setOnItemClick(new RvAdapter.onItemClick() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
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
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(getActivity(), list);
        rv.setAdapter(rvAdapter);
    }

    @Override
    protected void initPresontion() {
        mPresontion = new MainPresention();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_public;
    }

    @Override
    public void setData(DatasBean data) {
        list.addAll(data.getBody().getResult());
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.i("1111", "showToast: "+str);
    }
}
