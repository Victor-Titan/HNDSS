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

public class ViewUsers extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_prefetched);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("View Permanent Entries");
        Log.e("In VIEWPermanent","Entered");
        recyclerView = findViewById(R.id.viewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getReadings();
    }

    private void getReadings() {
        class GetPrefetched extends AsyncTask<Void, Void, List<PreFetched>> {

            @Override
            protected List<PreFetched> doInBackground(Void... voids) {
                List<PreFetched> preFetcheds = PreFetchedClient.getInstance(getApplicationContext())
                        .getPreFetchedDatabase()
                        .preFetchedDao()
                        .getAll();
                Log.e("GETTING:",preFetcheds.toString());
                return preFetcheds;
            }

            // TODO set the ListView/RecyclerView here
            @Override
            protected void onPostExecute(List<PreFetched> preFetcheds) {
                Log.e("__________GETTING:",preFetcheds.toString());

                for(PreFetched pf : preFetcheds) {
                    Log.d("Editable", "UID is " + pf.getUid());
                }

                super.onPostExecute(preFetcheds);
                TasViewAdapter taskViewAdapter = new TasViewAdapter(ViewUsers.this,preFetcheds);
                Log.e("__________GETTING SIZE __________:",  valueOf(taskViewAdapter.getItemCount()));
                recyclerView.setAdapter(taskViewAdapter);
            }
        }

        GetPrefetched gp = new GetPrefetched();
        gp.execute();
    }
}