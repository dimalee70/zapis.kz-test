package com.example.dmitriyl.helloworld;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.dmitriyl.helloworld.interfaces.SaloonService;
import com.example.dmitriyl.helloworld.models.SaloonInfoResponce;


import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoActivity extends AppCompatActivity
{

    private String [] urls;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private TextView id1;
    private TextView name1;
    private TextView type1;
    private TextView address1;
    private TextView checkRating1;
    private TextView workStartTime1;
    private TextView workEndTime1;
    private TextView description;

    private TextView instagramProfile1;

    private SaloonInfoResponce saloonInfoResponce;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_info);
        final int id = getIntent().getIntExtra("id", -1);
        id1 = (TextView) findViewById(R.id.id1);
        name1 = (TextView) findViewById(R.id.name1);
        type1 = (TextView) findViewById(R.id.type1);
        address1 = (TextView) findViewById(R.id.address1);
        checkRating1 = (TextView) findViewById(R.id.checkRating1);
        workStartTime1 = (TextView) findViewById(R.id.workStartTime1);
        workEndTime1 = (TextView) findViewById(R.id.workEndTime1);
        description = (TextView) findViewById(R.id.description);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://zp.jgroup.kz")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final SaloonService saloonService = retrofit.create(SaloonService.class);
        System.out.println("Ok!!!!!!");
        Call<SaloonInfoResponce> repos = saloonService.getSaloon(id);
        repos.enqueue(new Callback<SaloonInfoResponce>() {
            @Override
            public void onResponse(Call<SaloonInfoResponce> call,
                                   Response<SaloonInfoResponce> response) {
                saloonInfoResponce = response.body();
                System.out.println(saloonInfoResponce.getSaloonInfo().toString());

                urls =  saloonInfoResponce.getSaloonInfo().getPictures();

                id1 = (TextView) findViewById(R.id.id1);
                name1 = (TextView) findViewById(R.id.name1);
                type1 = (TextView) findViewById(R.id.type1);
                address1 = (TextView) findViewById(R.id.address1);
                checkRating1 = (TextView) findViewById(R.id.checkRating1);
                workStartTime1 = (TextView) findViewById(R.id.workStartTime1);
                workEndTime1 = (TextView) findViewById(R.id.workEndTime1);
                description = (TextView) findViewById(R.id.description);
                System.out.println(saloonInfoResponce.getSaloonInfo().getAddress());
                name1.setText("dfsdfsd");
//                id1.setText(id);
                name1.setText((saloonInfoResponce.getSaloonInfo().getName()
                ==null)?"":saloonInfoResponce.getSaloonInfo().getName());
                type1.setText((saloonInfoResponce.getSaloonInfo().getType()
                == null)?"":saloonInfoResponce.getSaloonInfo().getType());
                address1.setText((saloonInfoResponce.getSaloonInfo().getAddress()
                ==null)?"":saloonInfoResponce.getSaloonInfo().getAddress());
                checkRating1.setText((saloonInfoResponce.getSaloonInfo().getCheckRating()
                ==null)?"": saloonInfoResponce.getSaloonInfo().getCheckRating());
                workStartTime1.setText((saloonInfoResponce.getSaloonInfo().getWorkStartTime()
                ==null)?"":saloonInfoResponce.getSaloonInfo().getWorkStartTime());
                workEndTime1.setText((saloonInfoResponce.getSaloonInfo().getWorkEndTime()
                ==null)?"":saloonInfoResponce.getSaloonInfo().getWorkEndTime());
                description.setText((saloonInfoResponce.getSaloonInfo().getDescription()
                ==null)?"":saloonInfoResponce.getSaloonInfo().getDescription());



            }
            @Override
            public void onFailure(Call<SaloonInfoResponce> call, Throwable t) {
                Log.d("ERROR", "error loading from API");
                t.printStackTrace();
            }

        });
    }
}
