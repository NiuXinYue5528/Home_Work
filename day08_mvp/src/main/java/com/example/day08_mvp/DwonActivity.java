package com.example.day08_mvp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day08_mvp.bean.EventBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DwonActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar pb;
    private TextView tv_text;
    private Button btn_dwon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dwon);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        pb = (ProgressBar) findViewById(R.id.pb);
        tv_text = (TextView) findViewById(R.id.tv_text);
        btn_dwon = (Button) findViewById(R.id.btn_dwon);

        btn_dwon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dwon:
                Intent intent = new Intent(this, DwonService.class);
                startService(intent);
                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(EventBean eventBean){
        int max = eventBean.getMax();
        int progress = eventBean.getProgress();
        pb.setMax(max);
        pb.setProgress(progress);
        int  v = (int) (100f*progress / max);
        Log.i("progress", "getEvent: "+v);
        tv_text.setText("当前下载进度："+v+"%");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
