package com.example.newproject.Fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newproject.Databases.UserDatabase;
import com.example.newproject.Databases.UserEntity;
import com.example.newproject.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RegisterFragment extends Fragment {

    EditText username, email, password, confirmpassword;
    Button registerbtn;
    UserDatabase userDatabase;
    TextView date;
    int year, month, day;


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
        date = view.findViewById(R.id.datetextview);


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
                                        userEntity.getConfirmpassword().isEmpty()) {

                                    Toast.makeText(getContext(), "All Fields Mandotary", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


                    }


                }).start();


            }


        });

        Calendar calendar = Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTimeInMillis()));

                    }
                }, year, month, day);
                datePickerDialog.show();


            }

        });


        return view;
    }
}


