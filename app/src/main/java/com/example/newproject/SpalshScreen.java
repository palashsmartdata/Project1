package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.newproject.Fragments.LoginFragment;

public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);



            getSupportActionBar().hide();

            Thread thread = new Thread(){
                public void run(){
                    try{
                        sleep(2500);
                    }
                    catch(Exception e){

                    }
                    finally {
                        Intent intent = new Intent(SpalshScreen.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            };thread.start();
        }
    }
