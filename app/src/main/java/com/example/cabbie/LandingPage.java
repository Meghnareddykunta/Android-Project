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



//    public void lookForRideClicked(View view){
//        Intent intent = new Intent(getApplicationContext(), LookForRideActivity.class);
//        startActivity(intent);
//    }

    public void provideRideClicked(View view){
        Intent intent = new Intent(getApplicationContext(), ProvideRide.class);
        startActivity(intent);
    }
}
