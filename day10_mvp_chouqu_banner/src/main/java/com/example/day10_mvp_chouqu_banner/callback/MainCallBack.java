package com.example.day10_mvp_chouqu_banner.callback;

import com.example.day10_mvp_chouqu_banner.bean.FoodBean;

public interface MainCallBack {
    void onSuccess(FoodBean foodBean);
    void onFail(String error);
}
