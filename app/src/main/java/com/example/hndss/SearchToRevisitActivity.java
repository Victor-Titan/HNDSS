package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.sqlite.db.SimpleSQLiteQuery;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hndss.PreFetchedTable.PreFetched;
import com.example.hndss.PreFetchedTable.PreFetchedClient;

import java.util.List;

public class SearchToRevisitActivity extends AppCompatActivity {
    EditText UID;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_to_revisit);
        UID = findViewById(R.id.fetchRevist);
        btn = findViewById(R.id.go_to_revisit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UID.getText().toString().isEmpty()){
                    Toast.makeText(SearchToRevisitActivity.this, "Pls enter UID", Toast.LENGTH_SHORT).show();
                }
                else new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<Void, Void, Void> {
        String name, dob, lat, lng, gender;

        @Override
        protected Void doInBackground(Void... voids) {
            SimpleSQLiteQuery query = new SimpleSQLiteQuery("SELECT * FROM Prefetched WHERE UID = ?", new Object[]{UID.getText().toString()});
            List<PreFetched> preFetchedList = PreFetchedClient.getInstance(getApplicationContext())
                    .getPreFetchedDatabase()
                    .preFetchedDao()
                    .getUIDPrefetched(query);

            PreFetched preFetched = preFetchedList.get(0);
            name = preFetched.getName();
            dob = preFetched.getDob();
            lat = preFetched.getLat();
            lng = preFetched.getLng();
            gender = preFetched.getGender();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Intent intent = new Intent(SearchToRevisitActivity.this, NewUser.class);
            intent.putExtra("UID", UID.getText().toString());
            intent.putExtra("name", name);
            intent.putExtra("dob", dob);
            intent.putExtra("lat", lat);
            intent.putExtra("long", lng);
            intent.putExtra("gender", gender);
            startActivity(intent);
            finish();
        }
    }
}