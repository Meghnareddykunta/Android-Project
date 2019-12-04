package com.example.project04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RideList extends AppCompatActivity {
    private RecyclerView rideLV;
    private RecyclerView.Adapter rideAdapter;
    private RecyclerView.LayoutManager rideLayoutManager;

    private FirebaseFirestore db;
    private CollectionReference ridecollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_list);
        db = FirebaseFirestore.getInstance();
        ridecollection = db.collection("requestride");

        final ArrayList<Container> itemListArray = new ArrayList<>();

        ridecollection.orderBy("Username", Query.Direction.DESCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int i = 0;
                    for (QueryDocumentSnapshot doc : task.getResult()) {
                            itemListArray.add(new Container(doc.getId(),doc.getString("Username"), doc.getString("Phonenumber"), doc.getString("Your location"), doc.getString("Your city"),
                                    doc.getString("Your state"), doc.getString("Your zipcode"),doc.getString("Destination location"),doc.getString("Destination city"),
                                    doc.getString("Destination state"),doc.getString("Destination zipcode"),doc.getString("Date"),doc.getString("Time")));
                            i++;

                    }

                    rideLV = findViewById(R.id.ridesLV);
                    rideLV.setHasFixedSize(true);
                    rideLayoutManager = new LinearLayoutManager(RideList.this);
                    rideAdapter = new RidelistAdapter(itemListArray, RideList.this);
                    rideLV.setLayoutManager(rideLayoutManager);
                    rideLV.setAdapter(rideAdapter);
                }
            }
        });
    }
}
