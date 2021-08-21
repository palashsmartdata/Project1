package com.example.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.Databases.UserEntity;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    List<UserEntity> list;
    Context context;

    public RecyclerAdapter(List<UserEntity> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dataitems, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        UserEntity user = list.get(position);
        holder.tv1.setText(user.getUsername());
        holder.tv2.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv1, tv2;
        public RecyclerViewHolder(@NonNull View itemView) {

            super(itemView);

            img = itemView.findViewById(R.id.personimage);
           tv1 = itemView.findViewById(R.id.dataitemtextview1);
           tv2 = itemView.findViewById(R.id.dataitemtextView2);
        }
    }
}
