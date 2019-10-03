package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
