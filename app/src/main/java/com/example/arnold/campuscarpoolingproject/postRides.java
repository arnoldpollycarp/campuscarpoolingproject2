package com.example.arnold.campuscarpoolingproject;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class postRides extends AppCompatActivity {
     EditText destination,time,from,noPassengers,price;
     TextView postRides;
     Button post;

    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_rides);

        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("User");

        destination = findViewById(R.id.destination);
        time = findViewById(R.id.time);
        from = findViewById(R.id.from);
        noPassengers = findViewById(R.id.noPassengers);
        price = findViewById(R.id.price);
        postRides = findViewById(R.id.postRides);
        post = findViewById(R.id.post);

        progressDialog = new ProgressDialog(this);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRide();
            }
        });

    }
    private void addRide(){
        String Destination = destination.getText().toString().trim();
        String Time = time.getText().toString().trim();
        String From = from.getText().toString().trim();
        String Nopassengers = noPassengers.getText().toString().trim();
        String Price = price.getText().toString().trim();


        if (!TextUtils.isEmpty(Destination) || (!TextUtils.isEmpty(Time)) || (!TextUtils.isEmpty(From))
                || (!TextUtils.isEmpty(Nopassengers))
                ||
                (!TextUtils.isEmpty(Price)))
        {
            String id = databaseUser.push().getKey();
            //declaring a new user
            User user = new User(id,Destination,Time,From,Nopassengers,Price);

            databaseUser.child(id).setValue(user);
            Toast.makeText(this,"ride added", Toast.LENGTH_LONG).show();


        }else {
            Toast.makeText(this,"Check you inputs and try again", Toast.LENGTH_LONG).show();
        }
        progressDialog.setMessage("adding trip....");
        progressDialog.show();

    }
}
