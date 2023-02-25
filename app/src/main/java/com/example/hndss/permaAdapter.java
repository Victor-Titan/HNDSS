package com.example.hndss;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hndss.PreFetchedTable.PreFetched;

import java.util.List;

class TasViewAdapter extends RecyclerView.Adapter<TasViewAdapter.TasViewHolder>
{
    private Context mCtx;
    private List<PreFetched> taskList;
    public TasViewAdapter(Context mCtx, List<PreFetched> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }
    @Override
    public TasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.permanent,
                parent, false);
        return new TasViewHolder(view);
    }
    @Override
    public void onBindViewHolder(TasViewHolder holder, int position) {
        PreFetched t = taskList.get(position);
        holder.textViewUIDS.setText("UID = "+t.getUid());
        holder.textViewName.setText("Name = "+t.getName());
        holder.textViewDOB.setText("DOB = "+t.getDob());
        holder.textViewUID.setText("Gender = "+t.getGender());
        holder.textViewLat.setText("Latitude = "+t.getLat());
        holder.textViewLong.setText("Longitude = "+t.getLng());
    }
    @Override
    public int getItemCount() {
        return taskList.size();
    }
    class TasViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        TextView textViewUID,
                textViewUIDS, textViewName, textViewDOB,textViewGender,textViewLat,textViewLong;
        CardView cardView;
        public TasViewHolder(View itemView) {
            super(itemView);

            textViewUID = itemView.findViewById(R.id.permagender);
            textViewUIDS = itemView.findViewById(R.id.permauid);
            textViewName = itemView.findViewById(R.id.permaname);
            textViewDOB = itemView.findViewById(R.id.permadob);
            textViewLong = itemView.findViewById(R.id.permalong);
            textViewLat = itemView.findViewById(R.id.permalat);
            cardView = itemView.findViewById(R.id.card);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            PreFetched task = taskList.get(getAdapterPosition());
            Intent intent = new Intent(mCtx, ViewReadings.class);
            intent.putExtra("task", task);
            mCtx.startActivity(intent);
        }
    }
}