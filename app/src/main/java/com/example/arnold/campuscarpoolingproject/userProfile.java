package com.example.arnold.campuscarpoolingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class userProfile extends AppCompatActivity implements View.OnClickListener{

    private Button logout;
    private Button viewBtn;
    private Button payment;
    private Button postBtn;
    private ImageView userPic;
    TextView emailTxt;

    //firebase auth object
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        emailTxt = findViewById(R.id.emailTxt);

        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, login.class));
        }
        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //displaying logged in user name
        emailTxt.setText("Welcome "+user.getEmail());

        logout = findViewById(R.id.logout);
        viewBtn = findViewById(R.id.viewBtn);
        payment = findViewById(R.id.payment);
        postBtn = findViewById(R.id.postBtn);

        logout.setOnClickListener(this);
        viewBtn.setOnClickListener(this);
        payment.setOnClickListener(this);
        postBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == logout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, login.class));
        }

        if(view == postBtn){
            finish();
            startActivity(new Intent(this, postRides.class));

        }
        if (view == viewBtn){
            finish();
            startActivity(new Intent(this, retrieve.class));

        }
        if (view == payment){
            finish();
            startActivity(new Intent(this, payment1.class));

        }
    }
}
