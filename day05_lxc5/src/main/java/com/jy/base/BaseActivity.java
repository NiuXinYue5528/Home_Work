package com.jy.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day05_lxc5.R;

import butterknife.ButterKnife;

public abstract class BaseActivity <P extends BasePersention> extends AppCompatActivity implements BaseView{
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

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresention();

    protected abstract int getLayout();

    //销毁

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresention!=null){
            mPresention.destroy();
            mPresention=null;
        }
    }


}
