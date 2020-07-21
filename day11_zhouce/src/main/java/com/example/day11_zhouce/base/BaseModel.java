package com.example.day11_zhouce.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {

    //统一处理rxjava和网络请求的保存和销毁
    public CompositeDisposable mDisposable=null;

    //双检索单列
    public void addDisposable(Disposable disposable){
        if(mDisposable==null){
            synchronized(BaseModel.class){
                if (mDisposable==null){
                    mDisposable=new CompositeDisposable();//创一个CompositeDisposable对象
                }
            }
        }
        mDisposable.add(disposable);//添加到CompositeDisposable
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
