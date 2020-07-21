package com.example.day08_mvp.base;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

public abstract class BasePresontion<V extends BaseView> {

    public  V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();

    public BasePresontion(){
        initModel();//初始化model
    }

    protected abstract void initModel();
    //收集model 便于管理
    public void addModel(BaseModel model){
        models.add(model);
    }
    //绑定view
    public void bindView(V view){
        this.mView=view;
    }
    //view和model解除
    public void destroy(){
        mView=null;
        for (int i = 0; i <models.size() ; i++) {
            models.get(i).disposa();
        }
    }
}
