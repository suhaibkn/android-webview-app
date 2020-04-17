package com.suhaibknx.webview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.webview);

        //Load a URL on WebView
        webview.loadUrl(getString(R.string.url));

        // Code to prevent long taps to select text to give more native feel to the app
        webview.setLongClickable(true);
        webview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

        // Handling Page Navigation
        // to open all pages in the same widget
        webview.setWebViewClient(new WebViewClient());

        // Enable javascript
        webview.getSettings().setJavaScriptEnabled(true);
    }


    // For navigating back button presses
    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

}