package com.jy.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    //model基类   做一些rxjava和网络请求保存和销毁
    public CompositeDisposable mDisposable=null;

    //双检索单列
    public void addDisposable(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null){
                    mDisposable=new CompositeDisposable();//创建CompositeDisposable对象
                }
            }
        }
        //吧网络请求放入到CompositeDisposable中
        mDisposable.add(disposable);
    }
    //销毁
    public void disposa(){
        mDisposable.dispose();
    }
    //移除disposable
    public void removeDisposable(Disposable disposable){
        mDisposable.remove(disposable);
    }

}
