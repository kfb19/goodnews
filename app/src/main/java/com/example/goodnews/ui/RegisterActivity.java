package com.example.goodnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.example.goodnews.R;
import com.example.goodnews.User;
import com.example.goodnews.ui.login.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etName, etEmailAddress, etPassword;
    TextView tvLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.name);
        etEmailAddress = (EditText) findViewById(R.id.email_address);
        etPassword = (EditText) findViewById(R.id.password);
        bRegister = (Button) findViewById(R.id.register);
        tvLoginLink = (TextView) findViewById(R.id.login_link);

        bRegister.setOnClickListener(this);
        tvLoginLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.register:
                String name = etName.getText().toString();
                String email = etEmailAddress.getText().toString();
                String password = etPassword.getText().toString();
                User registeredData = new User(name, email, password);
                Context context = RegisterActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivity = MainActivity.class;
                // Create an Intent to start SecondActivity
                Intent intent = new Intent (context, destinationActivity);
                // Start the SecondActivity
                startActivity(intent);
                break;
            case R.id.login_link:
                Context context_login = RegisterActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationLogin = LoginActivity.class;
                // Create an Intent to start SecondActivity
                Intent intent_login = new Intent(context_login, destinationLogin);
                // Start the SecondActivity
                startActivity(intent_login);
                break;
        }
    }
}