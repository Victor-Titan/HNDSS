package com.example.hndss;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.sqlite.db.SimpleSQLiteQuery;

import com.example.hndss.ReadingTable.Reading;
import com.example.hndss.ReadingTable.ReadingClient;

import java.util.List;

public class SearchLastRecord extends AppCompatActivity {
    EditText search;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_to_prefetch);
        search = findViewById(R.id.search);
        btn = findViewById(R.id.go_to_edit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<Void, Void, Void> {
        String uid, timstp, height, weight;

        @Override
        protected Void doInBackground(Void... voids) {
            uid = search.getText().toString();
            SimpleSQLiteQuery query = new SimpleSQLiteQuery("SELECT * FROM Reading WHERE uid = ? ORDER BY timestamp DESC LIMIT 1", new Object[]{uid});
            List<Reading> readingList = ReadingClient.getInstance(getApplicationContext())
                    .getReadingDatabase()
                    .readingDao()
                    .getUIDReading(query);
            Log.e(String.valueOf(readingList.size()), "abc");
            Reading reading = readingList.get(0);
            timstp = reading.getTimestamp();
            height = reading.getHeight();
            weight = reading.getWeight();

            ReadingClient.getInstance(getApplicationContext())
                    .getReadingDatabase()
                    .readingDao()
                    .delete(reading);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Intent intent = new Intent(SearchLastRecord.this, ReadingTableActivity.class);
            intent.putExtra("UID", uid);
            intent.putExtra("height", height);
            intent.putExtra("weight", weight);
            Toast.makeText(SearchLastRecord.this, "Editing UID last record", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }
}
