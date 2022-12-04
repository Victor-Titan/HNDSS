package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PrefetchedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefetched);
    }

    public void Prefetched(View view) {
        Intent intent = new Intent(PrefetchedActivity.this,ReadingTableActivity.class);


        // put arguments here if needed
        Toast.makeText(this,"Permanent Table Submitted successfully",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}