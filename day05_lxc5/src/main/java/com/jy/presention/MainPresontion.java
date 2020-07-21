package com.jy.presention;

import com.jy.base.BasePersention;
import com.jy.base.BaseView;
import com.jy.bean.DatasBean;
import com.jy.callback.MainCallBack;
import com.jy.model.MainModel;
import com.jy.view.MainView;

public class MainPresontion extends BasePersention<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);//实列化model
       // models.add(mainModel);
    }

    @Override
    public void onSuccess(DatasBean datasBean) {
        mView.setData(datasBean);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }

    public void setData() {
        mainModel.setData(this);
    }
}
