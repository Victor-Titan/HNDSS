package com.example.hndss.ReadingTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.util.List;

@Dao
public interface ReadingDao {
    @Query("SELECT * FROM Reading")
    List<Reading> getAll();

    @RawQuery
    List<Reading> getUIDReading(SimpleSQLiteQuery query);

    @Insert
    void insertAll(Reading... readings);

    @Insert
    void insert(Reading reading);

    @Delete
    void delete(Reading reading);

}
