package com.example.hndss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SearchLastRecord extends AppCompatActivity {
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_to_prefetch);
        search = findViewById(R.id.search);
    }

    public void GoToEdit(View view) {
        if(search.getText().toString().isEmpty()){
            Toast.makeText(this, "Pls enter UID", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, ReadingTableActivity.class);
            intent.putExtra("UID",search.getText().toString());
            // Select * from Readings where TIMESTAMP is the least old and UID == search.getText()
            intent.putExtra("height","UID associated height");
            intent.putExtra("weight","UID associated weight");
            Toast.makeText(this, "Editing UID last record", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }
}
