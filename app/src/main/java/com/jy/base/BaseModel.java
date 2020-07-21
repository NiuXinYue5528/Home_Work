package com.jy.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    //model的基类 网络请求加入到rxjava  保存和销毁
    private CompositeDisposable mDisposable=null;

    //双检索单列
    public void addDisposable(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null){
                    mDisposable=new CompositeDisposable();//创建一个CompositeDisposable
                }
            }
        }
        //把网络请求保存在CompositeDisposable
        mDisposable.add(disposable);
    }
    //解除rxjava与网络请求的关联  接触网络请求
    public void disposable(){
        mDisposable.dispose();
    }
    //移除dispose
    public void removeDisposable(Disposable disposable){
        if (mDisposable!=null){
            mDisposable.remove(disposable);
            mDisposable=null;
        }
    }
}
