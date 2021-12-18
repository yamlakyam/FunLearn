package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.funlearn.Util.Constants;

public class CourseStartActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_start);

        //"Course-Url"

        String courseUrl = getIntent().getStringExtra("Course-Url");

        Log.i("TAG", Constants.BASE_URL + courseUrl);

        webView = findViewById(R.id.courseWebView);
        webView.loadUrl(Constants.BASE_URL + courseUrl);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });
    }
}