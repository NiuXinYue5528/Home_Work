package com.example.day06_lxc6.callback;

import com.example.day06_lxc6.bean.FoodBean;

public interface MainCallBack {
    void onSuccess(FoodBean foodBean);
    void onFail(String str);
}
