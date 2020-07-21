package com.example.day08_lxc8.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    //统一处理rxjava和网络请求保存和销毁
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

    public void disposa(){
        mDisposable.dispose();
    }
    public void removeDisposable(Disposable disposable){
        mDisposable.remove(disposable);
    }

}
