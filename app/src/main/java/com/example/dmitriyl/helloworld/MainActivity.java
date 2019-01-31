package com.example.dmitriyl.helloworld;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.dmitriyl.helloworld.fragments.HomeFragment;
import com.example.dmitriyl.helloworld.fragments.ProfileFragment;
import com.example.dmitriyl.helloworld.fragments.SearchFragment;
import com.example.dmitriyl.helloworld.interfaces.SaloonService;
import com.example.dmitriyl.helloworld.models.Saloon;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String msg = "Android";

    BottomNavigationView bottomNavigationView;
    MenuItem prevMenuItem;
    HomeFragment homeFragment;
    SearchFragment searchFragment;
    ProfileFragment profileFragment;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_schedules:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_music:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (prevMenuItem != null)
                {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+i);
                bottomNavigationView.getMenu().getItem(i).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(viewPager);





    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(searchFragment);
        adapter.addFragment(profileFragment);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg,"The onStart() event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(msg, "The onRestart() event");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStrop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}
