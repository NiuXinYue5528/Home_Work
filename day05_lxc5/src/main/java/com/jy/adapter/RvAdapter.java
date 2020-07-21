package com.jy.adapter;

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
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.request.RequestOptions;
import com.example.day05_lxc5.MainActivity;
import com.example.day05_lxc5.R;
import com.jy.bean.DatasBean;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DatasBean.T1348647909107Bean> list;

    public boolean isShow;


    public RvAdapter(Context context, ArrayList<DatasBean.T1348647909107Bean> list) {
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
        DatasBean.T1348647909107Bean datas = list.get(position);
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(context).load(datas.getImgsrc()).apply(options).into(holder.iv_img);
        holder.tv_title.setText(datas.getTitle());
        if (isShow==true) {
            holder.ck.setVisibility(View.VISIBLE);
        }else{
            holder.ck.setVisibility(View.GONE);
        }
        holder.ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    list.get(position).setCheck(true);//集合选中
                }else{
                    list.get(position).setCheck(false);//集合没有被选中
                }
              /*  boolean bb=false;
                for (int i = 0; i <list.size() ; i++) {
                    DatasBean.T1348647909107Bean bean = list.get(i);
                    if (bean.isCheck()){
                        bb=true;//被选中
                        break;//跳出循环
                    }
                }
                MainActivity activity= (MainActivity) context;
                activity.setDelete(bb);*/
            }
        });
        holder.ck.setChecked(datas.isCheck());//判断集合是否被选中
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
            this.ck = (CheckBox) rootView.findViewById(R.id.ck);
        }
    }
}
