package com.example.projectpraktikum.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectpraktikum.R;
import com.example.projectpraktikum.adapter.CountryDiscoverAdapter;
import com.example.projectpraktikum.model.country.CountryDiscoverHolidaysItem;
import com.example.projectpraktikum.presenter.MainPresenter;
import com.example.projectpraktikum.presenter.MainView;
import com.example.projectpraktikum.view.MainContact;
import com.example.projectpraktikum.view.viewmodel.CountryViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends Fragment implements MainView {

    private MainPresenter mainPresenter;
    private CountryDiscoverAdapter countryDiscoverAdapter;
    private RecyclerView rvCountryDiscover;
    CountryViewModel countryViewModel;
    private String api_key = "578ad9cd-abe0-4959-80c4-b12bfe639b87";
    private String country = "US";
    private String year = "2020";

    public CountryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        countryDiscoverAdapter = new CountryDiscoverAdapter(getContext());
        countryDiscoverAdapter.notifyDataSetChanged();

        rvCountryDiscover = view.findViewById(R.id.fragmentcountry_rv);
        rvCountryDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        countryViewModel.setCountryDiscover(api_key, country, year);
        countryViewModel.getCountryDiscover().observe(this, getCountryDiscover);

        rvCountryDiscover.setAdapter(countryDiscoverAdapter);
//            countryViewModel.getCountryDiscover().observe(this, new Observer<ArrayList<CountryDiscoverHolidaysItem>>() {
//                @Override
//                public void onChanged(final ArrayList<CountryDiscoverHolidaysItem> countryDiscoverHolidaysItems) {
//                    countryDiscoverAdapter = new CountryDiscoverAdapter(countryDiscoverHolidaysItems, getActivity());
//                    rvCountryDiscover.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//                    rvCountryDiscover.setAdapter(countryDiscoverAdapter);
//
//
//                }
//            });

    }

    private Observer<ArrayList<CountryDiscoverHolidaysItem>> getCountryDiscover = new Observer<ArrayList<CountryDiscoverHolidaysItem>>() {
        @Override
        public void onChanged(ArrayList<CountryDiscoverHolidaysItem> countryDiscoverHolidaysItems) {
            if (countryDiscoverHolidaysItems != null) {
                countryDiscoverAdapter.setData(countryDiscoverHolidaysItems);
            }
        }
    };

    @Override
    public void onSucces(ArrayList<CountryDiscoverHolidaysItem> holidaysItems) {

    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getContext(), failureMessage, Toast.LENGTH_SHORT).show();
    }
}
