package com.example.arnold.campuscarpoolingproject;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class postRides extends AppCompatActivity {
     EditText destination,time,from,seats_available,price,drivers_tel,car_plate,name;
     TextView postRides;
     Button post;
    private static String  id;

    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    public static String getId() {
        return id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_rides);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Trip");

        destination = findViewById(R.id.destination);
        car_plate = findViewById(R.id.car_plate);
        name = findViewById(R.id.name);
        drivers_tel = findViewById(R.id.drivers_tel);
        time = findViewById(R.id.time);
        from = findViewById(R.id.from);
        seats_available = findViewById(R.id.seats_available);
        price = findViewById(R.id.price);
        postRides = findViewById(R.id.postRides);
        post = findViewById(R.id.post);

       // progressDialog = new ProgressDialog(this);

        /*post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRide();
            }
        });*/

    }

    public void addRide(View v){
        try{
            String Destination = destination.getText().toString().trim();
            String Time = time.getText().toString().trim();
            String From = from.getText().toString().trim();
            String Seats_available = seats_available.getText().toString().trim();
            String Price = price.getText().toString().trim();
            String Name = name.getText().toString().trim();
            String Car_plate = car_plate.getText().toString().trim();
            String Drivers_tel = drivers_tel.getText().toString().trim();


            if (!TextUtils.isEmpty(Destination) &&
                    !TextUtils.isEmpty(Time) &&
                    !TextUtils.isEmpty(From) &&
                    !TextUtils.isEmpty(Seats_available) &&
                    !TextUtils.isEmpty(Price) &&
                    !TextUtils.isEmpty(Name) &&
                    !TextUtils.isEmpty(Car_plate) &&
                    !TextUtils.isEmpty(Drivers_tel)) {

                 id = databaseReference.push().getKey();
                //declaring a new user
                Trip trip = new Trip(Destination, Time, From, Seats_available, Price,Name, Car_plate, Drivers_tel);

                databaseReference.child(id).setValue(trip);

                Toast.makeText(this,"ride added", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(this,"Check you inputs and try again", Toast.LENGTH_SHORT).show();
            }

          //  progressDialog.setMessage("adding trip....");
            //progressDialog.show();
        }catch (Exception e){
            Log.e("PostRides", e.getMessage(), e);
        }
    }
}
