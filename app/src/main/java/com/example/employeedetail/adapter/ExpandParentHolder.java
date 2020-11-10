package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.employeedetail.R;

public class ExpandParentHolder  extends ParentViewHolder {
    public TextView mParentTextView;
    public ImageButton mParentButton;
    public ExpandParentHolder(View itemView) {
        super(itemView);
        mParentTextView=itemView.findViewById(R.id.tv_first);
        mParentButton=itemView.findViewById(R.id.button_first);
    }
}
