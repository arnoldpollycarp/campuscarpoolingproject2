package com.example.arnold.campuscarpoolingproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.arnold.campuscarpoolingproject.postRides.*;

public class joinTrip extends AppCompatActivity {
    Button JTrip;
    String id;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_trip);
        id = postRides.getId();
        JTrip = findViewById(R.id.JTrip);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        JTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase refDB = FirebaseDatabase.getInstance();
                DatabaseReference ref = refDB.getReference("User").child(id);
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot postSnapshot) {

                        //get data from snap shot
                        String data = postSnapshot.child("noPassengers").getValue().toString();
                        if (!data.equals(null)){
                            String noPassengers = (String) postSnapshot.child("noPassengers").getValue();

                           Integer count = Integer.valueOf(noPassengers);
                            count--;


                            String newValue = Integer.toString(count);
                            databaseReference.child("User").child("noPassengers").setValue(newValue);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(),"It wont Work",Toast.LENGTH_LONG);

                    }
                });
            }
        });
    }

}
