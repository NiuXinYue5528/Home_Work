package com.jy.callback;

import com.jy.bean.DatasBean;

public interface MainCallBack {
    void onSuccess(DatasBean datasBean);
    void onFail(String str);
}
