package com.example.hndss.EditTables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.util.List;

@Dao
public interface EditDao {
    @Query("SELECT * FROM Edit")
    List<Edit> getAll();

    @RawQuery
    List<Edit> getUIDEdit(SimpleSQLiteQuery query);

    @Insert
    void insertAll(Edit... edits);

    @Insert
    void insert(Edit edit);

    @Delete
    void delete(Edit edit);

}
