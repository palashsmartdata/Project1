package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.newproject.Fragments.LoginFragment;
import com.example.newproject.Fragments.RegisterFragment;
import com.example.newproject.Fragments.RetroFragment;
import com.example.newproject.Fragments.UserListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
   BottomNavigationView bnv; /*loginbtn, signupbtn, userlistbtn, retrobtn;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout, new LoginFragment()).commit();


        bnv = findViewById(R.id.bottomNavigation);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp = null;
                switch (item.getItemId())
                {
                    case R.id.loginbtn: temp = new LoginFragment();
                    break;
                    case R.id.Signup: temp = new RegisterFragment();
                    break;
                    case R.id.Userlist: temp = new UserListFragment();
                    break;
                    case R.id.Retrobtn: temp = new RetroFragment();
                    break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout, temp).commit();
                return true;
            }
        });
        /*loginbtn = findViewById(R.id.loginbtn);
        signupbtn = findViewById(R.id.Signup);
        userlistbtn = findViewById(R.id.Userlist);
        linearLayout = findViewById(R.id.mainlinearlayout);
        retrobtn = findViewById(R.id.Retrobtn);*/


        getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout, new LoginFragment()).commit();
        /*loginbtn.setOnClickListener(new View.OnClickListener() {
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

        retrobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetroFragment retroFragment = new RetroFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainlinearlayout, retroFragment);
                transaction.commit();

            }
        });*/
    }


}