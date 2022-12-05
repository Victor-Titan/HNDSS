package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hndss.ReadingTable.Reading;
import com.example.hndss.ReadingTable.ReadingClient;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ReadingTableActivity extends AppCompatActivity {
    private EditText ETuid,ETheight,ETweight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_table);
        ETuid = findViewById(R.id.reading_uid);
        ETheight = findViewById(R.id.reading_height);
        ETweight = findViewById(R.id.reading_weight);
    }

    public void Submit(View view) {
        Intent intent = new Intent(ReadingTableActivity.this,MainActivity.class);

        // all table queries here pls
        addReading();
        Toast.makeText(this,"Full Entry Submitted successfully",Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    private void addReading() {
        String uid = ETuid.getText().toString().trim();
        String height = ETheight.getText().toString().trim();
        String weight = ETweight.getText().toString().trim();
        class AddReading extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                Reading reading = new Reading(uid, timeStamp, height, weight);

                ReadingClient.getInstance(getApplicationContext())
                        .getReadingDatabase()
                        .readingDao()
                        .insert(reading);
                return null;
            }
        }

        AddReading ar = new AddReading();
        ar.execute();
    }
}