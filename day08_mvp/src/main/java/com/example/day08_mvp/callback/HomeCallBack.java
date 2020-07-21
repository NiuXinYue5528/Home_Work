package com.example.day08_mvp.callback;

import com.example.day08_mvp.bean.ProjectBean;

public interface HomeCallBack {
    void onSuccess(ProjectBean projectBean);
    void onFail(String error);
}
