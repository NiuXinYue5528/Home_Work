package com.example.day10_mvp_chouqu_banner.model;

import android.util.Log;

import com.example.day10_mvp_chouqu_banner.ApiService;
import com.example.day10_mvp_chouqu_banner.base.BaseModel;
import com.example.day10_mvp_chouqu_banner.bean.FoodBean;
import com.example.day10_mvp_chouqu_banner.callback.MainCallBack;
import com.example.day10_mvp_chouqu_banner.presontion.MainPresontion;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void setData(int page, MainCallBack mainCallBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FoodBean> observable = apiService.datas( page);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                        Log.i("222", "onError: "+e.getMessage());
                        mainCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
