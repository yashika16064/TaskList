package com.example.lenovo.tasklist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;

import java.util.List;

import static com.example.lenovo.tasklist.ListsAdapter.key;

public class DescriptionPagerActivity extends AppCompatActivity{

    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_pager);

        mViewPager= (ViewPager) findViewById(R.id.activity_description_pager_view_pager);
        Intent intent = getIntent();
        int pos = intent.getIntExtra(key,0);
        SwipeAdapter swipeAdapter=new SwipeAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(swipeAdapter);
        mViewPager.setCurrentItem(pos);

           /*) @Override
            public Fragment getItem(int position) {
                Lists li= mLists.get(position);
                return Description;
            }

        });*/

    }
}
