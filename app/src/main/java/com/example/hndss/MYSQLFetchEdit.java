package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hndss.PreFetchedTable.PreFetched;
import com.example.hndss.PreFetchedTable.PreFetchedClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MYSQLFetchEdit extends AppCompatActivity {

    EditText uid;
    Button fetch;
    ResultSet resultSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysqlfetchedit);

        uid = (EditText) findViewById(R.id.UIDMYSQL_edit);
        fetch = (Button) findViewById(R.id.mysql_fetch_edit);

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<Void, Void, Void> {
        String uid_val = uid.getText().toString();


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.42.124/android", "andro", "andro");
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM prefetched WHERE UID = ?");
                statement.setString(1, uid_val);
                resultSet = statement.executeQuery();
                resultSet.next();
                String uid = resultSet.getString(1);
                String name = resultSet.getString(2);
                String dob = resultSet.getString(3);
                String lat = resultSet.getString(4);
                String lng = resultSet.getString(5);
                String gender = resultSet.getString(6);

                PreFetchedClient.getInstance(getApplicationContext())
                        .getPreFetchedDatabase()
                        .preFetchedDao()
                        .insert(new PreFetched(uid, name, dob, lat, lng, gender));

                statement = connection.prepareStatement("DELETE FROM reading WHERE uid = ? ORDER BY timstp DESC LIMIT 1");
                statement.setString(1, uid_val);
                statement.executeUpdate();
            }
            catch (Exception e)
            {
//                Toast.makeText(MYSQLFetch.this, "Incorrect UID!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Toast.makeText(MYSQLFetchEdit.this, "Fetched Entry Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}