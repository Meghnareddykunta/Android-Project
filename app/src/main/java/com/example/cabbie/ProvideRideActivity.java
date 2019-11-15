package com.example.cabbie;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ProvideRideActivity extends AppCompatActivity {

    ProvideNewRideFragment provideNewRideFragment;
    RequestedRidesListFragment requestedRidesListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provide_ride);

        Toolbar toolbar = (Toolbar) findViewById(R.id.providerToolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Back");
        }

        provideNewRideFragment = new ProvideNewRideFragment();
        requestedRidesListFragment = new RequestedRidesListFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.providerContainer, requestedRidesListFragment).commit();

        TabLayout tabs = (TabLayout)findViewById(R.id.providerTabs);
        tabs.addTab(tabs.newTab().setText("Requested rides"));
        tabs.addTab(tabs.newTab().setText("Offer a ride"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                Fragment selected = null;
                if (position == 0) {
                    selected = requestedRidesListFragment;
                } else if (position == 1) {
                    selected = provideNewRideFragment;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.providerContainer, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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
