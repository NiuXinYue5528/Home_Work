package com.example.day11_zhouce.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.day11_zhouce.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresontion> extends Fragment implements BaseView {

    public  P mPresontion;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initPresontion();
        if (mPresontion!=null){
            mPresontion.bindView(this);
        }
        initView();
        initData();
        initListener();
        return inflate;
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresontion();


    protected abstract int getLayout();

    //销毁view
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mPresontion.destroy();
        mPresontion=null;
    }
}
