package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.os.Bundle;
import android.widget.Switch;


public class Instillinger extends AppCompatActivity {
    Switch darkmode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instillinger);
        darkmode = (Switch) findViewById(R.id.darkmode);


    }
    //Endrer layout basert på dark_state sin verdi.
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences blackings = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkstate = blackings.getBoolean("dark_mode", false);
        if (!darkstate) {
            darkmode.setChecked(false);
            darkmode.setTextColor(Color.parseColor("#FFFFFF"));
        }
        if (darkstate) {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.instillinger);
            currentLayout.setBackgroundColor(Color.parseColor("#2B2626"));
        }
        else {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.instillinger);
            currentLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

    }

    //Lagrer dark_state i SharedReferences for å huske om switchen er av eller på og endrer andre sider sin bakgrunssfarge basert på dark_state sin verdi.
    public void darkmode(View view) {
        if (darkmode.isChecked()) {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.instillinger);
            currentLayout.setBackgroundColor(Color.parseColor("#2B2626"));
            SharedPreferences settings = getApplicationContext().getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("dark_mode", true);
            editor.commit();
        } else if (!darkmode.isChecked()){
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.instillinger);
            currentLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            SharedPreferences settings = getApplicationContext().getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("dark_mode", false);
            editor.commit();
        }
    }
}
