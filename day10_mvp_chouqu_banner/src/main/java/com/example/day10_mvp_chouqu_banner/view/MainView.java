package com.example.day10_mvp_chouqu_banner.view;

import com.example.day10_mvp_chouqu_banner.base.BaseView;
import com.example.day10_mvp_chouqu_banner.bean.FoodBean;

public interface MainView extends BaseView {
    void onSuccess(FoodBean foodBean);
}
