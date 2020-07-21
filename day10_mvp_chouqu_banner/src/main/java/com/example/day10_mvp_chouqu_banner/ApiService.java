package com.example.day10_mvp_chouqu_banner;

import com.example.day10_mvp_chouqu_banner.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {
    String baseUrl="https://www.qubaobei.com/ios/cf/";
    @GET("dish_list.php?stage_id=1&limit=20&page=")
    Observable<FoodBean> datas(@Query("page") int page);
}
