package com.jy.model;

import com.example.day05_lxc5.ApiService;
import com.jy.base.BaseModel;
import com.jy.base.BaseView;
import com.jy.bean.DatasBean;
import com.jy.callback.MainCallBack;
import com.jy.net.BaseObserver;
import com.jy.net.HttpUtils;
import com.jy.net.RxUtils;
import com.jy.presention.MainPresontion;

import io.reactivex.Observable;

public class MainModel extends BaseModel {
    public void setData(MainCallBack mainCallBack) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.baseUrl, ApiService.class);
        Observable<DatasBean> observable = apiserver.datas();
        observable.compose(RxUtils.rxObserableSchedulerHelper())
               .subscribe(new BaseObserver<DatasBean>(this) {
                   @Override
                   protected void onSuccess(DatasBean datasBean) {
                       mainCallBack.onSuccess(datasBean);
                   }

                   @Override
                   protected void error(String err) {
                       mainCallBack.onFail(err);
                   }
               });
    }
}
