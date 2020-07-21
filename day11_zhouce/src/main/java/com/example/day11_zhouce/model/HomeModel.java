package com.example.day11_zhouce.model;

import android.util.Log;

import com.example.day11_zhouce.ApiService;
import com.example.day11_zhouce.base.BaseModel;
import com.example.day11_zhouce.bean.ProjectBean;
import com.example.day11_zhouce.callback.HomeCallBack;
import com.example.day11_zhouce.presontion.HomePresonton;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModel extends BaseModel {

    public void setData(HomeCallBack homeCallBack) {

        //获取retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseUrl)
                .build();
        //获取服务接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        //被观察者
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
                        Log.i("222", "onError: "+e.getMessage());
                        homeCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
