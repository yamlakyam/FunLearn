package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.funlearn.Util.Constants;

public class InstructorDetailActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_detail);

        String instructorUrl = getIntent().getStringExtra("InstructorURL");

        Log.i("TAG", Constants.BASE_URL + instructorUrl);

        webView = findViewById(R.id.webView);
        webView.loadUrl(Constants.BASE_URL + instructorUrl);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });

    }
}