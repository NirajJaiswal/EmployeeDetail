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
import com.example.employeedetail.listner.CricketerData;
import com.example.employeedetail.model.CricketerDetails;

import java.util.ArrayList;
import java.util.List;

public class CricketAdapter extends RecyclerView.Adapter<CricketHolder> implements Filterable {
    private List<CricketerDetails> cricketerDetails;
    private Context mContext;
    private CricketerData cricketerData;
    private List<CricketerDetails> fullCricketerDetails;

   public void setCricketerData(CricketerData cricketerData){
       this.cricketerData=cricketerData;
   }

    public CricketAdapter(List<CricketerDetails> cricketerDetails, Context mContext) {
        this.cricketerDetails = cricketerDetails;
        this.mContext = mContext;
        fullCricketerDetails=new ArrayList<>(cricketerDetails);
    }



    @NonNull
    @Override
    public CricketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.cricketer_list,parent,false);


        return new CricketHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketHolder holder, int position) {
        holder.onCricketerData(cricketerDetails.get(position), cricketerData);

    }

    @Override
    public int getItemCount() {
        return cricketerDetails.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    private Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint)
        {
            List<CricketerDetails>filterCricketerList=new ArrayList<>();
            if(constraint==null || constraint.length()==0)
            {
                filterCricketerList.addAll(fullCricketerDetails);
            }
            else
            {
                String filterItem=constraint.toString().toLowerCase().trim();
                for(CricketerDetails cricketerDetails:fullCricketerDetails)
                {
                    if(cricketerDetails.getCricketerFullName().toLowerCase().contains(filterItem)||cricketerDetails.getCricketerRole().toLowerCase().contains(filterItem))
                    {
                        filterCricketerList.add(cricketerDetails);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filterCricketerList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results)
        {
            cricketerDetails.clear();
            cricketerDetails.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
