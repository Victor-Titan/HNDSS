package com.example.hndss.EditTables;


import android.content.Context;
import androidx.room.Room;

import com.example.hndss.ReadingTable.ReadingDatabase;

public class EditClient {
    private Context mCtx;
    private static com.example.hndss.EditTables.EditClient mInstance;

    private EditDatabase editDatabase;

    private EditClient(Context mCtx) {
        this.mCtx = mCtx;

        editDatabase = Room.databaseBuilder(mCtx, EditDatabase.class, "Edit").build();
    }

    public static synchronized com.example.hndss.EditTables.EditClient getInstance(Context mCtx) {
        if(mInstance == null) {
            mInstance = new com.example.hndss.EditTables.EditClient(mCtx);
        }
        return mInstance;
    }

    public EditDatabase getEditDatabase() {
        return editDatabase;
    }
}