package com.example.cabbie;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

public class RideDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detailsToolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Back");
        }

        Gson gson = new Gson();
        String obj = getIntent().getStringExtra("rideDetailsObject");
        DriverDetails driverDetails = gson.fromJson(obj, DriverDetails.class);
        EditText name = (EditText)findViewById(R.id.name);
        name.setText(driverDetails.getName());
        EditText fromAddress = (EditText)findViewById(R.id.fromAddress);
        fromAddress.setText(driverDetails.getFromAddress());
        EditText fromCity = (EditText)findViewById(R.id.fromCity);
        fromCity.setText(driverDetails.getFromCity());
        EditText fromState = (EditText)findViewById(R.id.fromState);
        fromState.setText(driverDetails.getFromState());
        EditText fromZipCode = (EditText)findViewById(R.id.fromZipCode);
        fromZipCode.setText(driverDetails.getFromZipCode());
        EditText toAddress = (EditText)findViewById(R.id.toAddress);
        toAddress.setText(driverDetails.getToAddress());
        EditText toCity = (EditText)findViewById(R.id.toCity);
        toCity.setText(driverDetails.getToCity());
        EditText toState = (EditText)findViewById(R.id.toState);
        toState.setText(driverDetails.getToState());
        EditText toZipCode = (EditText)findViewById(R.id.toZipCode);
        toZipCode.setText(driverDetails.getToZipCode());
        EditText date = (EditText)findViewById(R.id.date);
        date.setText(driverDetails.getDate());
        EditText time = (EditText)findViewById(R.id.time);
        time.setText(driverDetails.getTime());

        final String contactNumber = driverDetails.getPhone();
        Button contactButton = (Button)findViewById(R.id.cantactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+contactNumber));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
