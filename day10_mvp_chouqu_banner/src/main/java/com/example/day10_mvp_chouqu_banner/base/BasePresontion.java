package com.example.day10_mvp_chouqu_banner.base;

import java.util.ArrayList;

public abstract class BasePresontion<V extends BaseView> {
    //左手view
    public V mView;
    //右手model
    public ArrayList<BaseModel> models=new ArrayList<>();

    public BasePresontion(){
        initModel();
    }

    protected abstract void initModel();
    //收集model
    public void addModel(BaseModel model){
        models.add(model);
    }

    public void binView(V view){
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
