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
    private List<Saloon> movieList = new ArrayList <>();
    private List<Saloon> movieList2 = new ArrayList <>();
    private List<Saloon> movieList3 = new ArrayList<>();
    private List<Saloon> getMovieList3 = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private MoviesAdapter mAdapter;
    private MoviesAdapter mAdapter2;
    private MoviesAdapter mAdapter3;



    public HomeFragment(){}

    private SaloonsResponce postList;
    private SaloonsResponce postList2;
    private SaloonsResponce postList3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://zp.jgroup.kz")

                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SaloonService saloonService = retrofit.create(SaloonService.class);
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




                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SaloonsResponce> call, Throwable t) {
                Log.d("ERROR", "error loading from API");
                t.printStackTrace();
            }

        });



        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://zp.jgroup.kz")

                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SaloonService saloonService2 = retrofit2.create(SaloonService.class);
        Call<SaloonsResponce> repos2 = saloonService2.saloonListRecommended();
        repos2.enqueue(new Callback<SaloonsResponce>() {
            @Override
            public void onResponse(Call<SaloonsResponce> call,
                                   Response<SaloonsResponce> response) {
                postList2 = response.body();
                System.out.println(postList2.getResponce().toString());

                System.out.println("Where List");
                movieList2 = postList2.getResponce();


                recyclerView2 = (RecyclerView) rootView.findViewById(R.id.recycler_view2);

                mAdapter2 = new MoviesAdapter(movieList2, getContext());


                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView2.setLayoutManager(mLayoutManager);
                recyclerView2.setItemAnimator(new DefaultItemAnimator());
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView2.setLayoutManager(horizontalLayoutManager);
                recyclerView2.setAdapter(mAdapter2);




                mAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SaloonsResponce> call, Throwable t) {
                Log.d("ERROR", "error loading from API");
                t.printStackTrace();
            }

        });


        Retrofit retrofit3 = new Retrofit.Builder()
                .baseUrl("http://zp.jgroup.kz")

                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SaloonService saloonService3 = retrofit3.create(SaloonService.class);
        Call<SaloonsResponce> repos3 = saloonService3.saloonListRecommended();
        repos3.enqueue(new Callback<SaloonsResponce>() {
            @Override
            public void onResponse(Call<SaloonsResponce> call,
                                   Response<SaloonsResponce> response) {
                postList3 = response.body();
                System.out.println(postList3.getResponce().toString());

                System.out.println("Where List");
                movieList3 = postList3.getResponce();


                recyclerView3 = (RecyclerView) rootView.findViewById(R.id.recycler_view3);

                mAdapter3 = new MoviesAdapter(movieList3, getContext());


                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView3.setLayoutManager(mLayoutManager);
                recyclerView3.setItemAnimator(new DefaultItemAnimator());
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView3.setLayoutManager(horizontalLayoutManager);
                recyclerView3.setAdapter(mAdapter3);




                mAdapter3.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SaloonsResponce> call, Throwable t) {
                Log.d("ERROR", "error loading from API");
                t.printStackTrace();
            }

        });

        return rootView;

    }
//    private void prepareMovieData() {
//        mAdapter.notifyDataSetChanged();
//    }
}
