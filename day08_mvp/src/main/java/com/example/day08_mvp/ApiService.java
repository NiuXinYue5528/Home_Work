package com.example.day08_mvp;

import com.example.day08_mvp.bean.ProjectBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.Streaming;

public interface ApiService {
    String baseUrl="https://www.wanandroid.com/project/list/";
    @GET("1/json?cid=294")
    Observable<ProjectBean> datas();


    String dwonUrl="https://dl.hdslb.com/mobile/latest/";
    @Streaming
    @GET("iBiliPlayer-bili.apk?t=1589783162000&spm_id_from=333.47.b_646f776e6c6f61642d6c696e6b.1")
    Observable<ResponseBody> dwon();
}
