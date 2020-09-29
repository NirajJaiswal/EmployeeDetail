package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner=(Spinner) findViewById(R.id.spinnerSpin);




        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,loadData());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> loadData() {
        List<String> mList=new ArrayList<>();

        mList.add("APPLE");
        mList.add("MANGO");
        mList.add("BANANA");
        mList.add("ORANGE");
        mList.add("GUAVA");
        mList.add("GRAPES");
        mList.add("KIWI");
        mList.add("WATERMELON");
        mList.add("PAPAYA");
        mList.add("PINEAPPLE");



        return mList;
    }


}