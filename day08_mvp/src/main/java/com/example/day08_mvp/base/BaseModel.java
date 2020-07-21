package com.example.day08_mvp.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    //统一处理rxjava和网络请求的保存和销毁
    public CompositeDisposable mDisposable=null;
    public void addDisposable(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null){
                    mDisposable=new CompositeDisposable();
                }
            }
        }
        mDisposable.add(disposable);
    }
    //销毁
    public void disposa(){
        mDisposable.dispose();
    }
    //移除
    public void removeDisposable(Disposable disposable){
        mDisposable.remove(disposable);
    }
}
