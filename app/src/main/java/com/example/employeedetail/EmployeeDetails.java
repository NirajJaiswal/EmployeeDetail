package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EmployeeDetails extends AppCompatActivity {
    private TextView empNameTextView;
    private TextView empIdTextView;
    private TextView empPostTextView;
    private TextView empRevTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        Employee employee=(Employee) getIntent().getSerializableExtra("details");
        initView();
        setValue(employee);
    }

    private void setValue(Employee employee) {
        if(employee!=null){
            empNameTextView.setText(employee.getEmpName());
            empIdTextView.setText(String.valueOf(employee.getEmpId()));
            empPostTextView.setText(employee.getEmpPost());
            empRevTextView.setText(employee.getEmpRev());

        }

    }

    private void initView() {
        empNameTextView=findViewById(R.id.tv_name);
        empIdTextView=findViewById(R.id.tv_eid);
        empPostTextView=findViewById(R.id.tv_post);
        empRevTextView=findViewById(R.id.tv_review);
    }
}