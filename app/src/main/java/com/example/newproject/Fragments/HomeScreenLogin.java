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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newproject.Databases.UserDatabase;
import com.example.newproject.Databases.UserEntity;
import com.example.newproject.R;


public class HomeScreenLogin extends Fragment {

    Button logout;
    TextView homescreentextview;
    ImageView homescreenimg1;
    SharedPreferences sh;
    SharedPreferences.Editor editor;
    String name, email;
    UserDatabase userDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_screen_login, container, false);


        homescreentextview = view.findViewById(R.id.HomeScreenTextView);
        homescreenimg1 = view.findViewById(R.id.imageView2);

        logout = view.findViewById(R.id.Logout);
        sh = getContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sh.edit();
        userDatabase = UserDatabase.getUserDatabase(getContext());


        name = sh.getString("Logged_user", null);

        homescreentextview.setText(name);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.clear();
                editor.apply();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout, new LoginFragment()).commit();
            }
        });


        return view;
    }
}