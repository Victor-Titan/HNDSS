package com.example.hndss.PreFetchedTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PreFetchedDao {
    @Query("SELECT * FROM PreFetched")
    List<PreFetched> getAll();

    @Insert
    void insertAll(PreFetched... preFetcheds);

    @Delete
    void delete(PreFetched preFetched);
}