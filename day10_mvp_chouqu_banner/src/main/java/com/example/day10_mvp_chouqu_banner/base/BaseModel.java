package com.example.day10_mvp_chouqu_banner.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    //统一处理网络请求和rxjava保存和处理
    public CompositeDisposable mDisposable=null;

    //双检索单列
    public void addDisposable(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null){
                    mDisposable=new CompositeDisposable();//创建一个CompositeDisposable()对象
                }
            }
        }
        mDisposable.add(disposable);//添加到CompositeDisposable()
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
