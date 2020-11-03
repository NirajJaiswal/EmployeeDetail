package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.listner.ButtonListener;
import com.example.employeedetail.model.ButtonModel;

import java.util.ArrayList;
import java.util.List;

public class StartRecyclerAdapter extends RecyclerView.Adapter<StartRecyclerHolder> implements Filterable {
    private Context mContext;
    private List<ButtonModel>mList;
    private ButtonListener buttonListener;
    private List<ButtonModel>buttonModelList;

    public StartRecyclerAdapter(Context mContext, List<ButtonModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
        buttonModelList=new ArrayList<>(mList);
    }

    public void setListener(ButtonListener listener)
    {
     this.buttonListener=listener;
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

    @Override
    public Filter getFilter() {
        return filter;
    }
    private Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ButtonModel>filterList=new ArrayList<>();
            if(constraint ==null || constraint.length()==0)
            {
                filterList.addAll(buttonModelList);
            }
            else
            {
                String filterPattern=constraint.toString().toLowerCase().trim();
                for (ButtonModel buttonModel:buttonModelList)
                {
                    if(buttonModel.getButtonName().toLowerCase().contains(filterPattern))
                    {
                        filterList.add(buttonModel);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mList.clear();
            mList.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };
}
