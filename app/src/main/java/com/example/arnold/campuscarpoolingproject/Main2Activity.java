package com.example.arnold.campuscarpoolingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    private EditText TxtName, mail, pass, TxtPhone;
    private Button regIN;

    private ProgressBar progressBar;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();


        TxtName = findViewById(R.id.TxtName);
        regIN = findViewById(R.id.regIN);
        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        TxtPhone = findViewById(R.id.TxtPhone);


        findViewById(R.id.regIN).setOnClickListener((View.OnClickListener) this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            //handle the already login user
        }
    }


    private void regUser() {
        final String name = TxtName.getText().toString().trim();
        final String email = mail.getText().toString().trim();
        String password = pass.getText().toString().trim();
        final String phone = TxtPhone.getText().toString().trim();

        if (name.isEmpty()) {
            TxtName.setError(getString(R.string.input_error_name));
            TxtName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            mail.setError(getString(R.string.input_error_email));
            mail.requestFocus();
            return;
        }



    }
}
