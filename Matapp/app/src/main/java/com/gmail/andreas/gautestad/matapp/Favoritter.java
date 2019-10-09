package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import java.util.Objects;

public class Favoritter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritter);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences blackings = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkstate = blackings.getBoolean("dark_mode", false);
        if (darkstate) {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.favoritter);
            currentLayout.setBackgroundColor(Color.parseColor("#2B2626"));
        }
        else {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.favoritter);
            currentLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

    }
}