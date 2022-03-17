package com.example.goodnews.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.goodnews.R;
import android.os.Bundle;

/**
 * The Help Activity displays help text on how to use the app for the users.
 * @author Kate Belson
 */

public class Help extends AppCompatActivity {

    /**
     * Creates the activity and sets the content view.
     * @author Kate Belson
     * @param savedInstanceState is instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
}