package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.listner.CricketerData;
import com.example.employeedetail.model.CricketerDetails;

import java.util.List;

public class CricketAdapter extends RecyclerView.Adapter<CricketHolder> {
    private List<CricketerDetails> cricketerDetails;
    private Context mContext;
    private CricketerData cricketerData;

   public void setCricketerData(CricketerData cricketerData){
       this.cricketerData=cricketerData;
   }

    public CricketAdapter(List<CricketerDetails> cricketerDetails, Context mContext) {
        this.cricketerDetails = cricketerDetails;
        this.mContext = mContext;
        this.cricketerData = cricketerData;
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
}
