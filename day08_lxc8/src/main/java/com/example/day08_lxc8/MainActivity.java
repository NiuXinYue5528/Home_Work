package com.example.day08_lxc8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08_lxc8.Presention.MainPresention;
import com.example.day08_lxc8.adapter.RvAdapter;
import com.example.day08_lxc8.base.BaseActivity;
import com.example.day08_lxc8.base.BasePresention;
import com.example.day08_lxc8.bean.DatasBean;
import com.example.day08_lxc8.bean.NameBean;
import com.example.day08_lxc8.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresention> implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<DatasBean.BodyBean.ResultBean> list;
    private RvAdapter rvAdapter;
    private DatasBean datasBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresention.setData();
    }

    @Override
    protected void initView() {
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(this, list);
        rv.setAdapter(rvAdapter);

        toolbar.setTitle("名师推荐");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void initListener() {
        rvAdapter.setOnItemClick(new RvAdapter.onItemClick() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                DatasBean.BodyBean.ResultBean resultBean = list.get(position);
                intent.putExtra("aaa", resultBean);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initPresention() {
        mPresention=new MainPresention();
    }

    @Override
    public void setData(DatasBean data) {
        this.datasBean=data;
        list.addAll(data.getBody().getResult());
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Log.i("111", "showToast: "+str);
    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }*/
}
