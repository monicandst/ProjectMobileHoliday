package com.example.projectpraktikum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectpraktikum.R;
import com.example.projectpraktikum.model.country.CountryDiscoverHolidaysItem;

import java.util.ArrayList;


public class CountryDiscoverAdapter extends RecyclerView.Adapter<CountryDiscoverAdapter.ViewHolder> {

    private ArrayList<CountryDiscoverHolidaysItem> countryDiscoverHolidaysItems = new ArrayList<>();
    private Context context;


    private static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185/";

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
    }

    @Override
    public void onBindViewHolder(@NonNull CountryDiscoverAdapter.ViewHolder holder, int position) {

        holder.tvTitle.setText(countryDiscoverHolidaysItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countryDiscoverHolidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        TextView tvTitle;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_name);
        }
    }
}
