package com.example.hndss.PreFetchedTable;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PreFetched.class}, version = 1)
public abstract class PreFetchedDatabase extends RoomDatabase {
    public abstract PreFetchedDao preFetchedDao();
}
