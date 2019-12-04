package com.example.project04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Request_ride extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private CollectionReference itemCollection;
    private FirebaseFirestore db;
    private EditText name,phn, yourlocation, yourcity, yourstate, yourzipcode,destlocation, destcity, deststate, destzipcode, date, time;
    private Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_ride);
        db = FirebaseFirestore.getInstance();
        itemCollection = db.collection("requestride");
        name=findViewById(R.id.editText);
        phn=findViewById(R.id.editText3);
        yourlocation=findViewById(R.id.editText4);
        yourcity=findViewById(R.id.editText5);
        yourstate=findViewById(R.id.editText6);
        yourzipcode=findViewById(R.id.editText7);
        destlocation=findViewById(R.id.editText8);
        destcity=findViewById(R.id.editText9);
        deststate=findViewById(R.id.editText10);
        destzipcode=findViewById(R.id.editText14);
        date=findViewById(R.id.editText12);
        time=findViewById(R.id.editText13);
        confirm=findViewById(R.id.button5);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> addride = new HashMap<>();
                addride.put("Username",name.getText().toString() );
                addride.put("Phonenumber", phn.getText().toString());
                addride.put("Your location", yourlocation.getText().toString());
                addride.put("Your city", yourcity.getText().toString());
                addride.put("Your state", yourstate.getText().toString());
                addride.put("Your zipcode", yourzipcode.getText().toString());
                addride.put("Destination location", destlocation.getText().toString());
                addride.put("Destination city", destcity.getText().toString());
                addride.put("Destination state", deststate.getText().toString());
                addride.put("Destination zipcode", destzipcode.getText().toString());
                addride.put("Date", date.getText().toString());
                addride.put("Time", time.getText().toString());
                itemCollection.document().set(addride);
                Toast.makeText(Request_ride.this,"Your ride has been requested",Toast.LENGTH_LONG).show();
            }
        });

    }
}
