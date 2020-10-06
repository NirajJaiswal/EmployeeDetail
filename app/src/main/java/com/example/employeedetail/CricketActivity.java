package com.example.employeedetail;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.employeedetail.listner.DataSendCricketerFragToActivity;
import com.example.employeedetail.model.CricketerDetails;

public class CricketActivity extends AppCompatActivity implements DataSendCricketerFragToActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);
        toolbar=findViewById(R.id.cricket_toolbar);
        setSupportActionBar(toolbar);
        setValue();
    }

    private void setValue() {

        CricketFragment cricketFragment=new CricketFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.cricket_container, cricketFragment,"Cricket");
        fragmentTransaction.commit();
    }

    @Override
    public void getData(CricketerDetails cricketerDetails){
        if(cricketerDetails!=null){

            Bundle bundle=new Bundle();
            bundle.putSerializable("Cricketer",cricketerDetails);
            CricketDetailsFragment cricketDetailsFragment=new CricketDetailsFragment();
            cricketDetailsFragment.setArguments(bundle);
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.cricket_container,cricketDetailsFragment,"cricket");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
        else{
            Toast.makeText(this, "No Cricketer found", Toast.LENGTH_SHORT).show();
        }
    }
}