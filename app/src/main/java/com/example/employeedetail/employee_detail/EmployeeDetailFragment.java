package com.example.employeedetail.employee_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeedetail.R;
import com.example.employeedetail.model.EmployeeDetails;

public class EmployeeDetailFragment extends Fragment {
private View view;
private TextView mNameTextView,mDesignationTextView,mAgeTextView;
private ImageView mProfileImage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.employee_data,container,false);
        initView();
        if(getArguments()!=null)
        {
            EmployeeDetails employeeDetails= (EmployeeDetails) getArguments().getSerializable("data");
            if(employeeDetails!=null)
            {
                getEmployeeData(employeeDetails);
            }
            else
            {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
        return view;
    }

    private void initView() {
        mNameTextView=view.findViewById(R.id.tv_emp_name);
        mAgeTextView=view.findViewById(R.id.tv_emp_age);
        mDesignationTextView=view.findViewById(R.id.tv_emp_designation);
        mProfileImage=view.findViewById(R.id.iv_employee_image);
    }
    private void getEmployeeData(EmployeeDetails employeeDetails)
    {
        mProfileImage.setImageResource(employeeDetails.getProfile());
        mDesignationTextView.setText(employeeDetails.getDesignation());
        mAgeTextView.setText(String.valueOf(employeeDetails.getAge()));
        mNameTextView.setText(employeeDetails.getName());
    }

}
