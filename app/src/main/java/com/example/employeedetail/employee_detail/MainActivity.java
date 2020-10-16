package com.example.employeedetail.employee_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.employeedetail.R;
import com.example.employeedetail.adapter.RecyclerAdapter;
import com.example.employeedetail.listner.ListenData;
import com.example.employeedetail.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListenData {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setValue();
    }

    private void setValue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(loadData(),this,this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initView() {
        recyclerView=findViewById(R.id.rv);

    }
    private List<Employee> loadData(){
        List<Employee>employeeList=new ArrayList<>();
        employeeList.add(new Employee("Niraj",1,"Software Developer","worst"));
        employeeList.add(new Employee("Shreya",12,"Developer","very good"));
        employeeList.add(new Employee("Ekta",123,"Dot net ","good"));
        employeeList.add(new Employee("Abhisek",1234,"machine learning","excellent"));
        employeeList.add(new Employee("Kumar",12345,"developer","good"));
        employeeList.add(new Employee("jaiswal",123456,"dev","good"));
        employeeList.add(new Employee("Singh",1234567,"devp","good"));
        employeeList.add(new Employee("Shree",12345678,"developer","good"));
        employeeList.add(new Employee("Kumari",123456789,"java","good"));
        employeeList.add(new Employee("Ram",1234567890,"html","good"));
        return employeeList;

    }


    @Override
    public void onClickCard(Employee employee) {
        if(employee!=null){
            Intent intent=new Intent(this, EmployeeDetailsActivity.class);
            intent.putExtra("details",employee);
            startActivity(intent);

        }

    }
}