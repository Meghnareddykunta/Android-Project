package com.example.project04;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RidelistAdapter extends RecyclerView.Adapter<RidelistAdapter.ItemsViewHolder> {
    private ArrayList<Container> itemListArray;

    public RidelistAdapter(ArrayList<Container> itemListArray, Context context) {
        this.itemListArray = itemListArray;
        this.context = context;
    }

    private Context context;


    public static class ItemsViewHolder extends RecyclerView.ViewHolder {
        public TextView username;
        public TextView source;
        public TextView destination;
        public TextView date;
        public TextView time;

        public Button contact;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            source = itemView.findViewById(R.id.source);
            destination = itemView.findViewById(R.id.destination);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);



            contact=itemView.findViewById(R.id.button6);
        }
    }

    @NonNull
    @Override
    public RidelistAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_ridelist_container, viewGroup, false);
        RidelistAdapter.ItemsViewHolder itemsVH = new RidelistAdapter.ItemsViewHolder(v);
        return itemsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull final RidelistAdapter.ItemsViewHolder itemsViewHolder, final int i) {

        final Container currentItem = itemListArray.get(i);
        itemsViewHolder.username.setText("UserName: "+currentItem.getName());
        itemsViewHolder.source.setText("From: " + currentItem.getYourlocation());
        itemsViewHolder.destination.setText("To: " + currentItem.getDestlocation());
        itemsViewHolder.date.setText("Date: " + currentItem.getDate());
        itemsViewHolder.time.setText("Time: " + currentItem.getTime());


        itemsViewHolder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemListArray.size();
    }


}

