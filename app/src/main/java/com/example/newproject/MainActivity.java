package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.newproject.Fragments.LoginFragment;
import com.example.newproject.Fragments.RegisterFragment;
import com.example.newproject.Fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button loginbtn, signupbtn, userlistbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginbtn = findViewById(R.id.loginbtn);
        signupbtn = findViewById(R.id.Signup);
        userlistbtn = findViewById(R.id.Userlist);
        linearLayout = findViewById(R.id.mainlinearlayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout, new LoginFragment()).commit();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment = new LoginFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainlinearlayout, loginFragment);
                transaction.commit();

            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment registerFragment = new RegisterFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainlinearlayout, registerFragment);
                transaction.commit();


            }
        });

        userlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserListFragment userListFragment = new UserListFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainlinearlayout, userListFragment);
                transaction.commit();
            }
        });

    }


}