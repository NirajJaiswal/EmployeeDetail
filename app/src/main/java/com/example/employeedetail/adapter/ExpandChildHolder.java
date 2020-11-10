package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.employeedetail.R;

public class ExpandChildHolder extends ChildViewHolder {
    public TextView mOptionOne,mOptionTwo;
    public ExpandChildHolder(View itemView) {
        super(itemView);
        mOptionOne=itemView.findViewById(R.id.option_one);
        mOptionTwo=itemView.findViewById(R.id.option_two);
    }
}
