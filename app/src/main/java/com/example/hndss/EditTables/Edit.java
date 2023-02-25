package com.example.hndss.EditTables;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.io.Serializable;

@Entity(primaryKeys = {"uid", "timestamp"})
public class Edit implements Serializable {

    @ColumnInfo(name = "uid")
//    @PrimaryKey
    @NonNull
    private String uid;

    // get epochs and convert to String
    @ColumnInfo(name = "timestamp")
//    @PrimaryKey
    @NonNull
    private String timestamp;

    // in cm
    @ColumnInfo(name = "height")
    private String height;

    // in kgs
    @ColumnInfo(name = "weight")
    private String weight;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Edit(String uid, @NonNull String timestamp, String height, String weight) {
        this.uid = uid;
        this.timestamp = timestamp;
        this.height = height;
        this.weight = weight;
    }

}
