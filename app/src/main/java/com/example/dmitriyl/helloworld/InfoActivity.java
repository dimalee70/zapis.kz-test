package com.example.dmitriyl.helloworld;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.dmitriyl.helloworld.interfaces.SaloonService;
import com.example.dmitriyl.helloworld.models.SaloonInfoResponce;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


import java.util.Arrays;
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
    private SliderLayout sliderLayout ;


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
        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(5); //set scroll delay in seconds :

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

                System.out.println("urls " + Arrays.toString(urls));
                setSliderViews();
                id1 = (TextView) findViewById(R.id.id1);
                name1 = (TextView) findViewById(R.id.name1);
                type1 = (TextView) findViewById(R.id.type1);
                address1 = (TextView) findViewById(R.id.address1);
                checkRating1 = (TextView) findViewById(R.id.checkRating1);
                workStartTime1 = (TextView) findViewById(R.id.workStartTime1);
                workEndTime1 = (TextView) findViewById(R.id.workEndTime1);
                description = (TextView) findViewById(R.id.description);

                name1.setText(Html.fromHtml(saloonInfoResponce.getSaloonInfo().getName(),
                        Html.FROM_HTML_MODE_COMPACT));
//                id1.setText(id);

                name1.setText((saloonInfoResponce.getSaloonInfo().getName()
                ==null)?"": Html.fromHtml(saloonInfoResponce.getSaloonInfo().getName(),
                        Html.FROM_HTML_MODE_COMPACT));
                type1.setText((saloonInfoResponce.getSaloonInfo().getType()
                == null)?"":Html.fromHtml(saloonInfoResponce.getSaloonInfo().getType(),
                        Html.FROM_HTML_MODE_COMPACT));
                address1.setText((saloonInfoResponce.getSaloonInfo().getAddress()
                ==null)?"":Html.fromHtml(saloonInfoResponce.getSaloonInfo().getAddress(),
                        Html.FROM_HTML_MODE_COMPACT));
                checkRating1.setText((saloonInfoResponce.getSaloonInfo().getCheckRating()
                ==null)?"": Html.fromHtml(saloonInfoResponce.getSaloonInfo().getCheckRating(),
                        Html.FROM_HTML_MODE_COMPACT));
                workStartTime1.setText((saloonInfoResponce.getSaloonInfo().getWorkStartTime()
                ==null)?"":Html.fromHtml(saloonInfoResponce.getSaloonInfo().getWorkStartTime(),
                        Html.FROM_HTML_MODE_COMPACT));
                workEndTime1.setText((saloonInfoResponce.getSaloonInfo().getWorkEndTime()
                ==null)?"":Html.fromHtml(saloonInfoResponce.getSaloonInfo().getWorkEndTime(),
                        Html.FROM_HTML_MODE_COMPACT));
                description.setText((saloonInfoResponce.getSaloonInfo().getDescription()
                ==null)?"":Html.fromHtml(saloonInfoResponce.getSaloonInfo().getDescription(),
                        Html.FROM_HTML_MODE_COMPACT));





            }
            @Override
            public void onFailure(Call<SaloonInfoResponce> call, Throwable t) {
                Log.d("ERROR", "error loading from API");
                t.printStackTrace();
            }

        });
    }

    private void setSliderViews() {

        for (String s : urls) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            if (s != null) {
                sliderView.setImageUrl("http://zp.jgroup.kz"+s);

                sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);


                sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(SliderView sliderView) {
                        Toast.makeText(InfoActivity.this, "This is slider ", Toast.LENGTH_SHORT).show();

                    }
                });
            }
            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}
