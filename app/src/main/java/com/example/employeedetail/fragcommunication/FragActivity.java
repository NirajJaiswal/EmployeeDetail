package com.example.employeedetail.fragcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.employeedetail.R;

public class FragActivity extends AppCompatActivity implements FragmentA.FragAListener, FragmentB.FragBListener {
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        fragmentA=new FragmentA();
        fragmentB=new FragmentB();

        getSupportFragmentManager().beginTransaction().replace(R.id.container_a,fragmentA).
                replace(R.id.container_b,fragmentB).commit();
    }

    @Override
    public void inputA(CharSequence input) {
        fragmentB.updateEditText(input);
    }

    @Override
    public void inputB(CharSequence input2) {
fragmentA.updateEditText(input2);
    }
}