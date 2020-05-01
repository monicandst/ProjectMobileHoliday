package com.example.projectpraktikum.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DataHolidayDao {
    @Insert
    long insertData(DataHoliday dataHoliday);

    @Query("Select * from holiday_db")
    List<DataHoliday> getData();

    @Update
    int updateData(DataHoliday item);

    @Delete
    void deleteData(DataHoliday item);
}
