package com.example.day08_lxc8.base;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day08_lxc8.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<P extends BasePresention> extends Fragment  implements BaseView{

    public P mPresontion;
    private Unbinder bind;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), null);
        bind = ButterKnife.bind(this, inflate);
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

   /* @Override
    public void onDestroyView() {
        super.onDestroy();
       bind.unbind();
       mPresontion.destroy();
       mPresontion=null;
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
        mPresontion.destroy();
        mPresontion=null;
    }
}
