package com.example.hndss.ReadingTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.hndss.PreFetchedTable.PreFetched;

import java.io.Serializable;

@Entity(primaryKeys = {"uid", "timestamp"},
        foreignKeys = {@ForeignKey(entity = PreFetched.class,
        parentColumns = "uid",
        childColumns = "uid",
        onDelete = ForeignKey.CASCADE)
})
public class Reading implements Serializable {

    @ColumnInfo(name = "uid")
    @PrimaryKey
    private int uid;

    // get epochs and convert to String
    @ColumnInfo(name = "timestamp")
    @PrimaryKey
    private String timestamp;

    // in cm
    @ColumnInfo(name = "height")
    private int height;

    // in kgs
    @ColumnInfo(name = "weight")
    private int weight;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
