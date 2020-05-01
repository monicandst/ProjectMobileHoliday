package com.example.projectpraktikum.presenter;

import com.example.projectpraktikum.model.country.CountryDiscoverHolidaysItem;

import java.util.ArrayList;

public interface MainView {
    void onSucces(ArrayList<CountryDiscoverHolidaysItem> holidaysItems);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
