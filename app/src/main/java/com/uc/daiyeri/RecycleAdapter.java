package com.uc.daiyeri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{

    private Context context;
    private List<User> notesList;



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowlayout, parent, false);

        return new MyViewHolder(itemView);
    }

    public RecycleAdapter(Context context, List<User> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final User user = notesList.get(position);

        holder.tvTitle.setText(user.getTitle());
        holder.tvNote.setText(user.getNote());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, user.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvNote;


        public MyViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvNote = view.findViewById(R.id.note);
        }
    }
}
