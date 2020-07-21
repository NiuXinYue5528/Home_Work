package com.example.day08_mvp;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import com.example.day08_mvp.bean.EventBean;

import org.greenrobot.eventbus.EventBus;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DwonService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        images();
        return super.onStartCommand(intent, flags, startId);
    }

    private void images() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.dwonUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ResponseBody> observable = apiService.dwon();
        observable.subscribeOn(Schedulers.io())
        .subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {
                d.isDisposed();
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                long contentLength = responseBody.contentLength();
                InputStream in = responseBody.byteStream();
                saveFail(in, Environment.getExternalStorageDirectory() + "/123.apk", contentLength);
        }

            @Override
            public void onError(Throwable e) {
                Log.i("11", "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void saveFail(InputStream in, String path, long contentLength) {
        int count=0;
        try {
            FileOutputStream out = new FileOutputStream(path);
            int len=0;
            byte[] bytes = new byte[1024];
           while ((len=in.read(bytes))!=-1){
               out.write(bytes, 0, len);
               count+=len;
               EventBus.getDefault().post(new EventBean(count, (int) contentLength));
           }
           out.close();
           in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
