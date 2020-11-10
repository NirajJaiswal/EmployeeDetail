package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.employeedetail.R;
import com.example.employeedetail.model.ExpandChild;
import com.example.employeedetail.model.ExpandParent;

import java.util.List;

public class ExpandAdapter extends ExpandableRecyclerAdapter<ExpandParentHolder,ExpandChildHolder>{


LayoutInflater inflater;

    public ExpandAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater=LayoutInflater.from(context);
    }

    @Override
    public ExpandParentHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.expandable_first,viewGroup,false);
        return new ExpandParentHolder(view);
    }

    @Override
    public ExpandChildHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.expandable_second,viewGroup,false);
        return new ExpandChildHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ExpandParentHolder expandParentHolder, int i, Object o) {
        ExpandParent parent=(ExpandParent)o;
        expandParentHolder.mParentTextView.setText(parent.getTitle());

    }

    @Override
    public void onBindChildViewHolder(ExpandChildHolder expandChildHolder, int i, Object o) {
        ExpandChild child=(ExpandChild)o;
        expandChildHolder.mOptionOne.setText(child.getOptionOne());
        expandChildHolder.mOptionTwo.setText(child.getOptionTwo());
    }
}
