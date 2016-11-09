package com.example.lenovo.tasklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Lenovo on 11/7/2016.
 */

public class SwipeAdapter extends FragmentPagerAdapter {

    private List<Lists> mLists;


    public SwipeAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        mLists=Lists.createList();
        Fragment fragment=new DescriptionFragment();
        Bundle bundle=new Bundle();
        bundle.putString("Desc",mLists.get(position).getDescription());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        mLists=Lists.createList();
        return mLists.size();
    }
}
