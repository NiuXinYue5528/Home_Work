package com.example.day08_mvp.view;

import com.example.day08_mvp.base.BaseView;
import com.example.day08_mvp.bean.ProjectBean;

public interface HomeView extends BaseView {
    void onSuccess(ProjectBean projectBean);
}
