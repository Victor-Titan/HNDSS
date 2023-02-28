package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.sqlite.db.SimpleSQLiteQuery;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hndss.PreFetchedTable.PreFetched;
import com.example.hndss.PreFetchedTable.PreFetchedClient;
import com.example.hndss.PreFetchedTable.PreFetchedDatabase;
import com.example.hndss.ReadingTable.Reading;
import com.example.hndss.ReadingTable.ReadingClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.final_submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            List<PreFetched> preFetchedList = PreFetchedClient.getInstance(getApplicationContext())
                    .getPreFetchedDatabase()
                    .preFetchedDao()
                    .getAll();

            List<Reading> readingList = ReadingClient.getInstance(getApplicationContext())
                    .getReadingDatabase()
                    .readingDao()
                    .getAll();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.42.124/android", "andro", "andro");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO prefetched VALUES(?, ?, ?, ?, ?, ?)");
                PreparedStatement statement1 = connection.prepareStatement("DELETE FROM prefetched WHERE UID = ?");
                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO reading VALUES(?, ?, ?, ?)");

                for (PreFetched pref : preFetchedList) {
                    statement1.setString(1, pref.getUid());
                    statement1.executeUpdate();

                    statement.setString(1, pref.getUid());
                    statement.setString(2, pref.getName());
                    statement.setString(3, pref.getDob());
                    statement.setString(4, pref.getLat());
                    statement.setString(5, pref.getLng());
                    statement.setString(6, pref.getGender());
                    statement.executeUpdate();

                    PreFetchedClient.getInstance(getApplicationContext())
                            .getPreFetchedDatabase()
                            .preFetchedDao()
                            .delete(pref);
                }

                for (Reading reading : readingList) {
                    statement2.setString(1, reading.getUid());
                    statement2.setString(2, reading.getTimestamp());
                    statement2.setString(3, reading.getWeight());
                    statement2.setString(4, reading.getHeight());
                    statement2.executeUpdate();

                    ReadingClient.getInstance(getApplicationContext())
                            .getReadingDatabase()
                            .readingDao()
                            .delete(reading);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Toast.makeText(MainActivity.this, "Submitted Successfully!", Toast.LENGTH_SHORT).show();
        }
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