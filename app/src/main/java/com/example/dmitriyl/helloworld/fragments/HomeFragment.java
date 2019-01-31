package com.example.dmitriyl.helloworld.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmitriyl.helloworld.R;
import com.example.dmitriyl.helloworld.interfaces.SaloonService;
import com.example.dmitriyl.helloworld.models.Movie;
import com.example.dmitriyl.helloworld.models.MoviesAdapter;
import com.example.dmitriyl.helloworld.models.Saloon;
import com.example.dmitriyl.helloworld.models.SaloonsResponce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment
{
    private List<Saloon> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    public HomeFragment(){}

    private SaloonsResponce postList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://zp.jgroup.kz")

                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SaloonService saloonService = retrofit.create(SaloonService.class);
        System.out.println("Ok!!!!!!");
        Call<SaloonsResponce> repos = saloonService.saloonList();
        repos.enqueue(new Callback<SaloonsResponce>() {
            @Override
            public void onResponse(Call<SaloonsResponce> call,
                                   Response<SaloonsResponce> response) {
                postList = response.body();
                System.out.println(postList.getResponce().toString());

                System.out.println("Where List");
                movieList = postList.getResponce();


                recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

                mAdapter = new MoviesAdapter(movieList, getContext());


                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(horizontalLayoutManager);
                recyclerView.setAdapter(mAdapter);




                prepareMovieData();
            }

            @Override
            public void onFailure(Call<SaloonsResponce> call, Throwable t) {
                Log.d("ERROR", "error loading from API");
                t.printStackTrace();
            }

        });






        return rootView;

    }
    private void prepareMovieData() {
        mAdapter.notifyDataSetChanged();
    }
}
