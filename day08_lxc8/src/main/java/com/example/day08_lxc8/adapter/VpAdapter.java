package com.example.day08_lxc8.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.day08_lxc8.bean.NameBean;

import java.util.ArrayList;
import java.util.List;

public class VpAdapter extends FragmentPagerAdapter {
   private ArrayList<Fragment> result;
    private ArrayList<String>  title;

    public VpAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> result, ArrayList<String> title) {
        super(fm);
        this.result = result;
        this.title = title;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return result.get(position);
    }

    @Override
    public int getCount() {
        return result.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
