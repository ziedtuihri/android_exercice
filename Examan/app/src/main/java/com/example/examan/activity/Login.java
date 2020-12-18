package com.example.examan.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.examan.R;
import com.example.examan.constant.Constants;

public class Login extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    TextView btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    public void initViews(){
        edtEmail        = findViewById(R.id.ed_username);
        edtPassword     = findViewById(R.id.ed_password);
        btnLogin        = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    public void loginUser(){
        String edt_email = edtEmail.getText().toString().trim();
        String edt_passwd = edtPassword.getText().toString().trim();

        if(validation(edt_email,edt_passwd)){
            successLogin();
        }
    }

    public boolean validation(String edt_email, String edt_passwd){

        boolean isEmailValid = true, isPasswordValid = true;

        // Check for a valid Email
        if (edt_email.isEmpty()) {
            edtEmail.setError("Please enter your Email.");
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edt_email).matches()) {
            edtEmail.setError("enter a valid Email");
            isEmailValid = false;
        }

        // Check for a valid Password
        if (edt_passwd.isEmpty()) {
            edtPassword.setError("Please enter your Password.");
            isPasswordValid = false;
        } else if (edt_passwd.length() < 6) {
            edtPassword.setError("At Least 6 caracters.");
            isPasswordValid = false;
        }

        // If Email and Password are Valid.
        return (isEmailValid && isPasswordValid);
    }

    public void successLogin(){
        SharedPreferences sharedPref = getSharedPreferences(Constants.MY_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constants.PREF_IS_CONNECTED, true);
        editor.apply();
        startActivity(new Intent(this, Home.class));
        finish();
    }
}