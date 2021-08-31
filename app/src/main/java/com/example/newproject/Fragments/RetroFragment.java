package com.example.newproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newproject.R;
import com.example.newproject.Retrofit.Model;
import com.example.newproject.Retrofit.MyApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFragment extends Fragment {
    TextView retrotextview;
    String url = "https://jsonplaceholder.typicode.com/";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retro, container, false);


        retrotextview = view.findViewById(R.id.retroTextView);
        retrotextview.setText(" ");


        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        MyApi api = retrofit.create(MyApi.class);

        Call<List<Model>> call = api.getModels();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                List<Model> data = response.body();
                for (int i = 0; i < data.size(); i++) {
                    retrotextview.append(" ID " + data.get(i).getRid() + "\n TITLE " + data.get(i).getTitle() + "\n\n\n");
                }

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });


        return view;
    }
}