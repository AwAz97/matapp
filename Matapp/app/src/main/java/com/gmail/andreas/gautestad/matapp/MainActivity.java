package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    boolean nightMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getApplicationContext().getSharedPreferences("settings", MODE_PRIVATE);
    }
    //Endrer layout basert på dark_state sin verdi.
    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences blackings = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkstate = blackings.getBoolean("dark_mode", false);
        if (darkstate) {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.main);
            currentLayout.setBackgroundColor(Color.parseColor("#2B2626"));
        }
        else {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.main);
            currentLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }



    }

    public void goToFinnOppskrift(View view) {
        Intent i1 = new Intent(this, FinnOppskrift.class);
        startActivity(i1);
    }

    public void goToLogin(View view) {
        Intent i2 = new Intent(this, Login.class);
        startActivity(i2);
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
