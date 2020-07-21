package com.example.day08_lxc8.Presention;

import com.example.day08_lxc8.base.BasePresention;
import com.example.day08_lxc8.base.BaseView;
import com.example.day08_lxc8.bean.DatasBean;
import com.example.day08_lxc8.bean.NameBean;
import com.example.day08_lxc8.callback.MainCallBack;
import com.example.day08_lxc8.model.MainModel;
import com.example.day08_lxc8.view.MainView;

public class MainPresention extends BasePresention<MainView> implements MainCallBack {


    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(DatasBean datasBean) {
        mView.setData(datasBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }



    public void setData() {
        mainModel.setData(this);
    }
}
