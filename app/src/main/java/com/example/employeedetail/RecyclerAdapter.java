package com.example.employeedetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private List<Employee>mList;
    private Context mContext;
    private ListenData listenData;

    public RecyclerAdapter(List<Employee> mList, Context mContext, ListenData listenData) {
        this.mList = mList;
        this.mContext = mContext;
        this.listenData=listenData;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.employee,parent,false);

        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        holder.onBindData(listenData,mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
