package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.listner.EmployeeData;
import com.example.employeedetail.model.EmployeeDetails;

public class EmployeeHolder extends RecyclerView.ViewHolder {
    public TextView mNameTextView;
    public TextView mDesignationTextView;
    public ImageView mProfileImageView;


    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        mNameTextView=itemView.findViewById(R.id.tv_employee_name);
        mDesignationTextView=itemView.findViewById(R.id.tv_employee_post);
        mProfileImageView=itemView.findViewById(R.id.iv_employee);
    }
    public  void onDataSet(final EmployeeDetails employeeDetails, final EmployeeData employeeData)
    {
        mNameTextView.setText(employeeDetails.getName());
        mDesignationTextView.setText(employeeDetails.getDesignation());
        mProfileImageView.setImageResource(employeeDetails.getProfile());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeData.onClick(employeeDetails);

            }
        });
    }




}
