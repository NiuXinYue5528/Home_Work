package com.example.day08_lxc8.model;

import com.example.day08_lxc8.ApiService;
import com.example.day08_lxc8.Presention.HomePresontion;
import com.example.day08_lxc8.Presention.MainPresention;
import com.example.day08_lxc8.base.BaseModel;
import com.example.day08_lxc8.bean.DatasBean;
import com.example.day08_lxc8.bean.NameBean;
import com.example.day08_lxc8.callback.HomeCallBack;
import com.example.day08_lxc8.callback.MainCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {

    public void setData(MainCallBack mainCallBack) {

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<DatasBean> observable = apiService.datas();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DatasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(DatasBean datasBean) {
                        mainCallBack.onSuccess(datasBean);
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

    public void setDatass(HomeCallBack homeCallBack) {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseNameUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<NameBean> observable = apiService.datas1("teacher/getTeacherPower/191");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NameBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(NameBean nameBean) {
                        homeCallBack.onSuccess(nameBean);
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


    public void setDatas(HomeCallBack homeCallBack, int id) {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseNameUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<NameBean> observable = apiService.datas1("teacher/getTeacherPower/"+id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NameBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(NameBean nameBean) {
                        homeCallBack.onSuccess(nameBean);
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
