package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class PickTopicActivity extends AppCompatActivity {

    MaterialCardView codingCard, artCard, businessCard, culinaryCard, sportCard;
    MaterialCardView musicCard, marketingCard, designCard, gamingCard;
    MaterialButton startJourneyBtn;


    boolean codingClicked, artClicked, businessClicked, culinaryClicked, sportClicked,
            musicClicked, marketingClicked, designClicked, gamingClicked = false;

    ArrayList<String> favoriteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_topic);

        favoriteList = new ArrayList<>();

        codingCard = findViewById(R.id.codingCard);
        artCard = findViewById(R.id.artCard);
        businessCard = findViewById(R.id.businessCard);
        culinaryCard = findViewById(R.id.culinaryCard);
        sportCard = findViewById(R.id.sportCard);
        musicCard = findViewById(R.id.musicCard);
        marketingCard = findViewById(R.id.marketingCard);
        designCard = findViewById(R.id.designCard);
        gamingCard = findViewById(R.id.gamingCard);
        startJourneyBtn = findViewById(R.id.startJourneyBtn);

        codingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codingClicked = !codingClicked;
                selectionToggle(codingClicked, codingCard);
            }
        });

        artCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artClicked = !artClicked;
                selectionToggle(artClicked, artCard);
            }
        });

        businessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessClicked = !businessClicked;
                selectionToggle(businessClicked, businessCard);
            }
        });
        culinaryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                culinaryClicked = !culinaryClicked;
                selectionToggle(culinaryClicked, culinaryCard);
            }
        });

        sportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportClicked = !sportClicked;
                selectionToggle(sportClicked, sportCard);
            }
        });

        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicClicked = !musicClicked;
                selectionToggle(musicClicked, musicCard);
            }
        });

        marketingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marketingClicked = !marketingClicked;
                selectionToggle(marketingClicked, marketingCard);
            }
        });

        designCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                designClicked = !designClicked;
                selectionToggle(designClicked, designCard);

            }
        });

        gamingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamingClicked = !gamingClicked;
                selectionToggle(gamingClicked, gamingCard);

            }
        });

        startJourneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PickTopicActivity.this, HomeActivity.class));
            }
        });
    }

    public void selectionToggle(boolean favItemClick, MaterialCardView favItemCard) {

        if (favItemClick) {
            Log.i("click", "selectionToggle: ");
            favoriteList.add("gaming");
            favItemCard.setStrokeColor(Color.parseColor("#00a9b6"));
            favItemCard.setStrokeWidth(10);
            favItemCard.setCardElevation(2f);
        } else {
            Log.i("unclick", "selectionToggle: ");
            favItemCard.setStrokeWidth(0);

            if (favoriteList.contains("gaming")) {
                favoriteList.remove("gaming");
            }

        }
    }

}