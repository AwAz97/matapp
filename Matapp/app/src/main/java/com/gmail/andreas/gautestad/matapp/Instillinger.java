package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.Objects;


public class Instillinger extends AppCompatActivity {
    Switch darkmode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instillinger);
        darkmode = (Switch) findViewById(R.id.darkmode);


    }

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
