package com.example.projectpraktikum.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectpraktikum.model.country.CountryDiscoverHolidaysItem;
import com.example.projectpraktikum.model.country.CountryDiscoverResponse;
import com.example.projectpraktikum.model.country.Holidays;
import com.example.projectpraktikum.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<Holidays>> listDiscoverCountry = new MutableLiveData<>();

    public void setCountryDiscover() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiCountry().getHolidays().enqueue(new Callback<Holidays>() {
            @Override
            public void onResponse(Call<Holidays> call, Response<Holidays> response) {
                Holidays holidays = response.body();
                if (holidays != null && holidays.getHolidays() != null) {
                    ArrayList<CountryDiscoverHolidaysItem> countryDiscoverHolidaysItems = holidays.getHolidays();
                    listDiscoverCountry.postValue(countryDiscoverHolidaysItems);

                }
            }

            @Override
            public void onFailure(Call<Holidays> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<CountryDiscoverHolidaysItem>> getCountryDiscover(){
        return listDiscoverCountry;
    }

}
