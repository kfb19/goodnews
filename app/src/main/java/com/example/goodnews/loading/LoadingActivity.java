package com.example.goodnews.loading;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.goodnews.R;
import com.example.goodnews.activity.NewsFeed;

public class LoadingActivity extends AppCompatActivity implements View.OnClickListener{

    Button bStartApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        bStartApp = (Button) findViewById(R.id.start);

        bStartApp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.start:
                Context context = LoadingActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivity = NewsFeed.class;
                // Create an Intent to start SecondActivity
                Intent intent = new Intent (context, destinationActivity);
                // Start the SecondActivity
                startActivity(intent);
                break;
        }
    }
}