package com.redtechtut.agrochem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email, fullName, userName, password;
    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.registerEmail);
        fullName = findViewById(R.id.fullName);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.registerPassword);
        createAccount = findViewById(R.id.clickToRegisterBtn);

        createAccount.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }
    }

    @Override
    public void onClick(View view) {

        final ParseUser appUser = new ParseUser();
        appUser.setEmail(email.getText().toString());
        appUser.setUsername(userName.getText().toString());
        appUser.setPassword(password.getText().toString());

        appUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(RegisterActivity.this, appUser.getUsername() + " is Registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "There was an error, Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
