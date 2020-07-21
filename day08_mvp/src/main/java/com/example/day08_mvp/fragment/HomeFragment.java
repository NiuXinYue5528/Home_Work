package com.example.day08_mvp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08_mvp.DwonActivity;
import com.example.day08_mvp.R;
import com.example.day08_mvp.adapter.RvAdapter;
import com.example.day08_mvp.base.BaseFragment;
import com.example.day08_mvp.bean.ProjectBean;
import com.example.day08_mvp.presontion.HomePresontion;
import com.example.day08_mvp.view.HomeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresontion> implements HomeView {


    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    private RvAdapter rvAdapter;
    private ArrayList<ProjectBean.DataBean.DatasBean> list;

    public HomeFragment() {
        // Required empty public constructor
    }


  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);

        return inflate;
    }
*/
    @Override
    protected void initListener() {
        rvAdapter.setOnItemClick(new RvAdapter.onItemClick() {
            @Override
            public void onClick(int position) {
                startActivity(new Intent(getActivity(), DwonActivity.class));
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
        rv.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(getContext(), list);
        rv.setAdapter(rvAdapter);
    }

    @Override
    protected void initPresontion() {
        mPresontion = new HomePresontion();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(ProjectBean projectBean) {
        list.addAll(projectBean.getData().getDatas());
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.i("1111", "showToast: " + str);
    }

    @OnClick(R.id.btn_delete)
    public void onViewClicked() {
        ArrayList<ProjectBean.DataBean.DatasBean> beans = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            ProjectBean.DataBean.DatasBean bean = list.get(i);
            if (bean.isCheck()==false){
                beans.add(bean);
            }
        }
        list.clear();
        list.addAll(beans);
        rvAdapter.notifyDataSetChanged();
    }
}
