package com.example.day05_lxc5;

import com.jy.bean.DatasBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String baseUrl="http://c.m.163.com/nc/article/headline/";
    @GET("T1348647909107/0-20.html")
    Observable<DatasBean> datas();
}
