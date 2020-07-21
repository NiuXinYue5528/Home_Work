package com.example.day08_mvp.model;

import com.example.day08_mvp.ApiService;
import com.example.day08_mvp.base.BaseModel;
import com.example.day08_mvp.bean.ProjectBean;
import com.example.day08_mvp.callback.HomeCallBack;
import com.example.day08_mvp.presontion.HomePresontion;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModel extends BaseModel {
    public void setDatas(HomeCallBack homeCallBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ProjectBean> observable = apiService.datas();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProjectBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ProjectBean projectBean) {
                        homeCallBack.onSuccess(projectBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
