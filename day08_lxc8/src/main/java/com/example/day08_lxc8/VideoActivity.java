package com.example.day08_lxc8;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    private VideoView vv;
    private String url="https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/从技术走向管理/001.从技术到管理_第1节_从技术到管理的内外部因素.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
    }

    private void initView() {
        vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoURI(Uri.parse(url));
        vv.start();
        MediaController mediaController = new MediaController(this);
        vv.setMediaController(mediaController);
    }
}
