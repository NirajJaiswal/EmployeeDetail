package com.example.employeedetail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.employeedetail.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TabLayoutActivity extends AppCompatActivity {

private TabLayout tabLayout;
private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);


        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.myViewPager);



        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ChatFragment(),"CHATS");
        viewPagerAdapter.addFragment(new StatusFragment(),"STATUS");
        viewPagerAdapter.addFragment(new CallsFragment(),"CALLS");
        viewPager.setAdapter(viewPagerAdapter);
    }

}