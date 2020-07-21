package com.example.day06_lxc6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day06_lxc6.R;
import com.example.day06_lxc6.bean.FoodBean;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<FoodBean.DataBean> list;
    private int VIEW_TYPE_ONE = 1;
    private int VIEW_TYPE_TWO = 2;
    private onItemClick onItemClick;

    public void setOnItemClick(RvAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public RvAdapter(Context context, ArrayList<FoodBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ONE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv,parent,false);
            return new ViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv1, null);
            return new ViewHolder1(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();
        FoodBean.DataBean datas = list.get(position);
        if (itemViewType==VIEW_TYPE_ONE){
            ViewHolder viewHolder= (ViewHolder) holder;
            viewHolder.tv_zuo.setText(datas.getFood_str());
            viewHolder.tv_time.setText(datas.getCollect_num());
            viewHolder.tv_title.setText(datas.getTitle());
        }else{
            ViewHolder1 viewHolder1= (ViewHolder1) holder;
            viewHolder1.tv_zuo.setText(datas.getFood_str());
            viewHolder1.tv_time.setText(datas.getCollect_num());
            viewHolder1.tv_title.setText(datas.getTitle());
            Glide.with(context).load(datas.getPic()).into(viewHolder1.iv_img);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick!=null){
                    onItemClick.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return VIEW_TYPE_ONE;
        }else {
            return VIEW_TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_zuo;
        public TextView tv_time;
        public TextView tv_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_zuo = (TextView) rootView.findViewById(R.id.tv_zuo);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }

    }
    public static

    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_zuo;
        public TextView tv_time;
        public TextView tv_title;
        public ImageView iv_img;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_zuo = (TextView) rootView.findViewById(R.id.tv_zuo);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
        }

    }
    public interface onItemClick{
        void onClick(int position);
    }
}
