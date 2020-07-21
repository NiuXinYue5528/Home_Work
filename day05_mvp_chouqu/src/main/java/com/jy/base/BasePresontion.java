package com.jy.base;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

public abstract class BasePresontion<V extends BaseView> {

    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();

    public BasePresontion(){
        initModel();//处理model
    }

    protected abstract void initModel();
    //处理model 便于管理
    public void addModel(BaseModel model){
        models.add(model);
    }
    //view 和model 绑定
    public void bindView(V view){
        this.mView=view;
    }
    //销毁
    public void destroy(){
        mView=null;
        for (int i = 0; i <models.size() ; i++) {
            models.get(i).disposa();
        }
    }
}
