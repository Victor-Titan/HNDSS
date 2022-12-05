package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hndss.PreFetchedTable.PreFetched;
import com.example.hndss.PreFetchedTable.PreFetchedClient;


public class PrefetchedActivity extends AppCompatActivity {

    private EditText ETuid, ETname, ETdob, ETlat, ETlng, ETgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefetched);

        ETuid = findViewById(R.id.uid);
        ETname = findViewById(R.id.name);
        ETdob = findViewById(R.id.dob);
        ETlat = findViewById(R.id.lat);
        ETlng = findViewById(R.id.lng);
        ETgender = findViewById(R.id.gender);

    }

    public void PrefetchedOnClick(View view) {
        Intent intent = new Intent(PrefetchedActivity.this, MainActivity.class);
        addUser();


        // put arguments here if needed
        Toast.makeText(this,"Permanent Table Submitted successfully",Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    private void addUser() {
        final String uid = ETuid.getText().toString();
        final String name = ETname.getText().toString();
        final String dob = ETdob.getText().toString();
        final String lat = ETlat.getText().toString();
        final String lng = ETlng.getText().toString();
        final String gender = ETgender.getText().toString();


        class AddUser extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                PreFetched preFetched = new PreFetched(uid, name, dob, lat, lng, gender);

                PreFetchedClient.getInstance(getApplicationContext()).getPreFetchedDatabase()
                        .preFetchedDao()
                        .insert(preFetched);
                return null;
            }
        }
        AddUser au = new AddUser();
        au.execute();
    }
}