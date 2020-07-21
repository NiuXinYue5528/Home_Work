package com.example.day08_lxc8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day08_lxc8.R;
import com.example.day08_lxc8.bean.DatasBean;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context contextl;
    private ArrayList<DatasBean.BodyBean.ResultBean> list;
    private onItemClick onItemClick;

    public void setOnItemClick(RvAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public RvAdapter(Context contextl, ArrayList<DatasBean.BodyBean.ResultBean> list) {
        this.contextl = contextl;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(contextl).inflate(R.layout.item_rv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DatasBean.BodyBean.ResultBean datas = list.get(position);
        Glide.with(contextl).load(datas.getTeacherPic()).apply(new RequestOptions().circleCrop()).into(holder.iv_img);
        holder.tv_teacher_name.setText(datas.getTeacherName());
        holder.tv_title.setText(datas.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick!=null){
                    onItemClick.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;
        public TextView tv_teacher_name;
        public TextView tv_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_teacher_name = (TextView) rootView.findViewById(R.id.tv_teacher_name);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }
    }

    public interface onItemClick{
        void onClick(int position);
    }
}
