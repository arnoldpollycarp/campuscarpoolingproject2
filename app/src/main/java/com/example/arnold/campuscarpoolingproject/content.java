package com.example.arnold.campuscarpoolingproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by User on 2/8/2017.
 */




public class content extends AppCompatActivity {
    ListView listview;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("User");

        user = new User();
        listview = findViewById(R.id.listview);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.trip_details,R.id.tripDet, list);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    user = ds.getValue(User.class);
                    list.add(user.getDestination().toString() + " "
                            +user.getTime().toString() +" "
                            +user.getNoPassengers().toString() +" "
                            +user.getPrice().toString() +" "
                            +user.getFrom() +" ");

                }
                listview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        }
    }



