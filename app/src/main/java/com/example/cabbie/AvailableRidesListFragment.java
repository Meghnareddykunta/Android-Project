package com.example.cabbie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AvailableRidesListFragment extends Fragment {

    public DriverAdapter driverAdapter;
    public static ArrayList<DriverDetails> driverDetailsArrayList = new ArrayList<DriverDetails>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.availablerides_fragment,container,false);
        final ListView listView = (ListView)rootView.findViewById(R.id.listView);

        if(SharedObject.driverDetailsList.size() >0 ) {
            driverDetailsArrayList.addAll(SharedObject.driverDetailsList);
            SharedObject.driverDetailsList = new ArrayList<DriverDetails>();
        }
        driverAdapter = new DriverAdapter(getActivity(),0,driverDetailsArrayList);
        listView.setAdapter(driverAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DriverDetails driverDetailsObj = (DriverDetails)driverAdapter.getItem(position);
                Gson gson = new Gson();
                String obj = gson.toJson(driverDetailsObj);
                Intent intent = new Intent(getActivity().getApplicationContext(), RideDetailsActivity.class);
                intent.putExtra("rideDetailsObject",obj);
                startActivity(intent);
            }
        });

        return rootView;
    }

    class DriverAdapter extends ArrayAdapter<DriverDetails> {

        private Activity activity;
        private ArrayList<DriverDetails> listOfDriverDetails;
        private LayoutInflater inflater = null;

        public DriverAdapter(Activity activity, int resourceId, ArrayList<DriverDetails> listOfDriverDetails) {
            super(activity,resourceId, listOfDriverDetails);
            this.activity = activity;
            this.listOfDriverDetails = listOfDriverDetails;
        }

        public int getCount() {
            return listOfDriverDetails.size();
        }

        public DriverDetails getItem(DriverDetails position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public class ViewHolder {
            public TextView display_name;
            public TextView display_number;

        }

        public View getView(int position, View convertView, ViewGroup parent) {

                DriverDetailsView itemView = new DriverDetailsView(getActivity().getApplicationContext());
                DriverDetails item = (DriverDetails) driverDetailsArrayList.get(position);
                itemView.setName(item.getName());
                itemView.setFrom(item.fromCity + "   -  ");
                itemView.setTo(item.toCity);
                itemView.setDate(item.getDate());
                itemView.setTime(item.getTime());
                itemView.setImage(item.getResId());
                return itemView;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
