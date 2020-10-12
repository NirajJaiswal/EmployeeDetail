package com.example.employeedetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.adapter.CricketAdapter;
import com.example.employeedetail.listner.CricketerData;
import com.example.employeedetail.listner.DataSendCricketerFragToActivity;
import com.example.employeedetail.model.CricketerDetails;

import java.util.ArrayList;
import java.util.List;

public class CricketFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    private Boolean isListView;
    CricketAdapter cricketAdapter;
    private DataSendCricketerFragToActivity dataSendCricketerFragToActivity;
    List<CricketerDetails> cricketerDetails = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.cricket_fragment, container, false);
        isListView = true;

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setValue();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

    }

    private void setValue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cricketAdapter = new CricketAdapter(cricketerInfo(), getActivity());
        recyclerView.setAdapter(cricketAdapter);
        cricketAdapter.setCricketerData(new CricketerData() {
            @Override
            public void onClick(CricketerDetails cricketerDetails) {
                dataSendCricketerFragToActivity.getData(cricketerDetails);
            }
            });


    }

    private void initView() {
        recyclerView = view.findViewById(R.id.cricket_recycler_view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        dataSendCricketerFragToActivity= (DataSendCricketerFragToActivity) context;
        super.onAttach(context);
    }

    private List<CricketerDetails> cricketerInfo() {
        cricketerDetails.add(new CricketerDetails("Mahinder Singh Dhoni", "Batsman", R.drawable.dhoni, 39, "India"));
        cricketerDetails.add(new CricketerDetails("Ben Stokes", "All rounder", R.drawable.benstokes, 29, "England"));
        cricketerDetails.add(new CricketerDetails("Lasith Malinga", "Bowler", R.drawable.lasith, 37, "Sri Lanka"));
        cricketerDetails.add(new CricketerDetails("Shami", "Bowler", R.drawable.shami, 34, "India"));
        cricketerDetails.add(new CricketerDetails("Steve Smith", "Batsman", R.drawable.smith, 34, "Australia"));
        cricketerDetails.add(new CricketerDetails("Pat Cummins", "Bowler", R.drawable.patcummins, 34, "Australia"));
        cricketerDetails.add(new CricketerDetails("Shikhar Dhawan", "Batsman", R.drawable.shikhardhawan, 34, "India"));
        return cricketerDetails;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.cricket_menu_bar, menu);
        MenuItem menuItem=menu.findItem(R.id.search_cricket);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                cricketAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.cricket_item) {
            recyclerView.setLayoutManager(!isListView ? new LinearLayoutManager(getActivity()) : new GridLayoutManager(getActivity(), 2));
            cricketAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (isListView) {
            menu.findItem(R.id.cricket_item).setTitle("List view");
            isListView = false;
        } else {
            menu.findItem(R.id.cricket_item).setTitle("Grid View");
            isListView = true;
        }
    }
}



