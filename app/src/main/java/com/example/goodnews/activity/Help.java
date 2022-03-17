package com.example.goodnews.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.goodnews.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    /**
     * Creates the app's menu view.
     * @author Kate Belson
     * @param menu is app's menu.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Decides what to do when a menu item is selected.
     * @author Kate Belson and Dr Jia Hu
     * @param item is the menu item selected.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Context context = Help.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivity = NewsFeed.class;
                // Create an Intent to start SecondActivity
                Intent intent = new Intent(context, destinationActivity);
                // Start the SecondActivity
                startActivity(intent);
                break;
            case R.id.preferences:
                Context contextPreferences = Help.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivityPreferences = Preferences.class;
                // Create an Intent to start SecondActivity
                Intent intentPreferences = new Intent(contextPreferences, destinationActivityPreferences);
                // Start the SecondActivity
                startActivity(intentPreferences);
                break;
            case R.id.help:
                Context contextHelp = Help.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivityHelp = Help.class;
                // Create an Intent to start SecondActivity
                Intent intentHelp = new Intent(contextHelp, destinationActivityHelp);
                // Start the SecondActivity
                startActivity(intentHelp);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}