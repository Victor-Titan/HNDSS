package com.example.hndss.ReadingTable;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Reading.class}, version = 1)
public abstract class ReadingDatabase extends RoomDatabase{
    public abstract ReadingDao readingDao();
}
