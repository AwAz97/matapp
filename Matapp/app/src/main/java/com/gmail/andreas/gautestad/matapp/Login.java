package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;

public class Login extends AppCompatActivity {
TextView login;
EditText brukernavn;
EditText passord;
TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(TextView)findViewById(R.id.Login);
        brukernavn=(EditText)findViewById(R.id.brukernavn);
        passord=(EditText)findViewById(R.id.passord);
        textView5=(TextView)findViewById(R.id.textView5);
    }

    public void OnLogin(View view) {
        EditText Brukernavn = findViewById(R.id.brukernavn);
        EditText Passord = findViewById(R.id.passord);
        String brukernavn = Brukernavn.getText().toString();
        String passord = Passord.getText().toString();

        SjekkBruker bruker = new SjekkBruker();
        bruker.setString(brukernavn, passord);
        bruker.execute();

}
    @Override
    public void onResume(){
        super.onResume();

        SharedPreferences blackings = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkstate = blackings.getBoolean("dark_mode", false);
        if (darkstate) {
            login.setTextColor(Color.parseColor("#FFFFFF"));
            brukernavn.setTextColor(Color.parseColor("#FFFFFF"));
            brukernavn.setHintTextColor(Color.parseColor("#FFFFFF"));
            passord.setTextColor(Color.parseColor("#FFFFFF"));
            passord.setHintTextColor(Color.parseColor("#FFFFFF"));
            textView5.setTextColor(Color.parseColor("#FFFFFF"));
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.innlogg);
            currentLayout.setBackgroundColor(Color.parseColor("#2B2626"));
        }
        else {
            ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.innlogg);
            currentLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }


    }

    public void goToRegistrer(View view) {
        Intent i1 = new Intent(this, Registrer.class);
        startActivity(i1);
    }

    public void nextAct(){
        Intent next = new Intent(this, innLogged.class);
        startActivity(next);
    }

   class SjekkBruker extends AsyncTask<String, String, String> {

       String utTxt;
       public final String Endpoint = "https://web01.usn.no/~216728/api.php/";

       public void setString(String brukernavn, String passord) {
           utTxt = Endpoint + "records/brukere/?include=brukernavn,passord&filter=brukernavn,eq," + brukernavn + "&filter=passord,eq," + passord;
           //System.out.println("Sjekk link: " + utTxt);

       }

       @Override
       protected String doInBackground(String... params) {
           HttpURLConnection connection = null;
           StringBuilder response = new StringBuilder();
           try {
               //System.out.println("Hei");
               connection = (HttpURLConnection) new URL(utTxt).openConnection();
               System.out.println("Hent Bruker: " + utTxt);
               connection.connect();

               int status = connection.getResponseCode();
               System.out.println("Status kode er: " + status);

               if (status == HttpURLConnection.HTTP_OK) {
                   BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                   String line;
                   while ((line = reader.readLine()) != null) {
                       //response.append(reader.readLine())
                       response.append(line);
                       System.out.println("Appender til response: " + line);
                   }

               }
           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (Exception e) {
               e.printStackTrace();
           } finally {

               if (connection != null)
                   connection.disconnect();

               System.out.println("Yeet1 : " + response.toString());
               return response.toString();
           }
       }


       @Override
       protected void onPostExecute(String result) {
           try {
               Log.i("Debug result", " " + result);
               JSONObject bruker = new JSONObject(result);

               JSONArray brukerArray = bruker.getJSONArray("records");
               System.out.println("Bruker array: " + brukerArray.length());

               loginBruker(brukerArray);

           } catch (JSONException e) {
               Log.e("Ugyldig JSON data", e.getMessage());
               e.printStackTrace();
           }
       }

       public void loginBruker(JSONArray brukere) {
           if (brukere == null || brukere.length() < 1) {
               Toast.makeText(Login.this, "Feil brukernavn eller passord", Toast.LENGTH_SHORT).show();
           } else {
               Toast.makeText(Login.this, "Du er logget inn", Toast.LENGTH_SHORT).show();
               nextAct();
           }
       }
   }
}
