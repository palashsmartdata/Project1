package com.example.newproject.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newproject.Databases.UserDao;
import com.example.newproject.Databases.UserDatabase;
import com.example.newproject.Databases.UserEntity;
import com.example.newproject.R;

import java.util.ArrayList;
import java.util.List;


public class LoginFragment extends Fragment {


Button login ;
UserDatabase userDatabase;
List<UserEntity> list;
EditText email, password;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
String name = "android@gmail.com";
String Password = "Admin";
String Email, Pass;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        list = new ArrayList<>();
        email = view.findViewById(R.id.f1Email);
        password = view.findViewById(R.id.f1Password);
        login = view.findViewById(R.id.f1Button);

        userDatabase = UserDatabase.getUserDatabase(getContext());



            sharedPreferences = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
            editor =  sharedPreferences.edit();


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                     Email  =  email.getText().toString();
                     Pass = password.getText().toString();


                     if (Email.isEmpty() || Pass.isEmpty()){
                         Toast.makeText(getContext(), "Field cannot be Empty", Toast.LENGTH_SHORT).show();
                     }else{

                         new Thread(new Runnable() {
                             @Override
                             public void run() {

                                 UserEntity userEntity = userDatabase.Dao().loginUser(Email, Pass);

                                 if (userEntity.getEmail().equals(Email) &&  userEntity.getPassword().equals(Pass)){

                                  new Handler(Looper.getMainLooper()).post(new Runnable() {
                                      @Override
                                      public void run() {

                                            editor.putString("Logged_user", userEntity.getUsername());
                                            editor.putString("Looged_email", userEntity.getEmail());
                                            editor.apply();

                                            new Handler(Looper.myLooper()).post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(getContext(), "Logged in With : " + userEntity.getUsername(), Toast.LENGTH_SHORT).show();
                                                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout,  new HomeScreenLogin()).commit();
                                                }
                                            });
                                      }
                                  });

                                 }
                                 else{
                                 }

                             }
                         }).start();
                     }



                }
                

                
            });


        return view;
    }
}