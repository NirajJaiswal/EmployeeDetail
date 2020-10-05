package com.example.employeedetail.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.employeedetail.R;

public class NavigationActivity extends AppCompatActivity implements FragmentNavigation.FragNavigationListener {
   private FragmentManager manager;
    private FragmentTransaction transaction;
    private FragmentNavigate fragmentNavigate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
addFragment();
    }

    private void addFragment() {
        manager=getSupportFragmentManager();
         transaction=manager.beginTransaction();
        FragmentNavigation fragmentNavigation=new FragmentNavigation();

        transaction.replace(R.id.container_navigation,fragmentNavigation);
        transaction.commit();

    }


    @Override
    public void printText(String input) {
        if(input!=null){
            fragmentNavigate=new FragmentNavigate();
            Bundle bundle=new Bundle();
            bundle.putString("id",input);
            fragmentNavigate.setArguments(bundle);
            manager=getSupportFragmentManager();
            transaction=manager.beginTransaction();
            transaction.replace(R.id.container_navigation,fragmentNavigate);
            transaction.commit();
        }
    }


}