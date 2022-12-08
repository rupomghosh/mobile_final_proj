package com.example.curatedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUserName, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                if (validateUserName() && validatePassword()) {
                    if (!userName.equalsIgnoreCase("admin")) {
                        etUserName.setError("User name incorrect");
                    }
                    if (!password.equalsIgnoreCase("test123")) {
                        etPassword.setError("Password incorrect");
                    }
                    if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("test123")) {
                        Toast.makeText(this, "Welcome!!", Toast.LENGTH_LONG).show();
                        Intent send = new Intent(this, MainActivity.class);
                        startActivity(send);
                    }
                }
        }
    }

    public boolean validateUserName() {
        String value = etUserName.getText().toString().trim();
        if (value.isEmpty()) {
            etUserName.setError("User name is required");

            return false;
        } else {
            etUserName.setError(null);
            return true;

        }
    }

    public boolean validatePassword() {
        String value = etPassword.getText().toString().trim();
        if (value.isEmpty()) {
            etPassword.setError("Password is required");

            return false;
        } else {
            etPassword.setError(null);
            return true;

        }
    }
}