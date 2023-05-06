package com.example.projectphase1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    String data[];
    String data2[];
    Context context;

    public RecycleAdapter(Context context,String[] data,String data2[]) {
        this.data = data;
        this.context = context;
        this.data2 = data2;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
holder.Title.setText(data[position]);
        holder.EventName.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
TextView Title,EventName,Event;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            EventName=itemView.findViewById(R.id.EventName);
            Event=itemView.findViewById(R.id.EventText);
            Title=itemView.findViewById(R.id.Title);
        }
    }
}
