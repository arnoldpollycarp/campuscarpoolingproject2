package com.example.arnold.campuscarpoolingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sign_In, register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.register);//get id of button 1
        sign_In = (Button) findViewById(R.id.sign_In);//get id of button 2


// register button onclick listerner
        /*register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();//display the text of button1
            }
        });*/

        Button btn = (Button) findViewById(R.id.register);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, reg.class);
                startActivity(myIntent);
            }
        });
//sign in button onclick listener
       // sign_In.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
           //     Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
          //  }
      //  });
        Button sign_in = (Button) findViewById(R.id.sign_In);

        sign_in.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, login.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
