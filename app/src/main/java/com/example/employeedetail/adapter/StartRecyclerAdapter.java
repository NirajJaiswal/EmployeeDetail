package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.listner.ButtonListener;
import com.example.employeedetail.model.ButtonModel;
import com.example.employeedetail.R;

import java.util.List;

public class StartRecyclerAdapter extends RecyclerView.Adapter<StartRecyclerHolder> {
    private Context mContext;
    private List<ButtonModel>mList;
    private ButtonListener buttonListener;

    public StartRecyclerAdapter(Context mContext, List<ButtonModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
        this.buttonListener= (ButtonListener) mContext;
    }
    @NonNull
    @Override
    public StartRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.button_list,parent,false);
        return new StartRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StartRecyclerHolder holder, int position)
    {
        holder.onDataBind(mList.get(position),buttonListener);
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }
}
