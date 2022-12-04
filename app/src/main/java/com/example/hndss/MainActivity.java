package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void New_user(View view) {
        Intent intent = new Intent(MainActivity.this,PrefetchedActivity.class);

        // Pre process not needed since new record here
        startActivity(intent);
    }

    public void Edit_record(View view) {

        Intent intent = new Intent(MainActivity.this, SearchToPrefetchActivity.class);

        // Pre process not needed since new record here
        startActivity(intent);
    }

    public void SearchRevisit(View view) {
        Intent intent = new Intent(MainActivity.this, SearchToRevisitActivity.class);

        startActivity(intent);
    }
}