package com.example.projectpraktikum.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.example.projectpraktikum.entity.AppDatabase;
import com.example.projectpraktikum.entity.DataHoliday;
import com.example.projectpraktikum.view.MainContact;

public class PresenterDAO implements MainContact.datapresenter {
    MainContact.view view;
    MainContact.hapus viewH;

    public PresenterDAO(MainContact.view view) {
        this.view = view;
    }

    public PresenterDAO(MainContact.hapus viewH) {
        this.viewH = viewH;
    }

    
    @Override
    public void deleteData(AppDatabase database, DataHoliday dataHoliday) {
        new DeleteData(database, dataHoliday).execute();
    }
    
    class DeleteData extends AsyncTask<Void, Void, Void> {
        private AppDatabase database;
        private DataHoliday dataHoliday;
        Context context;
        public DeleteData(AppDatabase database, DataHoliday dataHoliday){
            this.database = database;
            this.dataHoliday = dataHoliday;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataHoliday);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewH.sukses();
        }
    }
}
