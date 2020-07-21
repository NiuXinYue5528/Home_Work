package com.example.day11_zhouce.presontion;

import com.example.day11_zhouce.base.BasePresontion;
import com.example.day11_zhouce.bean.ProjectBean;
import com.example.day11_zhouce.callback.HomeCallBack;
import com.example.day11_zhouce.model.HomeModel;
import com.example.day11_zhouce.view.HomeView;

public class HomePresonton extends BasePresontion<HomeView> implements HomeCallBack {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
        addModel(homeModel);
    }

    @Override
    public void onSuccess(ProjectBean projectBean) {
        mView.onSuccess(projectBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }

    public void setData() {
       homeModel.setData(this);
    }
}
