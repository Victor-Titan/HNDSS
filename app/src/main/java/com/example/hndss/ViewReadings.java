package com.example.hndss;

import static java.lang.String.valueOf;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.hndss.PreFetchedTable.PreFetched;
import com.example.hndss.PreFetchedTable.PreFetchedClient;
import com.example.hndss.ReadingTable.Reading;
import com.example.hndss.ReadingTable.ReadingClient;

import java.util.List;

public class ViewReadings extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_readings);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("View Readings");
        Log.e("In VIEWREADINGS","Entered");
        recyclerView = findViewById(R.id.viewReadings);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getReadings();
    }

    private void getReadings() {
        class GetPrefetched extends AsyncTask<Void, Void, List<Reading>> {

            @Override
            protected List<Reading> doInBackground(Void... voids) {
                List<Reading> preFetcheds = ReadingClient.getInstance(getApplicationContext())
                        .getReadingDatabase()
                        .readingDao()
                        .getAll();
                Log.e("GETTING:",preFetcheds.toString());
                return preFetcheds;
            }

            // TODO set the ListView/RecyclerView here
            @Override
            protected void onPostExecute(List<Reading> preFetcheds) {
                Log.e("__________GETTING:",preFetcheds.toString());

                for(Reading pf : preFetcheds) {
                    Log.d("Editable", "UID is " + pf.getUid());
                }

                super.onPostExecute(preFetcheds);
                TaskViewAdapter taskViewAdapter = new TaskViewAdapter(ViewReadings.this,preFetcheds);
                Log.e("__________GETTING SIZE __________:",  valueOf(taskViewAdapter.getItemCount()));
                recyclerView.setAdapter(taskViewAdapter);
            }
        }

        GetPrefetched gp = new GetPrefetched();
        gp.execute();
    }
}