package com.example.funlearn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import com.example.funlearn.Util.PreferenceKeys;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetPrefernce();
        isFirstLogin();

    }

    @Override
    public void onClick(View v) {
        //    startActivity();
//    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void isFirstLogin() {

//        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
         SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstLogin = preferences.getBoolean(PreferenceKeys.FIRST_LOGIN, true);

        if (isFirstLogin) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("We have noticed this is your first login. Make sure to select your preferred topics in the setting screen");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.i("TAG", "onClick: closing dialog");

                    editor = preferences.edit();
                    editor.putBoolean(PreferenceKeys.FIRST_LOGIN, false);
                    editor.commit();
                    dialog.dismiss();
                }
            });
            alertDialogBuilder.setIcon(R.drawable.briefcase);
            alertDialogBuilder.setTitle(" ");
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }

    public void resetPrefernce() {
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstLogin = preferences.getBoolean(PreferenceKeys.FIRST_LOGIN, true);
        editor = preferences.edit();
        editor.putBoolean(PreferenceKeys.FIRST_LOGIN, true);
    }


}