package com.example.employeedetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.employeedetail.adapter.EmployeeAdapter;
import com.example.employeedetail.model.EmployeeDetails;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_recycler_fragment,container,false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setValue();
    }

    private void setValue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EmployeeAdapter employeeAdapter=new EmployeeAdapter(loadDetails(),getActivity());
        recyclerView.setAdapter(employeeAdapter);

    }

    private List<EmployeeDetails> loadDetails() {

        List<EmployeeDetails> mList=new ArrayList<>();

       mList.add(new EmployeeDetails("Shreya","java",R.drawable.after));
        mList.add(new EmployeeDetails("Niraj","Android",R.drawable.archer));
        mList.add(new EmployeeDetails("Kumar","Dot Net",R.drawable.movie));
       mList.add(new EmployeeDetails("Kumari","HTML",R.drawable.baby));
        mList.add(new EmployeeDetails("Shree","Python",R.drawable.enormity));
       mList.add(new EmployeeDetails("Ram","Data Science",R.drawable.it));
       mList.add(new EmployeeDetails("Shyam","Machine Learning",R.drawable.joker));
      mList.add(new EmployeeDetails("Ekta","Deep Learning",R.drawable.pamhir));
        mList.add(new EmployeeDetails("Singh","Robotics",R.drawable.replicas));
       mList.add(new EmployeeDetails("Aniket","MySql",R.drawable.star));

        return mList;
    }

    private void initView() {

        recyclerView=view.findViewById(R.id.fragment_rv);
    }
}


