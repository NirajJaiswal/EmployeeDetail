package com.example.employeedetail.multiple_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.employeedetail.R;
import com.example.employeedetail.adapter.MultipleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MultipleViewActivity extends AppCompatActivity {
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view);
        initView();
        setValue();



    }
    private void setValue() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MultipleViewActivity.this));
        MultipleViewAdapter multipleViewAdapter=new MultipleViewAdapter(this,loadData());
        recyclerView.setAdapter(multipleViewAdapter);


    }
    private List<Object>loadData()
    {
        List<Object> mList = new ArrayList<>();
        mList.add(new Movie(R.drawable.after, "After", 1));
        mList.add(new Scenery(R.drawable.download, R.drawable.downloadone, R.drawable.downloadtwo));
        mList.add(new Movie(R.drawable.archer, "Archer", 2));
        mList.add(new Scenery(R.drawable.downloadthree, R.drawable.downloadtwo, R.drawable.downloadone));
        mList.add(new Movie(R.drawable.baby, "baby", 3));
        mList.add(new Scenery(R.drawable.downloadone, R.drawable.downloadtwo, R.drawable.downloadthree));
        mList.add(new Movie(R.drawable.enormity, "Enormity", 4));
        return mList;

    }

    private void initView() {
        recyclerView=findViewById(R.id.multiple_view_recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Multiple View");

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}