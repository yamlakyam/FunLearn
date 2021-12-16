package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class PickTopicActivity extends AppCompatActivity {

    MaterialCardView codingCard, artCard, businessCard, culinaryCard, sportCard;
    MaterialCardView musicCard, marketingCard, designCard, gamingCard;

    boolean codingClicked, artClicked, businessClicked, culinaryClicked, sportClicked,
            musicClicked, marketingClicked, designClicked, gamingClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_topic);

        codingCard = findViewById(R.id.codingCard);
        artCard = findViewById(R.id.artCard);
        businessCard = findViewById(R.id.businessCard);
        culinaryCard = findViewById(R.id.culinaryCard);
        sportCard = findViewById(R.id.sportCard);
        musicCard = findViewById(R.id.musicCard);
        marketingCard = findViewById(R.id.marketingCard);
        designCard = findViewById(R.id.designCard);
        gamingCard = findViewById(R.id.gamingCard);

        codingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codingClicked = !codingClicked;
                if (codingClicked) {
                    codingCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    codingCard.setStrokeWidth(10);
                    codingCard.setCardElevation(2f);
                } else {
                    codingCard.setStrokeWidth(0);
                }
            }
        });

        artCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artCard.setStrokeColor(Color.parseColor("#00a9b6"));
                artCard.setStrokeWidth(10);
                artCard.setCardElevation(2f);

            }
        });

        businessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessCard.setStrokeColor(Color.parseColor("#00a9b6"));
                businessCard.setStrokeWidth(10);
                businessCard.setCardElevation(2f);

            }
        });
        culinaryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                culinaryCard.setStrokeColor(Color.parseColor("#00a9b6"));
                culinaryCard.setStrokeWidth(10);
                culinaryCard.setCardElevation(2f);

            }
        });

        sportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportCard.setStrokeColor(Color.parseColor("#00a9b6"));
                sportCard.setStrokeWidth(10);
                sportCard.setCardElevation(2f);

            }
        });

        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicCard.setStrokeColor(Color.parseColor("#00a9b6"));
                musicCard.setStrokeWidth(10);
                musicCard.setCardElevation(2f);

            }
        });

        marketingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marketingCard.setStrokeColor(Color.parseColor("#00a9b6"));
                marketingCard.setStrokeWidth(10);
                marketingCard.setCardElevation(2f);

            }
        });

        designCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                designCard.setStrokeColor(Color.parseColor("#00a9b6"));
                designCard.setStrokeWidth(10);
                designCard.setCardElevation(2f);

            }
        });

        gamingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamingCard.setStrokeColor(Color.parseColor("#00a9b6"));
                gamingCard.setStrokeWidth(10);
                gamingCard.setCardElevation(2f);

            }
        });

    }

}