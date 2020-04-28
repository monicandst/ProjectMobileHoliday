package com.example.projectpraktikum.DBInternal;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = {
            DBHelper.COLUMN_ID,
            DBHelper.COLUMN_NAME,
            DBHelper.COLUMN_DATE,
            DBHelper.COLUMN_START,
            DBHelper.COLUMN_END,
            DBHelper.COLUMN_TYPE,
            DBHelper.COLUMN_COUNTRY};

    public DBDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Insert data
    public boolean insertFavoritoFavorito(String idDB,
                                          String nameDB,
                                          String dateDB,
                                          String startDB,
                                          String endDB,
                                          String typeDB,
                                          String countryDB) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_ID, idDB);
        values.put(DBHelper.COLUMN_NAME, nameDB);
        values.put(DBHelper.COLUMN_DATE, dateDB);
        values.put(DBHelper.COLUMN_START, startDB);
        values.put(DBHelper.COLUMN_END, endDB);
        values.put(DBHelper.COLUMN_TYPE, typeDB);
        values.put(DBHelper.COLUMN_COUNTRY, countryDB);

        long insertId = database.insert(DBHelper.TABLE_NAME,null,values);

        if (insertId == -1 )return false;
        else return true;
    }

    //set Data
    private  FavoritoFavorito cursorToFavoritoFavorito(Cursor cursor){
        FavoritoFavorito favoritoFavorito = new FavoritoFavorito();
        //debug LOGCAT
        favoritoFavorito.setIdDB(cursor.getInt(0));
        favoritoFavorito.setNameDB(cursor.getString(1));
        favoritoFavorito.setDateDB(cursor.getString(2));
        favoritoFavorito.setStartDB(cursor.getString(3));
        favoritoFavorito.setEndDB(cursor.getString(4));
        favoritoFavorito.setTypeDB(cursor.getString(5));
        favoritoFavorito.setCountryDB(cursor.getString(6));

        return favoritoFavorito;
    }

    //mengambil semua data FavoritoFavorito
    public  ArrayList<FavoritoFavorito> getFavoritoFavorito(){
        ArrayList<FavoritoFavorito> daftarfavoritoFavorito = new ArrayList<FavoritoFavorito>();

        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, null, null, null, null, null, null);
        // pindah ke data paling pertama
        cursor.moveToFirst();
        // jika masih ada data, masukkan data barang ke
        // daftar barang
        while (!cursor.isAfterLast()) {
            FavoritoFavorito favoritoFavorito = cursorToFavoritoFavorito(cursor);
            daftarfavoritoFavorito.add(favoritoFavorito);
            cursor.moveToNext();
        }
        cursor.close();
        return daftarfavoritoFavorito;
    }

    //ambil satu barang sesuai id
    public boolean isFavorite(Integer id)
    {
        FavoritoFavorito favorito = new FavoritoFavorito();
        //select query
        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, "_id ="+id,null, null, null, null, null);
        if (cursor.getCount()>0) return true;
        else return false;
    }

    //update studio yang diedit
    public void updateFavoritoFavorito(FavoritoFavorito b)
    {
        //ambil id barang
        String strFilter = "_id=" + b.getIdDB();
        //memasukkan ke content values
        ContentValues args = new ContentValues();
        //masukkan data sesuai dengan kolom pada database
        args.put(DBHelper.COLUMN_NAME, b.getNameDB());
        args.put(DBHelper.COLUMN_DATE, b.getDateDB());
        args.put(DBHelper.COLUMN_START, b.getStartDB());
        args.put(DBHelper.COLUMN_END, b.getEndDB());
        args.put(DBHelper.COLUMN_TYPE, b.getTypeDB());
        args.put(DBHelper.COLUMN_COUNTRY, b.getCountryDB());

        //update query
        database.update(DBHelper.TABLE_NAME, args, strFilter, null);
    }

    // delete studio sesuai ID
    public void deleteStudioMusik(Integer id)
    {
        String strFilter = "_id=" + id;
        database.delete(DBHelper.TABLE_NAME, strFilter, null);
    }

}

