package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onResume(){
        super.onResume();


        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
        String sjekk = sharedPref.getString("nattmodus", null);

        if(sjekk.equals("Sann")) {
            setContentView(R.layout.activity_login_dark);
        }
        else{
            setContentView(R.layout.activity_login);
        }

    }
}
