package com.example.newproject.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.newproject.R;


public class HomeScreenLogin extends Fragment {

        Button logout;
        SharedPreferences sh;
        SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_screen_login, container, false);



            logout = view.findViewById(R.id.Logout);
            sh = getContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
            editor = sh.edit();




        return  view;
    }
}