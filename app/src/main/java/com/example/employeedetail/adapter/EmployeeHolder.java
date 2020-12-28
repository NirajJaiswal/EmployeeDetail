package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.listner.EmployeeData;
import com.example.employeedetail.model.EmployeeDetails;

public class EmployeeHolder extends RecyclerView.ViewHolder {
    public TextView mNameTextView;
    public TextView mDesignationTextView;


    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        mNameTextView = itemView.findViewById(R.id.tv_employee_name);
        mDesignationTextView = itemView.findViewById(R.id.tv_employee_post);
    }

    public void onDataSet(EmployeeDetails employeeDetails, EmployeeData employeeData) {
        mNameTextView.setText(employeeDetails.getName());
        mDesignationTextView.setText(employeeDetails.getDesignation());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeData.onClick(employeeDetails);

            }
        });
    }


}
