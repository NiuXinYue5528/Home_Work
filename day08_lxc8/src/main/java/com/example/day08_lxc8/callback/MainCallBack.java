package com.example.day08_lxc8.callback;

import com.example.day08_lxc8.bean.DatasBean;
import com.example.day08_lxc8.bean.NameBean;

public interface MainCallBack {
    void onSuccess(DatasBean datasBean);
    void onFail(String error);



}
