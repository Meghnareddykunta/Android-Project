package com.example.project04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signIn_Home_Page extends AppCompatActivity {

    Button lookForRide, provideRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in__home__page);

        lookForRide = findViewById(R.id.lookForRideButton);
        provideRide = findViewById(R.id.provideRideButton);

        lookForRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signIn_Home_Page.this, HomeActivity.class);
                startActivity(i);
            }
        });

        provideRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(signIn_Home_Page.this, HomeActivity2.class);
                startActivity(i2);
            }
        });


    }
}
