package com.jy.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    //model基类 主要是rxjava请求数据保存和销毁
    public CompositeDisposable mDisposable=null;

    //双检索单列
    public void addDisposable(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null){
                    mDisposable=new CompositeDisposable();//创建CompositeDisposable一个对象
                }
            }
        }
        //网络请求放入CompositeDisposable
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
