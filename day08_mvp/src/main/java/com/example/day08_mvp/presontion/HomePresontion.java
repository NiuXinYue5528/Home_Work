package com.example.day08_mvp.presontion;

import com.example.day08_mvp.base.BasePresontion;
import com.example.day08_mvp.bean.ProjectBean;
import com.example.day08_mvp.callback.HomeCallBack;
import com.example.day08_mvp.model.HomeModel;
import com.example.day08_mvp.view.HomeView;

public class HomePresontion extends BasePresontion<HomeView> implements HomeCallBack {

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
       homeModel.setDatas(this);
    }
}
