package com.jy.presention;

import com.jy.base.BasePresenter;
import com.jy.base.BaseView;
import com.jy.bean.FoodBean;
import com.jy.callback.MainCallBack;
import com.jy.model.MainModel;
import com.jy.view.MainView;

public  class MainPresention extends BasePresenter<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initMolel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(FoodBean foodBean) {
        mView.setData(foodBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }

    public void setData() {
        mainModel.setData(this);
    }
}
