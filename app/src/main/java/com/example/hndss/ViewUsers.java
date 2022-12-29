package com.example.hndss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.hndss.PreFetchedTable.PreFetched;
import com.example.hndss.PreFetchedTable.PreFetchedClient;

import java.util.List;

public class ViewUsers extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prefetched);
        getPrefetched();
    }

    private void getPrefetched() {
        class GetPrefetched extends AsyncTask<Void, Void, List<PreFetched>> {

            @Override
            protected List<PreFetched> doInBackground(Void... voids) {
                List<PreFetched> preFetcheds = PreFetchedClient.getInstance(getApplicationContext())
                        .getPreFetchedDatabase()
                        .preFetchedDao()
                        .getAll();
                return preFetcheds;
            }

            // TODO set the ListView/RecyclerView here
            @Override
            protected void onPostExecute(List<PreFetched> preFetcheds) {
                for(PreFetched pf : preFetcheds) {
                    Log.d("Editable", "UID is " + pf.getUid());
                }
                super.onPostExecute(preFetcheds);
            }
        }

        GetPrefetched gp = new GetPrefetched();
        gp.execute();
    }
}