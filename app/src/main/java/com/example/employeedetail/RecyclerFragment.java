package com.example.employeedetail;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.employeedetail.adapter.EmployeeAdapter;
import com.example.employeedetail.listner.DataSendEmployeeFragToActivity;
import com.example.employeedetail.listner.EmployeeData;
import com.example.employeedetail.model.EmployeeDetails;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private DataSendEmployeeFragToActivity dataSendEmployeeFragToActivity;
    private BottomSheetMedicine bottomSheetMedicine;
    private Boolean isListView;
    private  EmployeeAdapter employeeAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_recycler_fragment,container,false);
         isListView=true;
        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setValue();
    }

    private void setValue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        employeeAdapter=new EmployeeAdapter(loadDetails(),getActivity());
        recyclerView.setAdapter(employeeAdapter);
        employeeAdapter.setEmployeeData(new EmployeeData() {
            @Override
            public void onClick(EmployeeDetails employeeDetails) {
              //  Toast.makeText(getActivity(), employeeDetails.toString(), Toast.LENGTH_SHORT).show();
            dataSendEmployeeFragToActivity.getData(employeeDetails);
            }
        });
    }

    private List<EmployeeDetails> loadDetails() {

        List<EmployeeDetails> mList=new ArrayList<>();

       mList.add(new EmployeeDetails("Shreya","java",R.drawable.after,21));
        mList.add(new EmployeeDetails("Niraj","Android",R.drawable.archer,20));
        mList.add(new EmployeeDetails("Kumar","Dot Net",R.drawable.movie,19));
       mList.add(new EmployeeDetails("Kumari","HTML",R.drawable.baby,18));
        mList.add(new EmployeeDetails("Shree","Python",R.drawable.enormity,17));
       mList.add(new EmployeeDetails("Ram","Data Science",R.drawable.it,16));
       mList.add(new EmployeeDetails("Shyam","Machine Learning",R.drawable.joker,15));
      mList.add(new EmployeeDetails("Ekta","Deep Learning",R.drawable.pamhir,14));
        mList.add(new EmployeeDetails("Singh","Robotics",R.drawable.replicas,13));
       mList.add(new EmployeeDetails("Aniket","MySql",R.drawable.star,12));
        return mList;
    }

    private void initView() {

        recyclerView=view.findViewById(R.id.fragment_rv);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataSendEmployeeFragToActivity= (DataSendEmployeeFragToActivity) context;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:

                Toast.makeText(getActivity(),"Item 1 selected",Toast.LENGTH_SHORT).show();
                bottomSheetMedicine=new BottomSheetMedicine();
                bottomSheetMedicine.show(getFragmentManager(),"bottomSheet");
                return true;
            case R.id.item2:
                recyclerView.setLayoutManager(!isListView ? new LinearLayoutManager(getActivity()) : new GridLayoutManager(getActivity(), 2));
                employeeAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if(isListView)
        {
            menu.findItem(R.id.item2).setTitle("List View");
            isListView=false;
        }
        else
        {
            menu.findItem(R.id.item2).setTitle("Grid View");
            isListView=true;

        }
    }
}


