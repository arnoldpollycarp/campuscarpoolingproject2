package com.example.arnold.campuscarpoolingproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaSync;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity implements View.OnClickListener{
    //defining view objects
    private Button login;
    private EditText email,password;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;
//defining database objects
    private FirebaseAuth firebaseAuth;

    String LOG_TAG;
    String mStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() !=null){
            //that means user is already logged in
            //so close this activity
            finish();
            startActivity(new Intent(getApplicationContext(), userProfile.class));
        }



        login = findViewById(R.id.login1);
        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        textViewSignin = findViewById(R.id.textViewSignin);

        login.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

        //initialize firebase auth object

        //if a user is already logged

        progressDialog = new ProgressDialog(this);

    }

    private void userLogin (){
        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (TextUtils.isEmpty(mail)){
            //if name is empty
            Toast.makeText(this, "please enter name", Toast.LENGTH_LONG).show();
            //stop the operation from going further
            return;
        }
        if (TextUtils.isEmpty(pass)){
            //if name is empty
            Toast.makeText(this, "please enter name", Toast.LENGTH_LONG).show();
            //stop the operation from going further
            return;
        }

        //if validation is ok
        //show progress dialog
        progressDialog.setMessage("signing in user....");
        progressDialog.show();

        Log.i("ERRROR", mail + "=" + pass);

        firebaseAuth.signInWithEmailAndPassword(mail, pass)
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
                                Log.e("login", e.getMessage(), e);
                                mStatusTextView = e.getMessage();
                            }

                                 /*try {
                                    throw task.getException();;
                                } catch (FirebaseAuthInvalidUserException e) {
                                    mStatusTextView = e.toString();
                                 } catch (FirebaseAuthInvalidCredentialsException e) {
                                     mStatusTextView = e.toString();
                                 } catch (FirebaseNetworkException e) {
                                     mStatusTextView = e.toString();
                                } catch (Exception e) {
                                    Log.e(LOG_TAG, e.getMessage());
                                     mStatusTextView = e.toString();
                                 }*/
                               // Log.w(LOG_TAG, "signInWithEmail:failed", task.getException());

                            Toast.makeText(login.this, mStatusTextView, Toast.LENGTH_LONG).show();


                        }

                    }
                });


    }

    @Override
    public void onClick(View view) {
        if (view == login){
            userLogin();
        }
        if(view == textViewSignin){
            finish();
            startActivity(new Intent(this, reg.class));

        }
    }
}
