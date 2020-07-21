package com.example.day10_mvp_chouqu_banner.presontion;

import com.example.day10_mvp_chouqu_banner.base.BasePresontion;
import com.example.day10_mvp_chouqu_banner.bean.FoodBean;
import com.example.day10_mvp_chouqu_banner.callback.MainCallBack;
import com.example.day10_mvp_chouqu_banner.model.MainModel;
import com.example.day10_mvp_chouqu_banner.view.MainView;

public class MainPresontion extends BasePresontion<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(FoodBean foodBean) {
        mView.onSuccess(foodBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }

    public void setData(int page) {
        mainModel.setData(page,this);
    }
}
