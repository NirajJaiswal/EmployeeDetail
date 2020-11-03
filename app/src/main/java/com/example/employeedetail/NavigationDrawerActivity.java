package com.example.employeedetail;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.employeedetail.employee_detail.EmployeeDetailFragment;
import com.example.employeedetail.employee_detail.RecyclerFragment;
import com.example.employeedetail.listner.DataSendEmployeeFragToActivity;
import com.example.employeedetail.model.EmployeeDetails;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerActivity extends AppCompatActivity implements DataSendEmployeeFragToActivity {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private StartFragment startFragment;

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
    startFragment =new StartFragment();
        addFragment(startFragment);
        setTitle("Start Screen");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.login:
                        Toast.makeText(NavigationDrawerActivity.this, "Login..", Toast.LENGTH_SHORT).show();
                        addFragment(startFragment);
                        break;
                    case R.id.myOrder:
                         RecyclerFragment recyclerFragment=new RecyclerFragment();
                        addFragment(recyclerFragment);
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

    private void addFragment(Fragment fragment) {

       // TestNav testNav=new TestNav();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.f_layout,fragment,"hello");
        fragmentTransaction.commit();
    }




    @Override
    public void getData(EmployeeDetails employeeDetails)
    {
        if(employeeDetails!=null)
        {
            Bundle bundle=new Bundle();
            bundle.putSerializable("data",employeeDetails);
             EmployeeDetailFragment employeeDetailFragment=new EmployeeDetailFragment();
             employeeDetailFragment.setArguments(bundle);
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.f_layout,employeeDetailFragment,"data_frag");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else
        {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }

   /* @Override
    public void onBackPressed() {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    getApplicationContext());

            // set title
            alertDialogBuilder.setTitle("Exit");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Do you really want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, close
                            // current activity
                            NavigationDrawerActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            Toast.makeText(NavigationDrawerActivity.this, "i wanna stay on this page", Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

    }*/
}
