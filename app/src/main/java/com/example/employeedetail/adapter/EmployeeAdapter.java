package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.listner.EmployeeData;
import com.example.employeedetail.model.EmployeeDetails;

import java.util.List;

public class EmployeeAdapter  extends RecyclerView.Adapter<EmployeeHolder> {

    private List<EmployeeDetails> mList;
    private Context mContext;
    private EmployeeData employeeData;

    public void setEmployeeData(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    public EmployeeAdapter(List<EmployeeDetails> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.list_view_fragment,parent,false);
        return new EmployeeHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        holder.onDataSet(mList.get(position),employeeData);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
