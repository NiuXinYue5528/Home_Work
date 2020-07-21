package com.jy.model;

import com.example.day05_mvp_chouqu.ApiService;
import com.jy.base.BaseModel;
import com.jy.bean.FoodBean;
import com.jy.callback.MainCallBack;
import com.jy.net.BaseObserver;
import com.jy.net.RxUtils;
import com.jy.presention.MainPresontion;
import com.jy.util.HttpUtils;

import io.reactivex.Observable;

public class MainModel extends BaseModel {

    public void setData(MainCallBack mainCallBack) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.baseUrl, ApiService.class);
        Observable<FoodBean> observable = apiserver.datas();
        //简化线程
        observable.compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FoodBean>(this) {
                    @Override
                    protected void onSuccess(FoodBean foodBean) {
                        mainCallBack.onSuccess(foodBean);
                    }

                    @Override
                    protected void error(String err) {
                        mainCallBack.onFail(err);
                    }
                });
    }
}
