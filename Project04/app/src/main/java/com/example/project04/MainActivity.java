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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText userPwd;
    FirebaseAuth firebaseAuth;
    Button loginBTN;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.loginEmail);
        userPwd = findViewById(R.id.loginPassword);
        loginBTN = findViewById(R.id.loginBTN);
        firebaseAuth = FirebaseAuth.getInstance();


        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Toast.makeText(MainActivity.this, "you are logged in", Toast.LENGTH_SHORT).show();
                    Intent intentOne = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intentOne);
                } else {
                    Toast.makeText(MainActivity.this, "PLease login", Toast.LENGTH_SHORT).show();
                }

            }
        };
        Button signUP = findViewById(R.id.signupBTN2);
        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTwo = new Intent(MainActivity.this, Signup.class);
                startActivity(intentTwo);
            }
        });

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailid = userName.getText().toString();
                String password = userPwd.getText().toString();
                if (emailid.isEmpty()) {
                    userName.setError("Enter the email");
                    userName.requestFocus();
                } else if (password.isEmpty()) {
                    userPwd.setError("Enter the password");
                    userPwd.requestFocus();
                } else if (emailid.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();

                } else if (!(emailid.isEmpty() && password.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(emailid, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Loginerror try again", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intentThree = new Intent(MainActivity.this, signIn_Home_Page.class);
                                startActivity(intentThree);
                            }
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
