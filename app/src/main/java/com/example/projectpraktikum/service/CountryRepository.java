package com.example.projectpraktikum.service;

import com.example.projectpraktikum.model.country.CountryDiscoverResponse;
import com.example.projectpraktikum.model.country.Holidays;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CountryRepository {
    @GET("v1/holidays")
    Call<CountryDiscoverResponse> getHolidays(@Query("api_key") String api_key,
                                              @Query("country") String country,
                                              @Query("year") String year);
}
//87e8bec6-2695-4f86-a88c-4bb24858d408