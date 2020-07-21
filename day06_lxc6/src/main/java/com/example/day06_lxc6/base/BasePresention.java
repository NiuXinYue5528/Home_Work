package com.example.day06_lxc6.base;

import java.util.ArrayList;

public abstract class BasePresention<V extends BaseView> {
    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();

    public BasePresention(){
        initModel();//处理model
    }

    protected abstract void initModel();
    //绑定view和model
    public void binView(V view){
        this.mView=view;
    }
    //收集model便于管理
    public void addModel(BaseModel model){
        models.add(model);
    }
    //销毁v和model
    public  void destroy(){
        mView=null;
        for (int i = 0; i <models.size() ; i++) {
            models.get(i).disposa();
        }
    }
}
