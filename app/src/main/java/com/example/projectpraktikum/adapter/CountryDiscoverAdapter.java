package com.example.projectpraktikum.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpraktikum.DBInternal.DBDataSource;
import com.example.projectpraktikum.R;
import com.example.projectpraktikum.model.country.CountryDiscoverHolidaysItem;
import com.example.projectpraktikum.view.activity.CountryDetailActivity;

import java.util.ArrayList;


public class CountryDiscoverAdapter extends RecyclerView.Adapter<CountryDiscoverAdapter.ViewHolder> {

    private ArrayList<CountryDiscoverHolidaysItem> countryDiscoverHolidaysItems = new ArrayList<>();
    private Context context;

    //DB internal
    private DBDataSource db;
    private boolean favorite;


//    private static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185/";

    public CountryDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<CountryDiscoverHolidaysItem> items) {
        countryDiscoverHolidaysItems.clear();
        countryDiscoverHolidaysItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);

//        //Set favorite dan Insert data dari API ke Sqlite database
//        db = new DBDataSource(ContentFavorito.this);
//        db.open();
//        //Cek fav
//        favorite = db.isFavorite(Integer.valueOf(idDB));



    }

    @Override
    public void onBindViewHolder(@NonNull CountryDiscoverAdapter.ViewHolder holder, final int position) {

        holder.tvTitle.setText(countryDiscoverHolidaysItems.get(position).getName());
        CardView cardView = holder.cvItem;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CountryDetailActivity.class);

                intent.putExtra("tvTitle", countryDiscoverHolidaysItems.get(position).getName());
                intent.putExtra("tvDate", countryDiscoverHolidaysItems.get(position).getDate());
                intent.putExtra("tvStart", countryDiscoverHolidaysItems.get(position).getStart());
                intent.putExtra("tvEnd", countryDiscoverHolidaysItems.get(position).getEnd());
                intent.putExtra("tvType", countryDiscoverHolidaysItems.get(position).getType());
                intent.putExtra("tvCountry", countryDiscoverHolidaysItems.get(position).getCountry());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return countryDiscoverHolidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb, ivStarFavorit;
        TextView tvTitle;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_name);
            ivStarFavorit = itemView.findViewById(R.id.itemlist_star_favorit);
        }
    }
}
