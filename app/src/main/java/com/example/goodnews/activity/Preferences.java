package com.example.goodnews.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.example.goodnews.R;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import static android.content.ContentValues.TAG;

/**
 * The Preferences Activity allows users to choose between a dark and a light theme. 
 * @author Kate Belson
 */

public class Preferences extends Activity implements View.OnClickListener {

    Button btnLightTheme;
    Button btnDarkTheme;
    TextView txtCaption1;
    //    Boolean fancyPrefChosen = false;
    View myLayout1Vertical;

    //    final int mode = Activity.MODE_PRIVATE;
    final String MYPREFS = "MyPreferences_001";

    // create a reference to the shared preferences object
    SharedPreferences mySharedPreferences;

    // obtain an editor to add data to my SharedPreferences object
    SharedPreferences.Editor myEditor;

    /**
     * Creates the activity and sets the content view.
     * @author Kate Belson
     * @param savedInstanceState is instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        myLayout1Vertical = (View)findViewById(R.id.linLayout1Vertical);
        txtCaption1 = (TextView) findViewById(R.id.txtCaption1);
        txtCaption1.setText("This is a sample of the new theme you've selected.");

        // create a reference & editor for the shared preferences object
        mySharedPreferences = getSharedPreferences(MYPREFS, 0);
        myEditor = mySharedPreferences.edit();

        // has a Preferences file been already created?
        if (mySharedPreferences != null
                && mySharedPreferences.contains("backColor")) {
            // object and key found, show all saved values
            applySavedPreferences();
        } else {
            Toast.makeText(getApplicationContext(),
                    "No Preferences found", Toast.LENGTH_LONG).show();
        }
        btnLightTheme = (Button) findViewById(R.id.bLightTheme);
        btnLightTheme.setOnClickListener(this);
        btnDarkTheme = (Button) findViewById(R.id.bDarkTheme);
        btnDarkTheme.setOnClickListener(this);

    }

    /**
     * Describes what happens when you click on one of the theme buttons.
     * @author Kate Belson and Dr Jia Hu
     * @param v is the view
     */
    @Override
    public void onClick(View v) {
        // clear all previous selections
        myEditor.clear();

        // what button has been clicked?
        if (v.getId() == btnLightTheme.getId()) {
            myEditor.putInt("backColor", Color.WHITE); // black background
        } else { // case bDarkTheme
            myEditor.putInt("backColor", Color.BLACK); // fancy blue
        }
        myEditor.commit();
        applySavedPreferences();
    }

    /**
     * Restarts the activity with the shared preferences.
     * @author Dr Jia Hu
     */
    @Override
    protected void onPause() {
        // warning: activity is on its last state of visibility!
        // It's on the edge of being killed! Better save all current
        // state data into Preference object (be quick!)
        myEditor.putString("DateLastExecution", new Date().toLocaleString());
        myEditor.commit();
        super.onPause();
    }

    /**
     * Applies the SharedPreferences.
     * @author Kate Belson and Dr Jia Hu
     */
    public void applySavedPreferences() {
        // extract the <key-value> pairs, use default param for missing data
        int backColor = mySharedPreferences.getInt("backColor",Color.GRAY);
        int textSize = mySharedPreferences.getInt("textSize", 12);
        String textStyle = mySharedPreferences.getString("textStyle", "normal");
        int layoutColor = mySharedPreferences.getInt("layoutColor",Color.DKGRAY);
        String msg = "color " + backColor + "\n"
                + "size "   + textSize    + "\n"
                + "style " + textStyle;
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        txtCaption1.setBackgroundColor(backColor);
        txtCaption1.setTextSize(textSize);
        if (textStyle.compareTo("normal")==0){
            txtCaption1.setTypeface(Typeface.SERIF,Typeface.NORMAL);
        } else {
            txtCaption1.setTypeface(Typeface.SERIF, Typeface.BOLD);
        }
        myLayout1Vertical.setBackgroundColor(layoutColor);
    }// applySavedPreferences

}
