package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.model.Employee;
import com.example.employeedetail.listner.ListenData;
import com.example.employeedetail.R;

public class RecyclerHolder extends RecyclerView.ViewHolder {
    public TextView mEmpNameTextView;
    public TextView mEmpIdTextView;

    public RecyclerHolder(@NonNull View itemView) {
        super(itemView);

        mEmpNameTextView=itemView.findViewById(R.id.tv_name);
        mEmpIdTextView=itemView.findViewById(R.id.tv_eid);

    }
    public void onBindData(final ListenData listenData , final Employee employee){

    mEmpNameTextView.setText(employee.getEmpName());
        mEmpIdTextView.setText(String.valueOf(employee.getEmpId()));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenData.onClickCard(employee);
            }
        });
    }

}
