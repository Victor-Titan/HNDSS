package com.example.hndss.ReadingTable;

import android.content.Context;
import androidx.room.Room;

public class ReadingClient {
    private Context mCtx;
    private static ReadingClient mInstance;

    private ReadingDatabase readingDatabase;

    private ReadingClient(Context mCtx) {
        this.mCtx = mCtx;

        readingDatabase = Room.databaseBuilder(mCtx, ReadingDatabase.class, "Reading").build();
    }

    public static synchronized ReadingClient getInstance(Context mCtx) {
        if(mInstance == null) {
            mInstance = new ReadingClient(mCtx);
        }
        return mInstance;
    }

    public ReadingDatabase getReadingDatabase() {
        return readingDatabase;
    }
}
