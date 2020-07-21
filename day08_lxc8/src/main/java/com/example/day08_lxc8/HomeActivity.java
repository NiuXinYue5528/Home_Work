package com.example.day08_lxc8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day08_lxc8.Presention.HomePresontion;
import com.example.day08_lxc8.adapter.VpAdapter;
import com.example.day08_lxc8.base.BaseActivity;
import com.example.day08_lxc8.base.BaseFragment;
import com.example.day08_lxc8.bean.DatasBean;
import com.example.day08_lxc8.bean.NameBean;
import com.example.day08_lxc8.fragment.HomeFragment;
import com.example.day08_lxc8.fragment.PublicFragment;
import com.example.day08_lxc8.view.HomeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity<HomePresontion> implements HomeView {


    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_teacher_name)
    TextView tvTeacherName;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_btn)
    Button tvBtn;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> list;
    private ArrayList<String> titles;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        Intent intent = getIntent();
        DatasBean.BodyBean.ResultBean aaa = (DatasBean.BodyBean.ResultBean) intent.getSerializableExtra("aaa");
        Glide.with(this).load(aaa.getTeacherPic()).apply(new RequestOptions().circleCrop()).into(iv_img);
        tv_teacher_name.setText(aaa.getTeacherName());
        tv_title.setText(aaa.getTitle());
    }*/

    @Override
    protected void initListener() {

    }

    @Override
    protected void initPresention() {
        mPresention=new HomePresontion();
    }

    @Override
    protected void initData() {
        mPresention.setDatass();
    }

    @Override
    protected void initView() {
       // Intent intent = new Intent();
        Intent intent1 = getIntent();
        DatasBean.BodyBean.ResultBean aaa = (DatasBean.BodyBean.ResultBean) intent1.getSerializableExtra("aaa");
        Glide.with(this).load(aaa.getTeacherPic()).apply(new RequestOptions().circleCrop()).into(ivImg);
        tvTeacherName.setText(aaa.getTeacherName());
        tvTitle.setText(aaa.getTitle());

        list = new ArrayList<>();
        titles = new ArrayList<>();
    }

  /*  private void initView() {
        iv_img = (ImageView) findViewById(R.id.iv_img);
        tv_teacher_name = (TextView) findViewById(R.id.tv_teacher_name);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);


    }*/


    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void setData(NameBean nameBean) {
        List<NameBean.BodyBean.ResultBean> result = nameBean.getBody().getResult();
        for (int i = 0; i <result.size() ; i++) {
          //  list.add(new HomeFragment(nameBean.getBody().getResult().get(i).getId()));
            list.add(new PublicFragment());
            titles.add(result.get(i).getDescription());
        }
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), list, titles);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    public void showToast(String str) {
        Log.i("111", "showToast: "+str);
    }
}
