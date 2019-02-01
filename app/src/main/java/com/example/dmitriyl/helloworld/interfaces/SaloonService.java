package com.example.dmitriyl.helloworld.interfaces;

import com.example.dmitriyl.helloworld.models.Saloon;
import com.example.dmitriyl.helloworld.models.SaloonInfoResponce;
import com.example.dmitriyl.helloworld.models.SaloonsResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SaloonService
{
    @GET("/rest/v1/salon/getPopular")
    Call<SaloonsResponce> saloonList();

    @GET("/rest/v1/salon/page")
    Call<SaloonInfoResponce> getSaloon(@Query("id") Integer id);

    @GET("/rest/v1/salon/getRecommended")
    Call<SaloonsResponce> saloonListRecommended();

}
