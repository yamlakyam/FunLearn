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

                artClicked = !artClicked;

                if (artClicked) {
                    artCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    artCard.setStrokeWidth(10);
                    artCard.setCardElevation(2f);
                } else {
                    artCard.setStrokeWidth(0);
                }

            }
        });

        businessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessClicked = !businessClicked;
                if (businessClicked) {
                    businessCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    businessCard.setStrokeWidth(10);
                    businessCard.setCardElevation(2f);
                } else {
                    businessCard.setStrokeWidth(0);

                }


            }
        });
        culinaryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                culinaryClicked = !culinaryClicked;
                if (culinaryClicked) {
                    culinaryCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    culinaryCard.setStrokeWidth(10);
                    culinaryCard.setCardElevation(2f);
                } else {
                    culinaryCard.setStrokeWidth(0);
                }
            }
        });

        sportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportClicked = !sportClicked;
                if (sportClicked) {
                    sportCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    sportCard.setStrokeWidth(10);
                    sportCard.setCardElevation(2f);
                } else {
                    sportCard.setStrokeWidth(0);

                }

            }
        });

        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicClicked = !musicClicked;
                if (musicClicked) {
                    musicCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    musicCard.setStrokeWidth(10);
                    musicCard.setCardElevation(2f);
                } else {
                    musicCard.setStrokeWidth(0);

                }

            }
        });

        marketingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marketingClicked = !marketingClicked;
                if (marketingClicked) {
                    marketingCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    marketingCard.setStrokeWidth(10);
                    marketingCard.setCardElevation(2f);
                } else {
                    marketingCard.setStrokeWidth(0);
                }
            }
        });

        designCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                designClicked = !designClicked;

                if (designClicked) {
                    designCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    designCard.setStrokeWidth(10);
                    designCard.setCardElevation(2f);
                } else {
                    designCard.setStrokeWidth(0);

                }


            }
        });

        gamingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamingClicked = !gamingClicked;
                if (gamingClicked) {
                    gamingCard.setStrokeColor(Color.parseColor("#00a9b6"));
                    gamingCard.setStrokeWidth(10);
                    gamingCard.setCardElevation(2f);
                } else {
                    gamingCard.setStrokeWidth(0);

                }


            }
        });

    }

}