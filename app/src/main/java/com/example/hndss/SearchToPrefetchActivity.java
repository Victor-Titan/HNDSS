package com.example.hndss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SearchToPrefetchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_to_prefetch);
    }

    public void GoToEdit(View view) {
        Intent intent = new Intent(this, ReadingTableActivity.class);


        // put arguments here if needed
        Toast.makeText(this, "Editing UID last record", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
