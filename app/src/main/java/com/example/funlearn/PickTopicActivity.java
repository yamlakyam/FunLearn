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

    MaterialCardView codingCard, financeCard, businessCard, lifestyleCard, healthCard;
    MaterialCardView musicCard, marketingCard, designCard, personalDevCard;
    MaterialButton startJourneyBtn;


    boolean codingClicked, financeClicked, businessClicked,lifestyleClicked, healthClicked,
            musicClicked, marketingClicked, designClicked, personalDevClicked = false;

    ArrayList<String> favoriteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_topic);

        favoriteList = new ArrayList<>();

        codingCard = findViewById(R.id.codingCard);
        financeCard = findViewById(R.id.artCard);
        businessCard = findViewById(R.id.businessCard);
        lifestyleCard = findViewById(R.id.culinaryCard);
        healthCard = findViewById(R.id.sportCard);
        musicCard = findViewById(R.id.musicCard);
        marketingCard = findViewById(R.id.marketingCard);
        designCard = findViewById(R.id.designCard);
        personalDevCard = findViewById(R.id.gamingCard);
        startJourneyBtn = findViewById(R.id.startJourneyBtn);

        codingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codingClicked = !codingClicked;
                selectionToggle(codingClicked, codingCard,"coding");
            }
        });

        financeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                financeClicked = !financeClicked;
                selectionToggle(financeClicked, financeCard,"finance");
            }
        });

        businessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessClicked = !businessClicked;
                selectionToggle(businessClicked, businessCard, "business");
            }
        });
        lifestyleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifestyleClicked = !lifestyleClicked;
                selectionToggle(lifestyleClicked, lifestyleCard,"lifestyle");
            }
        });

        healthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                healthClicked = !healthClicked;
                selectionToggle(healthClicked, healthCard,"health");
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

        personalDevCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personalDevClicked = !personalDevClicked;
                selectionToggle(personalDevClicked, personalDevCard,"personalDev");

            }
        });

        startJourneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PickTopicActivity.this, HomeActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("FAVORITE_LIST", Context.MODE_PRIVATE);
//        prefs.getStringSet("favorite_set",null);
        Log.i("string-set on resume", prefs.getStringSet("favorite_set", null) + "");
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
    protected void onPause() {
        super.onPause();

        Set<String> set = new HashSet<>();
        set.addAll(favoriteList);

        SharedPreferences prefs = getSharedPreferences("FAVORITE_LIST", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("favorite_set", set);
        editor.commit();

    }

}