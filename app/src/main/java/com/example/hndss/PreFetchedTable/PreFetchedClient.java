package com.example.hndss.PreFetchedTable;

import android.content.Context;
import androidx.room.Room;

public class PreFetchedClient {
    private Context mCtx;
    private static PreFetchedClient mInstance;

    private PreFetchedDatabase preFetchedDatabase;

    private PreFetchedClient(Context mCtx) {
        this.mCtx = mCtx;

        preFetchedDatabase = Room.databaseBuilder(mCtx, PreFetchedDatabase.class, "PreFetched").build();
    }

    public static synchronized PreFetchedClient getInstance(Context mCtx) {
        if(mInstance == null) {
            mInstance = new PreFetchedClient(mCtx);
        }
        return mInstance;
    }

    public PreFetchedDatabase getPreFetchedDatabase() {
        return preFetchedDatabase;
    }
}
