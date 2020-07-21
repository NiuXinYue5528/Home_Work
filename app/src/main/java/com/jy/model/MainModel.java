package com.jy.model;

import com.example.day04_mvp_activity.ApiService;
import com.jy.base.BaseModel;
import com.jy.bean.FoodBean;
import com.jy.callback.MainCallBack;
import com.jy.presention.MainPresention;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {

    public void setData(final MainCallBack mainCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FoodBean> observable = apiService.datas();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(FoodBean foodBean) {
                        mainCallBack.onSuccess(foodBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
