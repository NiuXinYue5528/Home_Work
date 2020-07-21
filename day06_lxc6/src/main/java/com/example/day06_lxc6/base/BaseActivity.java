package com.example.day06_lxc6.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day06_lxc6.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresention> extends AppCompatActivity implements BaseView{
    public P mPresontion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPresontion();
        if (mPresontion!=null){
           mPresontion.binView(this);
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

}
