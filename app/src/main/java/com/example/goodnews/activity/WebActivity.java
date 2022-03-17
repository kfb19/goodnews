package com.example.goodnews.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.goodnews.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
}