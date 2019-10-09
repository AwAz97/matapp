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
        darkmode = (Switch)findViewById(R.id.darkmode);

        nattmodus = (CheckBox) findViewById(R.id.checkBox);

        nattmodus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Context context = getApplicationContext();
                    SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
                    System.out.println(sharedPref);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    System.out.println(editor);
                    editor.putString("nattmodus", "Sann");
                    editor.apply();
                    System.out.println("Sann");
                } else {
                    Context context = getApplicationContext();
                    SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
                    System.out.println(sharedPref);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    System.out.println(editor);
                    editor.putString("nattmodus", "falsk");
                    editor.apply();
                    System.out.println("Falsk");
                }
            }
        });

        if (savedInstanceState != null) {
            Context context = getApplicationContext();
            SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
            String sjekk = sharedPref.getString("nattmodus", null);

            if (Objects.equals(sjekk, "Sann")) {
                nattmodus.setChecked(true);
                System.out.println("SATT AN TE SANN");
            } else {
                nattmodus.setChecked(false);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
        String sjekk = sharedPref.getString("nattmodus", null);

        if (Objects.equals(sjekk, "Sann")) {
            nattmodus.setChecked(true);
            System.out.println("SATT AN TE SANN");
        } else {
            nattmodus.setChecked(false);

        SharedPreferences blackings = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkstate = blackings.getBoolean("dark_mode", false);
        if (!darkstate) {
            darkmode.setChecked(false);
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
