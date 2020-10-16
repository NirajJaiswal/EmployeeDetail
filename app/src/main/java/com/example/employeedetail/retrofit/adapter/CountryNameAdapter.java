package com.example.employeedetail.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.databinding.CountryItemListBinding;
import com.example.employeedetail.retrofit.model.Result;

import java.util.List;

public class CountryNameAdapter extends RecyclerView.Adapter<CountryNameAdapter.CountryNameViewHolder>
{
    private List<Result>resultList;
    private Context mContext;

    public CountryNameAdapter(List<Result> resultList, Context mContext) {
        this.resultList = resultList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CountryNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CountryItemListBinding binding= DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.country_item_list,
                parent,false);
        return new CountryNameViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryNameViewHolder holder, int position)
    {
        Result result=resultList.get(position);
        holder.bindData(result);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

     static class CountryNameViewHolder extends RecyclerView.ViewHolder
    {
        public CountryItemListBinding countryItemListBinding;

        public CountryNameViewHolder(CountryItemListBinding countryItemListBinding)
        {
            super(countryItemListBinding.getRoot());
            this.countryItemListBinding=countryItemListBinding;
        }

        public void bindData(Result result) {
            countryItemListBinding.setResult(result);
            countryItemListBinding.executePendingBindings();
        }
    }

    public void setResultList(List<Result>results)
    {
        this.resultList=results;
        notifyDataSetChanged();
    }
}
