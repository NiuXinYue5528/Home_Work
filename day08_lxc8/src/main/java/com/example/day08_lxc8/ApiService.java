package com.example.day08_lxc8;

import com.example.day08_lxc8.bean.DatasBean;
import com.example.day08_lxc8.bean.NameBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiService {
    String baseUrl="https://api.yunxuekeji.cn/yunxue_app_api/content/";
    @GET("getData/30/66597/1/10")
    Observable<DatasBean> datas();


    String baseNameUrl="https://api.yunxuekeji.cn/yunxue_app_api/";
    @GET()
    Observable<NameBean> datas1(@Url String url);

}
