package com.jy.base;

import java.util.ArrayList;

public abstract class BasePersention<V extends BaseView> {
    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();

    public BasePersention(){
        //处理model
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel model){
        models.add(model);//收集model 便于管理
    }
    public void bindView(V view){
        //view和 model绑定
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
