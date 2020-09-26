package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class AddActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent intent=getIntent();
        String name=intent.getStringExtra("key_1");

        Bundle bundle=new Bundle();
        bundle.putString("id_bundle",name);
        AddFragment addFragment=new AddFragment();
        addFragment.setArguments(bundle);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_activity,addFragment);
        fragmentTransaction.commit();


    }
}