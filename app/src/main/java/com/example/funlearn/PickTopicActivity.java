package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
                selectionToggle(codingClicked, codingCard,"coding");
            }
        });

        artCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artClicked = !artClicked;
                selectionToggle(artClicked, artCard,"art");
            }
        });

        businessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessClicked = !businessClicked;
                selectionToggle(businessClicked, businessCard, "business");
            }
        });
        culinaryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                culinaryClicked = !culinaryClicked;
                selectionToggle(culinaryClicked, culinaryCard,"culinary");
            }
        });

        sportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportClicked = !sportClicked;
                selectionToggle(sportClicked, sportCard,"sport");
            }
        });

        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicClicked = !musicClicked;
                selectionToggle(musicClicked, musicCard,"music");
            }
        });

        marketingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marketingClicked = !marketingClicked;
                selectionToggle(marketingClicked, marketingCard,"marketing");
            }
        });

        designCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                designClicked = !designClicked;
                selectionToggle(designClicked, designCard,"design");

            }
        });

        gamingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamingClicked = !gamingClicked;
                selectionToggle(gamingClicked, gamingCard,"gaming");

            }
        });

        startJourneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PickTopicActivity.this, HomeActivity.class));
            }
        });
    }

    public void selectionToggle(boolean favItemClick, MaterialCardView favItemCard, String favorite) {

        if (favItemClick) {
            Log.i("click", "selectionToggle: ");
            favoriteList.add(favorite);
            favItemCard.setStrokeColor(Color.parseColor("#00a9b6"));
            favItemCard.setStrokeWidth(10);
            favItemCard.setCardElevation(2f);
        } else {
            Log.i("unclick", "selectionToggle: ");
            favItemCard.setStrokeWidth(0);

            if (favoriteList.contains(favorite)) {
                favoriteList.remove(favorite);
            }

        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        Set<String> set = new HashSet<>();
        set.addAll(favoriteList);

        SharedPreferences prefs = getSharedPreferences("FAVORITE_LIST", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("favorite_set", set);
        editor.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = getSharedPreferences("FAVORITE_LIST", Context.MODE_PRIVATE);
//        prefs.getStringSet("favorite_set",null);
        Log.i("string-set", prefs.getStringSet("favorite_set", null) + "");


    }
}