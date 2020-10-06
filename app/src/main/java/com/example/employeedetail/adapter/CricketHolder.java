package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.listner.CricketerData;
import com.example.employeedetail.model.CricketerDetails;

public class CricketHolder extends RecyclerView.ViewHolder {


    public ImageView mCricketerImageView;
    public TextView mCricketerNameTextView;
    public TextView mCricketerRoleTextView;


    public CricketHolder(@NonNull View itemView) {
        super(itemView);

        mCricketerImageView=itemView.findViewById(R.id.cricketer_image_view);
        mCricketerNameTextView=itemView.findViewById(R.id.tv_cricketer_name);
        mCricketerRoleTextView=itemView.findViewById(R.id.tv_cricketer_role);
    }

    public void onCricketerData(final CricketerDetails cricketerDetails, final CricketerData cricketerData){
        mCricketerImageView.setImageResource(cricketerDetails.getCricketerImage());
        mCricketerNameTextView.setText(cricketerDetails.getCricketerFullName());
        mCricketerRoleTextView.setText(cricketerDetails.getCricketerRole());
       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               cricketerData.onClick(cricketerDetails);
           }
       });

    }
}
