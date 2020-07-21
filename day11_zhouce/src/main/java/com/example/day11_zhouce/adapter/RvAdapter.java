package com.example.day11_zhouce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day11_zhouce.R;
import com.example.day11_zhouce.bean.ProjectBean;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ProjectBean.DataBean.DatasBean> list;

    public RvAdapter(Context context, ArrayList<ProjectBean.DataBean.DatasBean> list) {
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
        ProjectBean.DataBean.DatasBean datas = list.get(position);
        holder.iv_tv_name.setText(datas.getChapterName());
        holder.iv_tv_collec.setText(datas.getSuperChapterName());
      /*  holder.iv_tv_courid.setText(datas.getDesc());*/
        holder.tv_title.setText(datas.getTitle());
        holder.ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    datas.setCheck(true);
                }else{
                    datas.setCheck(false);
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
        public TextView iv_tv_name;
        public TextView tv_title;
        public TextView iv_tv_collec;
        public TextView iv_tv_courid;
        public CheckBox ck;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_tv_name = (TextView) rootView.findViewById(R.id.iv_tv_name);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.iv_tv_collec = (TextView) rootView.findViewById(R.id.iv_tv_collec);
            this.iv_tv_courid = (TextView) rootView.findViewById(R.id.iv_tv_courid);
            this.ck = (CheckBox) rootView.findViewById(R.id.ck);
        }

    }
}
