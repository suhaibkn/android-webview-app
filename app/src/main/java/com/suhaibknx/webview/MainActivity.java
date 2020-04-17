package com.suhaibknx.webview;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String loadURL = "https://www.google.com";
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To get black status bar on devices < M (23)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            Window window = MainActivity.this.getWindow();

            // Set this flag
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            // Clear this flag, as per android documentation
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // TODO this is yet to be tested
            window.setStatusBarColor(Color.BLACK);
        }

        webview = findViewById(R.id.webview);

        //Load a URL on WebView
        webview.loadUrl(this.loadURL);
    }

}