package com.example.day06_lxc6.presontion;

import com.example.day06_lxc6.base.BasePresention;
import com.example.day06_lxc6.bean.FoodBean;
import com.example.day06_lxc6.callback.MainCallBack;
import com.example.day06_lxc6.model.MainModel;
import com.example.day06_lxc6.view.MainView;

public class MainPresontion extends BasePresention<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(FoodBean foodBean) {
        mView.setData(foodBean);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }

    public void setData() {
        mainModel.setData(this);
    }
}
