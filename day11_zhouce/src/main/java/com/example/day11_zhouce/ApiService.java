package com.example.day11_zhouce;

import com.example.day11_zhouce.bean.ProjectBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String baseUrl="https://www.wanandroid.com/project/";
    @GET("list/1/json?cid=294")
    Observable<ProjectBean> datas();
}
