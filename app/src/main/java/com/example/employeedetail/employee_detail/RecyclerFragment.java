package com.example.employeedetail.employee_detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.adapter.EmployeeAdapter;
import com.example.employeedetail.listner.DataSendEmployeeFragToActivity;
import com.example.employeedetail.listner.EmployeeData;
import com.example.employeedetail.model.EmployeeDetails;
import com.example.employeedetail.model.EmployeeResponse;
import com.example.employeedetail.utils.LoggerUtils;
import com.example.employeedetail.utils.Util;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

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

        List<EmployeeDetails> mList = new ArrayList<>();
        JSONObject jsonObject = readMockData();
        if (null != jsonObject) {
            mList=parseJsonObject(jsonObject);
        }
            return mList;

    }

    private List<EmployeeDetails> parseJsonObject(JSONObject jsonObject)
    {
        List<EmployeeDetails> mList= new ArrayList<>();
        try {
            Gson gson = new Gson();
            EmployeeResponse employeeResponse = gson.fromJson(String.valueOf(jsonObject), EmployeeResponse.class);
            mList=employeeResponse.getEmployeeDetails();
        } catch (Exception ex){
            LoggerUtils.exception(ex.getMessage());
        }
        return mList;
    }


    private JSONObject readMockData() {
        String announcementsFileData = Util.loadJSONContent(getActivity(), "employee.json");
        try {
            return new JSONObject(announcementsFileData);
        } catch (JSONException e) {
            LoggerUtils.exception("Invalid Json");
            LoggerUtils.exception(e.getMessage());
        }
        return null;
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


