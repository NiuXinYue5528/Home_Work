package com.example.day08_lxc8.base;

import java.util.ArrayList;

public abstract class BasePresention<V extends BaseView> {

    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();

    public BasePresention(){
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel model){
        models.add(model);
    }
    public void bindView(V view){
        this.mView=view;
    }

    public void destroy(){
        mView=null;
        for (int i = 0; i <models.size() ; i++) {
            models.get(i).disposa();
        }
    }


}
