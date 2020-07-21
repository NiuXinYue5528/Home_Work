package com.jy.presention;

import com.jy.base.BasePresontion;
import com.jy.bean.FoodBean;
import com.jy.callback.MainCallBack;
import com.jy.model.MainModel;
import com.jy.view.MainView;

public class MainPresontion extends BasePresontion<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        models.add(mainModel);
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
