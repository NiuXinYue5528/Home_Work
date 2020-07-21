package com.example.day08_lxc8.callback;

import com.example.day08_lxc8.bean.NameBean;

public interface HomeCallBack {
    void onSuccess(NameBean nameBean);
    void onFail(String error);
}
