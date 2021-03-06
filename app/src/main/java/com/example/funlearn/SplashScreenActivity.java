package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.funlearnIcon);

        ObjectAnimator anim = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        anim.setDuration(2000);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.start();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, PickTopicActivity.class));
                finish();
            }
        }, 3000);

    }
}