package com.example.goodnews.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.goodnews.R;
import com.example.goodnews.ui.MainActivity;
import com.example.goodnews.ui.Register;
import com.example.goodnews.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etEmailAddress, etPassword;
    TextView tvRegisterLink;

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
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login:
                Context context = LoginActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivity = MainActivity.class;
                // Create an Intent to start SecondActivity
                Intent intent = new Intent (context, destinationActivity);
                // Start the SecondActivity
                startActivity(intent);
                break;
            case R.id.register_link:
                Context context_register = LoginActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationRegister = Register.class;
                // Create an Intent to start SecondActivity
                Intent intent_register = new Intent (context_register, destinationRegister);
                // Start the SecondActivity
                startActivity(intent_register);
                break;
        }
    }
}