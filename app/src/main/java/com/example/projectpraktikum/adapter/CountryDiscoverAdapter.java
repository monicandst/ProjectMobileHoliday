package com.example.projectpraktikum.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpraktikum.R;
import com.example.projectpraktikum.entity.AppDatabase;
import com.example.projectpraktikum.entity.DataHoliday;
import com.example.projectpraktikum.entity.DataHolidayDao;
import com.example.projectpraktikum.model.country.CountryDiscoverHolidaysItem;
import com.example.projectpraktikum.view.activity.CountryDetailActivity;

import java.util.ArrayList;


public class CountryDiscoverAdapter extends RecyclerView.Adapter<CountryDiscoverAdapter.ViewHolder> {

    private ArrayList<CountryDiscoverHolidaysItem> countryDiscoverHolidaysItems = new ArrayList<>();
    private Context context;
    AppDatabase appDatabase;



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
    public void onBindViewHolder(@NonNull CountryDiscoverAdapter.ViewHolder holder, final int i) {
        holder.tvTitle.setText(countryDiscoverHolidaysItems.get(i).getName());
        CardView cardView = holder.cvItem;
        ImageButton imageButton = holder.ivStarFavorit;



        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CountryDetailActivity.class);

                intent.putExtra("tvTitle", countryDiscoverHolidaysItems.get(i).getName());
                intent.putExtra("tvDate", countryDiscoverHolidaysItems.get(i).getDate());
                intent.putExtra("tvStart", countryDiscoverHolidaysItems.get(i).getStart());
                intent.putExtra("tvEnd", countryDiscoverHolidaysItems.get(i).getEnd());
                intent.putExtra("tvType", countryDiscoverHolidaysItems.get(i).getType());
                intent.putExtra("tvCountry", countryDiscoverHolidaysItems.get(i).getCountry());
                context.startActivity(intent);

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appDatabase = AppDatabase.iniDb(context);
                final DataHoliday dataHoliday = new DataHoliday();
                //   dataHoliday.setId(idHoliday);
                dataHoliday.setNameHoliday(countryDiscoverHolidaysItems.get(i).getName());
                dataHoliday.setDateHoliday(countryDiscoverHolidaysItems.get(i).getDate());
                dataHoliday.setStartHoliday(countryDiscoverHolidaysItems.get(i).getStart());
                dataHoliday.setEndHoliday(countryDiscoverHolidaysItems.get(i).getEnd());
                dataHoliday.setTypeHoliday(countryDiscoverHolidaysItems.get(i).getType());
                dataHoliday.setCountryHoliday(countryDiscoverHolidaysItems.get(i).getCountry());

                new InsertData(appDatabase,dataHoliday).execute();

            }
        });
    }



    @Override
    public int getItemCount() {
        return countryDiscoverHolidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView ivThumb;
         ImageButton ivStarFavorit;
         TextView tvTitle;
         CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_name);
            ivStarFavorit = itemView.findViewById(R.id.itemlist_star_favorit);

        }

    }
    class InsertData extends AsyncTask<Void, Void, Long>{
        private AppDatabase database;
        private  DataHoliday dataHoliday;


        public InsertData(AppDatabase database, DataHoliday dataHoliday) {
            this.database = database;
            this.dataHoliday = dataHoliday;

        }

        @Override
        protected Long doInBackground(Void... voids) {

            return database.dao().insertData(dataHoliday);
        }

        protected void onPostExecute(Long aLong){
            super.onPostExecute(aLong);
            Toast.makeText(context, "Favorit", Toast.LENGTH_SHORT).show();
        }
    }

}
