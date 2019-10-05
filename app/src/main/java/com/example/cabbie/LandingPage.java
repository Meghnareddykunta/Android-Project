package com.example.cabbie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class LandingPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        Intent ini = getIntent();
    }

    public void onSlide(View v){
        finish();
    }
    public void lookForRideClicked(View v){
        finish();
    }
    public void provideRideClicked(View v){
        finish();
    }
}
