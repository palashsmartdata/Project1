package com.example.newproject;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.Databases.UserDatabase;
import com.example.newproject.Databases.UserEntity;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    List<UserEntity> list;
    Context context;
    List<UserEntity> listTemp;
    int id;
    UserDatabase userDatabase;



    public RecyclerAdapter(List<UserEntity> list, Context context) {
        this.list = list;
        this.context = context;
        listTemp = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.dataitems, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {

        UserEntity user = list.get(position);
        holder.tv1.setText(user.getUsername());
        holder.tv2.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {
        ImageView img;
        TextView tv1, tv2;
        ImageButton deletebtn;


        public RecyclerViewHolder(@NonNull View itemView) {

            super(itemView);

            img = itemView.findViewById(R.id.personimage);
            tv1 = itemView.findViewById(R.id.dataitemtextview1);
            tv2 = itemView.findViewById(R.id.dataitemtextView2);

           deletebtn = itemView.findViewById(R.id.deleteButton);



           deletebtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   userDatabase = UserDatabase.getUserDatabase(itemView.getContext());

                   UserEntity  userEntity = listTemp.get(getAdapterPosition());
                   id = userEntity.getUid();


                   new Thread(new Runnable() {
                       @Override
                       public void run() {

                           UserEntity ue = userDatabase.Dao().getId(id);
                           userDatabase.Dao().deleteUser(ue);

                           new Handler(Looper.getMainLooper()).post(new Runnable() {
                               @Override
                               public void run() {

                                   Toast.makeText(context, "User Deleted Successfully", Toast.LENGTH_SHORT).show();
                               }
                           });
                       }
                   }).start();;
               }
           });



        }


        }
    }

