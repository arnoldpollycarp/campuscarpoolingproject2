package com.example.arnold.campuscarpoolingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class joinTrip extends AppCompatActivity {
    Button JTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_trip);

        JTrip = findViewById(R.id.JTrip);
    }
}
