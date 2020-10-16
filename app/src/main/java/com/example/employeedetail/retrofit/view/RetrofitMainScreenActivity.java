package com.example.employeedetail.retrofit.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.employeedetail.R;
import com.example.employeedetail.databinding.ActivityRetrofitMainScreenBinding;
import com.example.employeedetail.retrofit.adapter.CountryNameAdapter;
import com.example.employeedetail.retrofit.model.Info;
import com.example.employeedetail.retrofit.model.Result;
import com.example.employeedetail.retrofit.service.CountryServiceName;
import com.example.employeedetail.retrofit.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitMainScreenActivity extends AppCompatActivity {

    private List<Result> results;
    private ActivityRetrofitMainScreenBinding binding;
    private CountryNameAdapter countryNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_retrofit_main_screen);
        getCountry();
        List<Result> resultList=new ArrayList<>();
        countryNameAdapter=new CountryNameAdapter(resultList,getApplicationContext());
    }

    private void setRecyclerView() {

        binding.setAdapter(countryNameAdapter);
        countryNameAdapter.setResultList(results);

    }

    private List<Result> getCountry() {
        CountryServiceName countryServiceName = RetrofitInstance.getService();
        Call<Info> call = countryServiceName.getCountryName();
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Info info = response.body();
                if (info != null) {
                    results =  info.getResult();
                }

                for (Result result : results) {
                    Log.i("Test", result.getName());
                }
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

                Toast.makeText(RetrofitMainScreenActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });


        return results;
    }
}