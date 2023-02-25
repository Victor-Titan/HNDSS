package com.example.hndss.EditTables;

import android.content.Context;
import androidx.room.Room;

import com.example.hndss.EditTables.EditDatabase;

public class EditClient {
    private Context mCtx;
    private static EditClient mInstance;

    private EditDatabase readingDatabase;

    private EditClient(Context mCtx) {
        this.mCtx = mCtx;

        readingDatabase = Room.databaseBuilder(mCtx, EditDatabase.class, "Reading").build();
    }

    public static synchronized EditClient getInstance(Context mCtx) {
        if(mInstance == null) {
            mInstance = new EditClient(mCtx);
        }
        return mInstance;
    }

    public EditDatabase getReadingDatabase() {
        return readingDatabase;
    }
}
