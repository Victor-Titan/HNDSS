package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReadingTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_table);
    }

    public void Submit(View view) {
        Intent intent = new Intent(ReadingTableActivity.this,MainActivity.class);

        // all table queries here pls
        Toast.makeText(this,"Full Entry Submitted successfully",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}