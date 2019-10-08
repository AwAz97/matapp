package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.os.Bundle;
import android.widget.CompoundButton;

import java.util.Objects;


public class Instillinger extends AppCompatActivity {

    CheckBox nattmodus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instillinger);

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

        }
    }


}
