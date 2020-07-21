package com.example.day10_mvp_chouqu_banner.adapter;

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
import com.bumptech.glide.request.RequestOptions;
import com.example.day10_mvp_chouqu_banner.MainActivity;
import com.example.day10_mvp_chouqu_banner.R;
import com.example.day10_mvp_chouqu_banner.bean.FoodBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<FoodBean.DataBean> list;
    private int VIEW_TYPE_ONE = 1;
    private int VIEW_TYPE_TWO = 2;
    private final LayoutInflater inflater;
    public boolean isShow;
    private ViewHolder1 viewHolder1;


    public RvAdapter(Context context, ArrayList<FoodBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ONE) {
            View inflate = inflater.inflate(R.layout.item_banner, null);
            return new ViewHolder(inflate);
        } else {
            View inflate = inflater.inflate(R.layout.item_rv, null);
            return new ViewHolder1(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();

        ArrayList<String> images = new ArrayList<>();
        if (itemViewType==VIEW_TYPE_ONE){
            ViewHolder viewHolder= (ViewHolder) holder;
            for (int i = 0; i < this.list.size(); i++) {
                images.add(list.get(i).getPic());
            }
            viewHolder.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).setImages(images).start();
        }else{
            FoodBean.DataBean bean = list.get(position-1);
            viewHolder1 = (ViewHolder1) holder;
            Glide.with(context).load(bean.getPic()).apply(new RequestOptions().circleCrop()).into(viewHolder1.iv_img);
            viewHolder1.tv_title.setText(bean.getTitle());
            if (isShow==true){
                viewHolder1.ck.setVisibility(View.VISIBLE);
            }else{
                viewHolder1.ck.setVisibility(View.GONE);
            }
            viewHolder1.ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked==true){
                        bean.setCheck(true);
                    }else{
                        bean.setCheck(false);
                    }
                    boolean bb=false;
                    for (int i = 0; i <list.size() ; i++) {
                        FoodBean.DataBean dataBean = list.get(i);
                        if (dataBean.isCheck()){
                            bb=true;
                            break;//跳出循环
                        }
                    }
                    MainActivity activity= (MainActivity) context;
                    activity.setDelete(bb);
                }
            });
          viewHolder1.ck.setChecked(list.get(position).isCheck());//集合被选中
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return VIEW_TYPE_ONE;
        }else{
            return VIEW_TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public Banner banner;

        public ViewHolder(View rootView) {
            super(rootView);
            this.banner = (Banner) rootView.findViewById(R.id.banner);
        }
    }
    public static

    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;
        public TextView tv_title;
        public CheckBox ck;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.ck= (CheckBox) rootView.findViewById(R.id.ck);
        }

    }
}
