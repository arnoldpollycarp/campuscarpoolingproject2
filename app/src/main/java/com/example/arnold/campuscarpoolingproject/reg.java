package com.example.arnold.campuscarpoolingproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reg extends AppCompatActivity implements View.OnClickListener {

    EditText userName,location,email,deptID,password,comfirpass,preference,phone,carPlate,userType;
    Button register;
    TextView login;

    private ProgressDialog progressDialog;
    DatabaseReference databaseUser;
    private FirebaseAuth firebaseAuth;

    String mStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        //Get Firebase auth instance
        firebaseAuth = FirebaseAuth.getInstance();

        databaseUser = FirebaseDatabase.getInstance().getReference("User");

        userName = findViewById(R.id.userName);
        location = findViewById(R.id.location);
        email = findViewById(R.id.email);
        deptID = findViewById(R.id.deptID);
        password = findViewById(R.id.password);
        comfirpass = findViewById(R.id.comfirpass);
        preference = findViewById(R.id.preference);
        phone = findViewById(R.id.phone);
        carPlate = findViewById(R.id.carPlate);
        userType = findViewById(R.id.userType);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        progressDialog = new ProgressDialog(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();

            }
        });

    }
    private void registerUser(){
        String Username = userName.getText().toString().trim();
        String Location = location.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String DepartmentID = deptID.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String ComfirmPass = comfirpass.getText().toString().trim();
        String Preference = preference.getText().toString().trim();
        String Phone = phone.getText().toString().trim();
        String UserType = userType.getText().toString().trim();
        String CarPlate = carPlate.getText().toString().trim();

        if (!TextUtils.isEmpty(Username) || (password.getText().toString().trim() !=  comfirpass.getText().toString().trim()) ||
                (!TextUtils.isEmpty(Location)) || (!TextUtils.isEmpty(Email)) || (!TextUtils.isEmpty(DepartmentID)) || (!TextUtils.isEmpty(Password)) ||
                (!TextUtils.isEmpty(Preference)) || (!TextUtils.isEmpty(Phone)) || (!TextUtils.isEmpty(UserType)) || (!TextUtils.isEmpty(CarPlate)))
        {
            String id = databaseUser.push().getKey();

            //declaring a new user
            User user = new User(id,Username,Location,Email,DepartmentID,Password,Preference,Phone,UserType,CarPlate);

            databaseUser.child(id).setValue(user);
            Toast.makeText(this,"user added",Toast.LENGTH_LONG).show();


        }else {
            Toast.makeText(this,"Check you inputs and try again", Toast.LENGTH_LONG).show();
        }

        progressDialog.setMessage("registering user....");
        progressDialog.show();



        //create user
        firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            //start user profile
                            finish();
                            startActivity(new Intent(getApplicationContext(), userProfile.class));
                        }else {
                            //Toast.makeText(login.this, "login failed !", Toast.LENGTH_LONG).show();
                            Exception e = task.getException();
                            if (e != null){
                                Log.e("reg", e.getMessage(), e);
                                mStatusTextView = e.getMessage();
                            }

                    }
                }


                });
    }




    @Override
    public void onClick(View view) {

    }
}
