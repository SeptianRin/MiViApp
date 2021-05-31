package io.github.septianrin.miviapp.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.github.septianrin.miviapp.R;
import io.github.septianrin.miviapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActivityHomeBinding activityHomeBinding =ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        PagerAdapter pagerAdapter =new PagerAdapter(this,getSupportFragmentManager());
        activityHomeBinding.viewPager.setAdapter(pagerAdapter);
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setElevation(0);
        }
    }
}