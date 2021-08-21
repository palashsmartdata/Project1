package com.example.newproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.newproject.Databases.UserDatabase;
import com.example.newproject.Databases.UserEntity;
import com.example.newproject.R;

import java.util.ArrayList;
import java.util.List;


public class LoginFragment extends Fragment {


Button login ;
UserDatabase userDatabase;
List<UserEntity> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);


        return view;
    }
}