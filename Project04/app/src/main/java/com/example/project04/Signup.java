package com.example.project04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    EditText nameET;
    EditText pwd;
    EditText phno;
    EditText address;
    EditText email;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        nameET = findViewById(R.id.NameET);
        pwd = findViewById(R.id.passwordET);
        phno = findViewById(R.id.phoneET);
        address = findViewById(R.id.EditAddressTV);
        email = findViewById(R.id.EmailET);
        Button RegisterBTN = findViewById(R.id.RegisterBTN);
        RegisterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailid = email.getText().toString();
                String passwd = pwd.getText().toString();
                if (emailid.isEmpty()) {
                    email.setError("Enter the email");
                    email.requestFocus();
                } else if (passwd.isEmpty()) {
                    pwd.setError("Enter the password");
                    pwd.requestFocus();
                } else if (emailid.isEmpty() && passwd.isEmpty()) {
                    Toast.makeText(Signup.this, "fields are empty", Toast.LENGTH_SHORT).show();

                } else if (!(emailid.isEmpty() && passwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(emailid, passwd).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Signup.this, "Fields are empty try again", Toast.LENGTH_SHORT).show();
                            } else {
                                //getting the values from the edittext to store the values
                                String name = nameET.getText().toString();
                                String password = pwd.getText().toString();
                                String emailid = email.getText().toString();
                                String phone = phno.getText().toString();
                                String address = Signup.this.address.getText().toString();
                                //getting the user-id which is same as current user
                                String user_id= mFirebaseAuth.getCurrentUser().getUid();
                                //connecting the database reference
                                databaseReference = FirebaseDatabase.getInstance().getReference().child("userdata").child(user_id);
                                UserStorage userStorage = new UserStorage( name, emailid, password, address, phone);
                                nameET.setText("");
                                pwd.setText("");
                                email.setText("");
                                phno.setText("");
                                Signup.this.address.setText("");
                                databaseReference.setValue(userStorage);
                                Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                                Intent intentOne = new Intent(Signup.this, MainActivity.class);
                                startActivity(intentOne);
                            }
                        }
                    });
                }

            }
        });
    }

}
