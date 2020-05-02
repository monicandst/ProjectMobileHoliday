package com.example.projectpraktikum.service;

import com.example.projectpraktikum.model.country.CountryDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CountryRepository {
    @GET("v1/holidays")
    Call<CountryDiscoverResponse> getHolidays(@Query("api_key") String api_key,
                                              @Query("country") String country,
                                              @Query("year") String year);
}
