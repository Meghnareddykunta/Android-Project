package com.example.cabbie;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;


import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.basgeekball.awesomevalidation.AwesomeValidation;
//import com.basgeekball.awesomevalidation.ValidationStyle;
//import com.basgeekball.awesomevalidation.utility.RegexTemplate;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity{

    //private FirebaseAuth firebaseAuth;
    public EditText userName;
    public EditText password;
    //AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseApp.initializeApp(this);
      //  awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);

        userName = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);

//        awesomeValidation.addValidation(userName, Patterns.EMAIL_ADDRESS,getResources().getString(R.string.email));
//        awesomeValidation.addValidation(password, RegexTemplate.NOT_EMPTY,"Enter a password");

//        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void onLoginButtonClicked(View view){

//        if(awesomeValidation.validate()) {
            String email = userName.getText().toString().trim();
            String pwd = password.getText().toString().trim();

            if (email != null && pwd != null) {
//            firebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
                Intent intent = new Intent(MainActivity.this, LandingPage.class);
                startActivity(intent);
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
            }
        }
    }

