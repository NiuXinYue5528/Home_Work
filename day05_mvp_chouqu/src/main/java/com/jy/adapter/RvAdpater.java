package com.jy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day05_mvp_chouqu.R;
import com.jy.bean.FoodBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvAdpater extends RecyclerView.Adapter<RvAdpater.ViewHolder> {
    private Context context;
    private ArrayList<FoodBean.DataBean> list;

    public RvAdpater(Context context, ArrayList<FoodBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodBean.DataBean datas = list.get(position);
        Glide.with(context).load(datas.getPic()).into(holder.ivImg);
        holder.tvTitle.setText(datas.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
