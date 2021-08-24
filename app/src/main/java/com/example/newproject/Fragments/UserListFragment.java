package com.example.newproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.newproject.Databases.UserDao;
import com.example.newproject.Databases.UserDatabase;
import com.example.newproject.Databases.UserEntity;
import com.example.newproject.R;
import com.example.newproject.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;


public class UserListFragment extends Fragment {

    public UserListFragment()
    {
        //empty constructor
    }

    RecyclerView recyclerView;
    UserDatabase userDatabase;
    List<UserEntity> list;
    RecyclerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_user_list, container, false);

        recyclerView = view.findViewById(R.id.f3recyclerview);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()) );
        userDatabase = UserDatabase.getUserDatabase(getContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                list = userDatabase.Dao().getAllUserEntity();

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new RecyclerAdapter(list, getContext());
                        recyclerView.setAdapter(adapter);
                    }
                });



            }
        }).start();

        return view;


    }
}
