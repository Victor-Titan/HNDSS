package com.example.hndss.EditTables;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Edit.class}, version = 1)
public abstract class EditDatabase extends RoomDatabase{
    public abstract EditDao readingDao();
}
