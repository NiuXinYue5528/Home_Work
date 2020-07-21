package com.example.day08_lxc8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08_lxc8.R;
import com.example.day08_lxc8.bean.NameBean;

import java.util.ArrayList;

public class TwoRvAdapter extends RecyclerView.Adapter<TwoRvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NameBean.BodyBean.ResultBean> list;

    public TwoRvAdapter(Context context, ArrayList<NameBean.BodyBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv1, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NameBean.BodyBean.ResultBean resultBean = list.get(position);
        holder.tv_titile.setText(resultBean.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_titile;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_titile = (TextView) rootView.findViewById(R.id.tv_titile);
        }
    }
}
