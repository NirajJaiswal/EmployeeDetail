package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.employeedetail.adapter.CountryAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomSpinnerActivity extends AppCompatActivity {
private CountryAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);
        Spinner spinner=findViewById(R.id.spinner_country);
        mAdapter=new CountryAdapter(this,initList());
        spinner.setAdapter(mAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem countryItem=(CountryItem)parent.getItemAtPosition(position);
                String countryName=countryItem.getCountryName();

                Toast.makeText(CustomSpinnerActivity.this,countryName + " selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    private List<CountryItem> initList() {
        List<CountryItem>mCountryList=new ArrayList<>();
        mCountryList.add(new CountryItem("India",R.drawable.india));
        mCountryList.add(new CountryItem("Bangladesh",R.drawable.bangladesh));
        mCountryList.add(new CountryItem("Canada",R.drawable.canada));
        mCountryList.add(new CountryItem("Japan",R.drawable.japan));
        mCountryList.add(new CountryItem("U.S.A.",R.drawable.usa));
        return mCountryList;



    }
}