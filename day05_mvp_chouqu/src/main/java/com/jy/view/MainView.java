package com.jy.view;

import com.jy.base.BaseView;
import com.jy.bean.FoodBean;

public interface MainView extends BaseView {
    void setData(FoodBean foodBean);
}
