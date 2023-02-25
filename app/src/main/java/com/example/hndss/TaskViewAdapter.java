package com.example.hndss;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hndss.ReadingTable.Reading;

import java.util.List;

public class TaskViewAdapter extends RecyclerView.Adapter<TaskViewAdapter.TasksViewHolder>
{
    private Context mCtx;
    private List<Reading> taskList;
    public TaskViewAdapter(Context mCtx, List<Reading> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }
    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.entry1,
                parent, false);
        return new TasksViewHolder(view);
    }
    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Reading t = taskList.get(position);
        holder.textViewTask.setText("UID = "+t.getUid());
        holder.textViewDesc.setText("TIMESTAMP = "+t.getTimestamp());
        holder.textViewFinishBy.setText("Height = "+t.getHeight());
        holder.textViewStatus.setText("Weight = "+t.getWeight());
    }
    @Override
    public int getItemCount() {
        return taskList.size();
    }
    class TasksViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;
        CardView cardView;
        public TasksViewHolder(View itemView) {
            super(itemView);
            textViewStatus = itemView.findViewById(R.id.useruid);
            textViewTask = itemView.findViewById(R.id.date);
            textViewDesc = itemView.findViewById(R.id.height);
            textViewFinishBy = itemView.findViewById(R.id.weight);
            cardView = itemView.findViewById(R.id.card);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Reading task = taskList.get(getAdapterPosition());
            Intent intent = new Intent(mCtx, ViewReadings.class);
            intent.putExtra("task", task);
            mCtx.startActivity(intent);
        }
    }
}