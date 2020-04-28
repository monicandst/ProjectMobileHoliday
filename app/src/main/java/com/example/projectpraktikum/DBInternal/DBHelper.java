package com.example.projectpraktikum.DBInternal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "favorito";
    public static final String COLUMN_ID = "_idDB";
    public static final String COLUMN_NAME = "nameDB";
    public static final String COLUMN_DATE = "dateDB";
    public static final String COLUMN_START = "startDB";
    public static final String COLUMN_END = "endDB";
    public static final String COLUMN_TYPE = "typeDB";
    public static final String COLUMN_COUNTRY = "countryDB";

    private static final String db_name = "favorito.db";
    private static final int db_version = 1;
    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME + " varchar(50) not null, "
            + COLUMN_DATE + " varchar(50) not null, "
            + COLUMN_START + " varchar(50) not null, "
            + COLUMN_END + " varchar(50) not null, "
            + COLUMN_TYPE + " varchar(50) not null, "
            + COLUMN_COUNTRY + " varchar(50) not null);";

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
        // Auto generated
    }
    //mengeksekusi perintah SQL di atas untuk membuat tabel database baru
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }
    // dijalankan apabila ingin mengupgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(), "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
