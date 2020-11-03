package com.example.employeedetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.adapter.StartRecyclerAdapter;
import com.example.employeedetail.addfrag.AddActivity;
import com.example.employeedetail.cricket.CricketActivity;
import com.example.employeedetail.employee_detail.MainActivity;
import com.example.employeedetail.fragcommunication.FragActivity;
import com.example.employeedetail.listner.ButtonListener;
import com.example.employeedetail.model.ButtonModel;
import com.example.employeedetail.navigation.NavigationActivity;
import com.example.employeedetail.popularmovie.view.PopularMovieActivity;
import com.example.employeedetail.retrofit.view.RetrofitMainScreenActivity;
import com.example.employeedetail.snackbar.SnackBarActivity;
import com.example.employeedetail.spinner.CustomSpinnerActivity;
import com.example.employeedetail.spinner.SpinnerActivity;
import com.example.employeedetail.tab.TabLayoutActivity;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StartFragment extends Fragment  {
    private RecyclerView recyclerView;
    private Boolean isListView;
    private StartRecyclerAdapter startRecyclerAdapter;
    private View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_start, container, false);
        isListView = false;
        initView();
        setValue();
        return view;
    }

    private void setValue() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        startRecyclerAdapter = new StartRecyclerAdapter(getContext(), loadData());
        startRecyclerAdapter.setListener(new ButtonListener() {
            @Override
            public void clickButton(int id) {


                Intent intent;
                switch (id) {
                    case 1:
                        intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), NavigationActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), AddActivity.class);
                        String name = "Shreya";
                        intent.putExtra("key_1", name);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getActivity(), FragActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getActivity(), TabLayoutActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getActivity(), SpinnerActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getActivity(), CustomSpinnerActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getActivity(), SnackBarActivity.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getActivity(), FloatingActionBarActivity.class);
                        startActivity(intent);
                        break;
          /*  case 10:
                intent = new Intent(StartFragment.this, NavigationDrawerActivity.class);
                startActivity(intent);
                break;*/
                    case 11:
                        intent = new Intent(getActivity(), CricketActivity.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(getActivity(), RetrofitMainScreenActivity.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(getActivity(), PopularMovieActivity.class);
                        startActivity(intent);
                        break;

                    default:

                }

            }
        });
        recyclerView.setAdapter(startRecyclerAdapter);
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.rv_button);

    }



    private List<ButtonModel> loadData() {
        List<ButtonModel> list = new ArrayList<>();
        list.add(new ButtonModel(1, "Recycler View"));
        list.add(new ButtonModel(2, "Fragment"));
        list.add(new ButtonModel(3, "Add Fragment"));
        list.add(new ButtonModel(4, "Fragment Communication"));
        list.add(new ButtonModel(5, "Tab Layout"));
        list.add(new ButtonModel(6, "Spinner"));
        list.add(new ButtonModel(7, "Custom Spinner"));
        list.add(new ButtonModel(8, "Snack Bar"));
        list.add(new ButtonModel(9, "Floating Action Bar"));
        // list.add(new ButtonModel(10, "Navigation Drawer"));
        list.add(new ButtonModel(11, "Cricket"));
        list.add(new ButtonModel(12, "Retrofit"));
        list.add(new ButtonModel(13, "PopularMovie"));

        return list;
    }





    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_start, menu);
        MenuItem searchItem = menu.findItem(R.id.search_menu);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                startRecyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        if (isListView) {
            menu.findItem(R.id.view_type).setTitle("List View");
            isListView = false;
        } else {
            menu.findItem(R.id.view_type).setTitle("Grid View");
            isListView = true;

        }
        super.onPrepareOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.view_type) {
            recyclerView.setLayoutManager(!isListView ? new LinearLayoutManager(getActivity()) : new GridLayoutManager(getActivity(), 3));
            startRecyclerAdapter.notifyDataSetChanged();
            return true;
        } else if (item.getItemId() == R.id.sign_out) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);

    }


    /* @Override
    public void onBackPressed() {


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    getActivity());

            // set title
            alertDialogBuilder.setTitle("Exit");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Do you really want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, close
                            // current activity
                            getActivity().finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            Toast.makeText(getContext(), "i wanna stay on this page", Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

    }*/




}