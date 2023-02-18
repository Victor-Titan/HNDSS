package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void New_user(View view) {
        Intent intent = new Intent(MainActivity.this, NewUser.class);
        intent.putExtra("UID","");
        intent.putExtra("name","");
        intent.putExtra("dob","");
        intent.putExtra("lat","");
        intent.putExtra("long","");
        intent.putExtra("gender","");
        // Passing empty strings to avoid NULL errors
        startActivity(intent);
    }

    public void Edit_record(View view) {

        Intent intent = new Intent(MainActivity.this, SearchLastRecord.class);

        // Pre process not needed since new record here
        startActivity(intent);
    }

    public void View_Prefetched(View view) {
        Intent intent = new Intent(MainActivity.this, ViewUsers.class);

        startActivity(intent);
    }
    public void SearchRevisit(View view) {
        Intent intent = new Intent(MainActivity.this, SearchToRevisitActivity.class);

        startActivity(intent);
    }

    public void View_Readings(View view) {
        Intent intent = new Intent(MainActivity.this, ViewReadings.class);
        Log.e("In ONCLICK","Entered");
        startActivity(intent);
    }

    public void FetchfromMYSQL(View view) {
        Intent intent = new Intent(MainActivity.this, MYSQLFetch.class);
        startActivity(intent);
    }
}