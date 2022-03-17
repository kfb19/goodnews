package com.example.goodnews.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
}