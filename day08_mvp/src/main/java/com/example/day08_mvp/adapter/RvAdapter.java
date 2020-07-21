package com.example.day08_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day08_mvp.MainActivity;
import com.example.day08_mvp.R;
import com.example.day08_mvp.bean.EventBean;
import com.example.day08_mvp.bean.ProjectBean;
import com.example.day08_mvp.fragment.HomeFragment;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ProjectBean.DataBean.DatasBean> list;

    private onItemClick onItemClick;

    public void setOnItemClick(RvAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

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
        Glide.with(context).load(datas.getEnvelopePic()).into(holder.iv_img);
        holder.tv_title.setText(datas.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick!=null){
                    onItemClick.onClick(position);
                }
            }
        });
       holder.ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked==true){
                   datas.setCheck(true);//集合是否被选中
               }else{
                   datas.setCheck(false);//集合没有选中
               }
            /*   boolean bb=false;
               for (int i = 0; i <list.size() ; i++) {
                   ProjectBean.DataBean.DatasBean datas = list.get(i);
                   if (datas.isCheck()){
                       bb=true;
                       break;
                   }
               }*/

           }
       });
       holder.ck.setChecked(list.get(position).isCheck());//集合被选中
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;
        public TextView tv_title;
        public CheckBox ck;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.ck= (CheckBox) rootView.findViewById(R.id.ck);
        }
    }
    public interface onItemClick{
        void onClick(int position);
    }
}
