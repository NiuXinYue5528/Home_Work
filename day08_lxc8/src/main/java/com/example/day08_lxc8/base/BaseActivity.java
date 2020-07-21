package com.example.day08_lxc8.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day08_lxc8.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends  BasePresention> extends AppCompatActivity implements  BaseView{

    public P mPresention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPresention();
        if (mPresention!=null){
            mPresention.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initPresention();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresention!=null){
            mPresention.destroy();
        }
    }
}
