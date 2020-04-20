package com.example.projectpraktikum.view.viewmodel;

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

    public void setCountryDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }



    }

}
