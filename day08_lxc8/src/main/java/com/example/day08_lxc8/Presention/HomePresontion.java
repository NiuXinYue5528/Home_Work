package com.example.day08_lxc8.Presention;

import androidx.viewpager.widget.ViewPager;

import com.example.day08_lxc8.base.BaseFragment;
import com.example.day08_lxc8.base.BasePresention;
import com.example.day08_lxc8.base.BaseView;
import com.example.day08_lxc8.bean.NameBean;
import com.example.day08_lxc8.callback.HomeCallBack;
import com.example.day08_lxc8.model.MainModel;
import com.example.day08_lxc8.view.HomeView;
import com.example.day08_lxc8.view.MainView;

public class HomePresontion extends BasePresention<HomeView> implements HomeCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    public void setDatass() {
        mainModel.setDatass(this);
    }

    @Override
    public void onSuccess(NameBean nameBean) {
        mView.setData(nameBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }

    public void setDatas(int id) {
        mainModel.setDatas(this,id);
    }
}
