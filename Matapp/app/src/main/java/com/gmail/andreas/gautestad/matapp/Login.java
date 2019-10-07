package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class Login extends AppCompatActivity {

    EditText brukernavn, passord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        brukernavn = (EditText)findViewById(R.id.brukernavn);
        passord = (EditText)findViewById(R.id.passord);
    }

public void OnLogin(View view) {
    String brukernavn = brukernavn.getText().toString();
    String passord = passord.getText().toString();
    String type = "login";

    Bakgrunn bakgrunnJobb = new Bakgrunn(this);
    bakgrunnJobb.execute(type, brukernavn, passord);
}
    @Override
    public void onResume(){
        super.onResume();


        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
        String sjekk = sharedPref.getString("nattmodus", null);

        if(Objects.equals(sjekk, "Sann")) {
            setContentView(R.layout.activity_login_dark);
        }
        else{
            setContentView(R.layout.activity_login);
        }

    }
}
