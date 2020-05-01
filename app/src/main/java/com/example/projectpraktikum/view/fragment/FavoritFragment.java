package com.example.projectpraktikum.view.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectpraktikum.R;
import com.example.projectpraktikum.adapter.CountryDiscoverAdapter;
import com.example.projectpraktikum.adapter.FavoritAdapter;
import com.example.projectpraktikum.entity.AppDatabase;
import com.example.projectpraktikum.entity.DataHoliday;
import com.example.projectpraktikum.presenter.PresenterDAO;
import com.example.projectpraktikum.view.MainContact;
import com.example.projectpraktikum.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritFragment extends Fragment implements MainContact.hapus {

    private String api_key = "578ad9cd-abe0-4959-80c4-b12bfe639b87";
    private String country = "US";
    private String year = "2020";

    private RecyclerView A;
    private CountryDiscoverAdapter countryDiscoverAdapter;
    private AppDatabase appDatabase;
    private PresenterDAO presenterDAO;
    private FavoritAdapter favoritAdapter;
    Context context;

    public FavoritFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorit, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        A = view.findViewById(R.id.fragmentfavorit_rv);

        presenterDAO = new PresenterDAO(this);
        A.setLayoutManager(new LinearLayoutManager(context));
        appDatabase = AppDatabase.iniDb(getContext());
        readData(appDatabase);
    }
    public void readData(AppDatabase database){
        List list;
        list = database.dao().getData();
        favoritAdapter = new FavoritAdapter(context, (ArrayList<DataHoliday>) list, this);
        A.setAdapter(favoritAdapter);
    }

    @Override
    public void sukses() {
        Toast.makeText(getContext(),"unlike", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void deleteData(final DataHoliday item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Hapus Data")
                .setMessage("Ingin Hapus dari Favorit ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenterDAO.deleteData(appDatabase, item);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
