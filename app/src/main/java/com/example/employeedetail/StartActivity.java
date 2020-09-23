package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.employeedetail.adapter.StartRecyclerAdapter;
import com.example.employeedetail.listner.ButtonListener;
import com.example.employeedetail.model.ButtonModel;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity  implements ButtonListener {
   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
        setValue();
    }
    private void setValue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StartRecyclerAdapter startRecyclerAdapter=new StartRecyclerAdapter(this,loadData());
        recyclerView.setAdapter(startRecyclerAdapter);
    }

    private void initView() {
        recyclerView=findViewById(R.id.rv_button);
    }
    private List<ButtonModel> loadData()
    {
        List<ButtonModel>list=new ArrayList<>();
        list.add(new ButtonModel(1,"Recycler View"));
        list.add(new ButtonModel(2,"Fragment"));
        return list;
    }

    @Override
    public void clickButton(int id) {
        Intent intent;
        switch (id)
        {
            case 1:

                 intent=new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case 2:
                 intent=new Intent(StartActivity.this,NavigationActivity.class);
                 startActivity(intent);
                 break;
            default:

        }

    }
}