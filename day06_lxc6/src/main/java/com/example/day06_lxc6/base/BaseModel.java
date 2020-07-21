package com.example.day06_lxc6.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    //rxjava和网络请求处理和销毁保存和销毁
    public CompositeDisposable mDisposable=null;

    //双检索单列
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

    //解除rxjava网络请求销毁处理
    public void disposa(){
        mDisposable.dispose();
    }
    //移除removeDisposable
    public void removeDisposable(Disposable disposable){
        mDisposable.remove(disposable);
    }

}
