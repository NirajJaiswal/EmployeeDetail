package com.example.employeedetail.expandableRecyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.employeedetail.R;
import com.example.employeedetail.adapter.ExpandAdapter;
import com.example.employeedetail.model.ExpandChild;
import com.example.employeedetail.model.ExpandCreator;
import com.example.employeedetail.model.ExpandParent;

import java.util.ArrayList;
import java.util.List;

public class ExpandableRecyclerViewActivity extends AppCompatActivity {
RecyclerView recyclerView;


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        ((ExpandAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_recycler_view);
        recyclerView=findViewById(R.id.recycler_view_expandable);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ExpandAdapter adapter=new ExpandAdapter(this,loadData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);



    }

    private List<ParentObject> loadData() {


        ExpandCreator expandCreator=ExpandCreator.get(this);
        List<ExpandParent> list=expandCreator.getAll();


        List<ParentObject> parentObjects=new ArrayList<>();
        for(ExpandParent parent:list){
            List<Object> childList=new ArrayList<>();
            childList.add(new ExpandChild("Add to contacts","Send Message"));
            parent.setChildObjectList(childList);
            parentObjects.add(parent);
        }
        return parentObjects;
    }
}