package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;



public class innLogged extends AppCompatActivity {

    boolean nightMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inn_logged);
    }
    //Endrer layout basert på dark_state sin verdi.
    @Override
    public void onResume(){
        super.onResume();

        SharedPreferences blackings = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkstate = blackings.getBoolean("dark_mode", false);
        if (darkstate) {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.innlogget);
            currentLayout.setBackgroundColor(Color.parseColor("#2B2626"));
        }
        else {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.innlogget);
            currentLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
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
    public void goToMainActivity(View view) {
        Intent i5 = new Intent(this, MainActivity.class);
        startActivity(i5);
    }
    public void goToInstillinger(View view) {
        Intent i4 = new Intent(this, Instillinger.class);
        startActivity(i4);
    }
}
