package com.example.hndss.PreFetchedTable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class PreFetched implements Serializable{

    @ColumnInfo(name = "uid")
    @NonNull
    @PrimaryKey
    private String uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "dob")
    private String dob;

    @ColumnInfo(name = "lat")
    private String lat;

    @ColumnInfo(name = "lng")
    private String lng;

    @ColumnInfo(name = "gender")
    private String gender;

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getGender() {
        return gender;
    }

    public PreFetched(String uid, String name, String dob, String lat, String lng, String gender) {
        this.uid = uid;
        this.name = name;
        this.dob = dob;
        this.lat = lat;
        this.lng = lng;
        this.gender = gender;
    }
}
