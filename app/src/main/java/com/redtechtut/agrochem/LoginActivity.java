package com.redtechtut.agrochem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText loginUserName;
    private EditText loginPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPassword = findViewById(R.id.loginPassword);
        loginUserName = findViewById(R.id.loginUserName);

        login = findViewById(R.id.clickTologinBtn);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final ParseUser appUser = new ParseUser();
        appUser.setUsername(loginUserName.getText().toString());
        appUser.setPassword(loginPassword.getText().toString());

        ParseUser.logInInBackground(loginUserName.getText().toString(), loginPassword.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null && e == null) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
