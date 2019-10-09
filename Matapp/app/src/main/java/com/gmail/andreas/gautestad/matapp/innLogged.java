package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.Objects;


public class innLogged extends AppCompatActivity {

    boolean nightMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume(){
        super.onResume();


        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
        String sjekk = sharedPref.getString("nattmodus", null);

        if(Objects.equals(sjekk, "Sann")) {
            setContentView(R.layout.activity_inn_logged_dark);
        }
        else{
            setContentView(R.layout.activity_inn_logged);
        }

    }

    public void goToFinnOppskrift(View view) {
        Intent i1 = new Intent(this, FinnOppskrift.class);
        startActivity(i1);
    }

    public void goToFavoritter(View view) {
        Intent i3 = new Intent(this, Favoritter.class);
        startActivity(i3);
    }

    public void goToInstillinger(View view) {
        Intent i4 = new Intent(this, Instillinger.class);
        startActivity(i4);
    }
}