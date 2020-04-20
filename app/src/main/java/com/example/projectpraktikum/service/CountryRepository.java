package com.example.projectpraktikum.service;

import com.example.projectpraktikum.model.country.CountryDiscoverResponse;
import com.example.projectpraktikum.model.country.Holidays;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryRepository {
    @GET("v1/holidays?api_key=87e8bec6-2695-4f86-a88c-4bb24858d408&country=US&year=2020&month=12&day=25")
    Call<Holidays> getHolidays();
}
