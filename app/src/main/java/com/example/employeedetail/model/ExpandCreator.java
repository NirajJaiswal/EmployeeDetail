package com.example.employeedetail.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ExpandCreator {
static ExpandCreator expandCreator;
List<ExpandParent> expandParents;

    public ExpandCreator(Context context) {
        expandParents=new ArrayList<>();
        for(int i=1;i<=100;i++){
            ExpandParent parent=new ExpandParent(String.format("Caller #%d",i));
            expandParents.add(parent);
        }
    }

    public static ExpandCreator get(Context context) {
    if(expandCreator==null)
        expandCreator=new ExpandCreator(context);
    return expandCreator;



}

    public List<ExpandParent> getAll() {
        return expandParents;
    }
}




