package com.example.goodnews.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.example.goodnews.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

/**
 * The WebActivity Activity allows users to read the news articles in a webpage-like view.
 * @author Kate Belson
 */

public class WebActivity extends AppCompatActivity {

    /**
     * Creates the activity and sets the content view.
     * @author Kate Belson
     * @param savedInstanceState is instance state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        final String url = getIntent().getStringExtra("url");
        WebView webView = findViewById(R.id.web_view);
        webView.loadUrl(url);
    }

    /**
     * This method is called when the Open Website button is clicked. It will open the website
     * specified by the URL of the news article using implicit intents.
     * @author Kate Belson and Dr Jia Hu
     * @param v Button that was clicked.
     */
    public void onClickOpenWebpageButton(View v) {
        String url = getIntent().getStringExtra("url");
        openWebPage(url);
    }

    /**
     * This method fires off an implicit Intent to open a webpage.
     * @author Kate Belson and Dr Jia Hu
     * @param url Url of webpage to open. Should start with http:// or https:// as that is the
     *            scheme of the URI expected with this Intent according to the Common Intents page.
     */
    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
     * @author Kate Belson
     * @param item is the menu item selected.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Context context = WebActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivity = NewsFeed.class;
                // Create an Intent to start SecondActivity
                Intent intent = new Intent(context, destinationActivity);
                // Start the SecondActivity
                startActivity(intent);
                break;
            case R.id.preferences:
                Context contextPreferences = WebActivity.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivityPreferences = Preferences.class;
                // Create an Intent to start SecondActivity
                Intent intentPreferences = new Intent(contextPreferences, destinationActivityPreferences);
                // Start the SecondActivity
                startActivity(intentPreferences);
                break;
            case R.id.help:
                Context contextHelp = WebActivity.this;
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