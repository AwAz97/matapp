package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

    EditText Brukernavn, Passord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Brukernavn = (EditText)findViewById(R.id.brukernavn);
        Passord = (EditText)findViewById(R.id.passord);
    }

public void OnLogin(View view) {
    String brukernavn = Brukernavn.getText().toString();
    String passord = Passord.getText().toString();
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

    public void goToRegistrer(View view) {
        Intent i1 = new Intent(this, Registrer.class);
        startActivity(i1);
    }

    public void nextAct(){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
    }

    public class Bakgrunn extends AsyncTask<String,Void,String> {
        AlertDialog alertDialog;
        String utTxt;
        String Endpoint="https://web01.usn.no/~216728/api.php/";
        public void setString(String brukernavn, String passord){
            utTxt = Endpoint + "records/Spiller/?include=brukernavn,passord&filter=brukernavn,eq," +brukernavn + "&filter=passord,eq," + passord;
        }
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            StringBuilder response = new StringBuilder();
            try {
                //System.out.println("Hei");
                connection = (HttpURLConnection) new URL(utTxt).openConnection();
                connection.connect();

                int status = connection.getResponseCode();
                System.out.println("Status kode er: " + status);
                System.out.println("Hent Bruker: " + utTxt);
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

                System.out.println("Yeet1" + response.toString());
                return response.toString();
            }
        }


        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject bruker = new JSONObject();

                JSONArray brukerArray = bruker.getJSONArray("records");
                System.out.println("Bruker array: " + brukerArray.length());

                loginBruker(brukerArray);

            }
            catch (JSONException e){
                Log.e("Ugyldig JSON data", e.getMessage());
            }
            alertDialog.setMessage(result);
            alertDialog.show();
        }

        public void loginBruker(JSONArray brukere){
            if(brukere == null || brukere.length()<1){
                Toast.makeText(Login.this, "Feil brukernavn eller passord", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Login.this, "Du er logget inn", Toast.LENGTH_SHORT).show();
                nextAct();
            }
        }


    }

}
