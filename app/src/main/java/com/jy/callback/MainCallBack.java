package com.jy.callback;

import com.jy.bean.FoodBean;

public interface MainCallBack {
    void onSuccess(FoodBean foodBean);
    void onFail(String error);
}
