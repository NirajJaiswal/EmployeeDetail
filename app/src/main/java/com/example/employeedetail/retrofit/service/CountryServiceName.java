package com.example.employeedetail.retrofit.service;

import com.example.employeedetail.retrofit.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryServiceName
{

    @GET("countries")
    Call<Info> getCountryName();
}
