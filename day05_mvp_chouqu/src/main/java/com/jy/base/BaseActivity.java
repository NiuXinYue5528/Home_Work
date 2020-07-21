package com.jy.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day05_mvp_chouqu.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresontion> extends AppCompatActivity implements BaseView{
    public P mPresontion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPresontion();
        if (mPresontion!=null){
            mPresontion.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresontion();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresontion!=null){
            mPresontion.destroy();
            mPresontion=null;
        }
    }
}
