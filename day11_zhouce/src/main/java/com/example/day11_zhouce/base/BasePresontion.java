package com.example.day11_zhouce.base;

import java.util.ArrayList;

public abstract class BasePresontion<V extends BaseView> {
    //左手view
    public V mView;

    //右手model
    public ArrayList<BaseModel> models=new ArrayList<>();

    //构造
    public BasePresontion(){
        //处理model
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel model){
        //收集model 便于管理
        models.add(model);
    }
    //绑定view
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
