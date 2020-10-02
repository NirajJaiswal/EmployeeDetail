package com.example.employeedetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
private BottomSheetMedicine bottomSheetMedicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation);
        drawer = findViewById(R.id.drawer);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        addFragment();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.login:
                        Toast.makeText(NavigationDrawerActivity.this, "Login..", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.myOrder:
                        Toast.makeText(NavigationDrawerActivity.this, "My Order", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cart:
                        Toast.makeText(NavigationDrawerActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.wallet:
                        Toast.makeText(NavigationDrawerActivity.this, "Wallet", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.history:
                        Toast.makeText(NavigationDrawerActivity.this, "History", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }


        });
        View view = navigationView.getHeaderView(0);
        TextView email = view.findViewById(R.id.tv_email);
        TextView name = view.findViewById(R.id.tv_mailname);

        email.setText("shrey0196@gmail.com");
        name.setText("shreya");


    }

    private void addFragment() {
       RecyclerFragment recyclerFragment=new RecyclerFragment();
       // TestNav testNav=new TestNav();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.f_layout,recyclerFragment,"hello");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:

                Toast.makeText(this,"Item 1 selected",Toast.LENGTH_SHORT).show();

                bottomSheetMedicine=new BottomSheetMedicine();
                bottomSheetMedicine.show(getSupportFragmentManager(),"bottomSheet");

                return true;
            case R.id.item2:
                Toast.makeText(this,"Item 2 selected",Toast.LENGTH_SHORT).show();
               return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
