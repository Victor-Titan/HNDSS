package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchToRevisitActivity extends AppCompatActivity {
    EditText UID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_to_revisit);
        UID = findViewById(R.id.fetchRevist);
    }


    public void GoToRevisit(View view) {

        if(UID.getText().toString().isEmpty()){
            Toast.makeText(this, "Pls enter UID", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, NewUser.class);
            intent.putExtra("UID",UID.getText().toString());
            // prefetch from room database and put the corresponding accordingly
            // select * from permanent table where UID == UID.getText().toString()....
            intent.putExtra("name","UID associated Name");
            intent.putExtra("dob","UID associated DOB");
            intent.putExtra("lat","UID associated Lat");
            intent.putExtra("long","UID associated Long");
            intent.putExtra("gender","UID associated Gender");
            startActivity(intent);
            finish();
        }

    }
}