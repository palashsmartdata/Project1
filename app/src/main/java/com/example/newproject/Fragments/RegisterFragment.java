package com.example.newproject.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newproject.Databases.UserDatabase;
import com.example.newproject.Databases.UserEntity;
import com.example.newproject.R;


public class RegisterFragment extends Fragment {

    EditText username, email, password, confirmpassword;
    Button registerbtn;
    UserDatabase userDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        username = view.findViewById(R.id.f2Username);
        email = view.findViewById(R.id.f2Email);
        password = view.findViewById(R.id.f2Password);
        confirmpassword = view.findViewById(R.id.f2ConfirmPassword);
        registerbtn = view.findViewById(R.id.f2Register);


        userDatabase = UserDatabase.getUserDatabase(getContext());
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        UserEntity userEntity = new UserEntity();


                        userEntity.setUsername(username.getText().toString());
                        userEntity.setEmail(email.getText().toString());
                        userEntity.setPassword(password.getText().toString());
                        userEntity.setConfirmpassword(confirmpassword.getText().toString());

                        userDatabase.Dao().registerUser(userEntity);

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                if (userEntity.getUsername().isEmpty() ||
                                        userEntity.getEmail().isEmpty() ||
                                        userEntity.getPassword().isEmpty() ||
                                        userEntity.getConfirmpassword().isEmpty()){

                                    Toast.makeText(getContext(), "All Fields Mandotary", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });



                    }


                }).start();


            }


        });


        return view;
    }
}

