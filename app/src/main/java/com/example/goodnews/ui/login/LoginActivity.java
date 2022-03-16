package com.example.goodnews.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.goodnews.activity.NewsFeed;
import com.example.goodnews.R;
import com.example.goodnews.ui.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etEmailAddress, etPassword;
    TextView tvRegisterLink;
    UserLocal localStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailAddress = (EditText) findViewById(R.id.email_address);
        etPassword = (EditText) findViewById(R.id.password);
        bLogin = (Button) findViewById(R.id.login);
        tvRegisterLink = (TextView) findViewById(R.id.register_link);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        localStore = new UserLocal(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login:
                User user = new User(null, null);
                localStore.storeUserData(user);
                localStore.setUserLoggedIn(true);
                Context context = LoginActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivity = NewsFeed.class;
                // Create an Intent to start SecondActivity
                Intent intent = new Intent (context, destinationActivity);
                // Start the SecondActivity
                startActivity(intent);
                break;
            case R.id.register_link:
                Context context_register = LoginActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationRegister = RegisterActivity.class;
                // Create an Intent to start SecondActivity
                Intent intent_register = new Intent (context_register, destinationRegister);
                // Start the SecondActivity
                startActivity(intent_register);
                break;
        }
    }
}