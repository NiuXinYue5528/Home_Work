package com.jy.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {

    //左手view
    public V mView;
    //右手model
    public ArrayList<BaseModel> models=new ArrayList<>();

    public  BasePresenter(){
        initMolel();//处理model//抽象方法
    }

    protected abstract void initMolel();

    //收集model  便于管理
    public void addModel(BaseModel model){
        models.add(model);
    }
    //bindView
    public void bindView(V view){
        this.mView=view;//绑定view
    }
    //view调用 p销毁 解除 v和p的关系 停止网络请求
    public void destroy(){
        mView=null;
        for (int i = 0; i <models.size() ; i++) {
            BaseModel baseModel = models.get(i);//p销毁 mview也可以等于空 用不到gc回收垃圾
            baseModel.disposable();
        }
    }

}
