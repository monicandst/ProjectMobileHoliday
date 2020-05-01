package com.example.projectpraktikum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpraktikum.R;
import com.example.projectpraktikum.entity.AppDatabase;
import com.example.projectpraktikum.entity.DataHoliday;
import com.example.projectpraktikum.view.MainContact;

import java.util.ArrayList;

public class FavoritAdapter extends RecyclerView.Adapter<FavoritAdapter.Holder> {

    private AppDatabase appDatabase;
    private Context context;
    private ArrayList<DataHoliday> list;
    private MainContact.hapus view;

    public FavoritAdapter(Context context, ArrayList<DataHoliday> list, MainContact.hapus view) {
        this.context = context;
        this.list = list;
        this.view = view;
    }

    @NonNull
    @Override
    public FavoritAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_favorit, viewGroup,false);
        Holder holder = new Holder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritAdapter.Holder holder, int i) {
        holder.bind(i);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView ivThumbFav, ivFavorit;
        TextView tvTitlefav;
        CardView cvItemFav;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tvTitlefav = itemView.findViewById(R.id.itemfavorit_tv_name);
            cvItemFav = itemView.findViewById(R.id.itemfavorit_cv);
            ivFavorit = itemView.findViewById(R.id.itemfavorit_star_favorit);
        }

        public void bind(int i){
            final DataHoliday dataHoliday = list.get(i);
            tvTitlefav.setText(dataHoliday.getNameHoliday());
            ivFavorit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appDatabase = AppDatabase.iniDb(context);

                    view.deleteData(dataHoliday);
                }
            });

        }
    }
}
