package com.example.day11_zhouce.callback;

import com.example.day11_zhouce.bean.ProjectBean;

public interface HomeCallBack {
    void onSuccess(ProjectBean projectBean);
    void onFail(String error);
}
