package com.example.projectpraktikum.presenter;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.projectpraktikum.model.country.CountryDiscoverHolidaysItem;
import com.example.projectpraktikum.model.country.CountryDiscoverResponse;
import com.example.projectpraktikum.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<CountryDiscoverHolidaysItem>> listDiscoverCountry = new MutableLiveData<ArrayList<CountryDiscoverHolidaysItem>>();

    private Context context;
    private MainView mainView;

    public MainPresenter(Context context, MainView mainView){
        this.context = context;
        this.mainView = mainView;
    }
    public void loadInstitusi(String api_key, String country, String year){
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiCountry().getHolidays(api_key, country, year).enqueue(new Callback<CountryDiscoverResponse>() {
            @Override
            public void onResponse(Call<CountryDiscoverResponse> call, Response<CountryDiscoverResponse> response) {
                CountryDiscoverResponse holidays = response.body();
                if (holidays != null && holidays.getHolidays() != null) {
                    ArrayList<CountryDiscoverHolidaysItem> countryDiscoverHolidaysItems = holidays.getHolidays().getHolidays();
                    listDiscoverCountry.postValue(countryDiscoverHolidaysItems);
                }
                else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<CountryDiscoverResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });

    }
}
