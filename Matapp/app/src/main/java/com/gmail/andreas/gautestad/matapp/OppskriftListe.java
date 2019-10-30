package com.gmail.andreas.gautestad.matapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.usb.UsbEndpoint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class OppskriftListe extends AppCompatActivity {

    private ListView matListen;
    private String [] matArray;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oppskrifter);

        matListen = findViewById(R.id.oppskrifter);

        //Her kommer innlegging i arrayet, for så å legge det til i listView


    }


    //Indreklasse for å hgente ut oppskrifter fra API
    class HentOppskrift extends AsyncTask<String , String , String> {
        private String ENDPOINT = "https://web01.usn.no/~216728/api.php/records/";
        SharedPreferences loginData = getSharedPreferences("ingrediens", MODE_PRIVATE);
        int ingrediens = loginData.getInt("ingrediens", 0);

        private String hentOppskrift = ENDPOINT + "oppskrift/?include=oppNavn,oppLink&filter=ingId," + ingrediens;

        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            StringBuilder response = new StringBuilder();
            try {
                connection = (HttpURLConnection) new URL(hentOppskrift).openConnection();
                connection.connect();

                int status = connection.getResponseCode();
                if (status == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                }
            } catch (MalformedURLException e) { e.printStackTrace(); }
            catch (IOException e) { e.printStackTrace(); }
            catch (Exception e) { e.printStackTrace(); }
            finally {

                if(connection != null)
                    connection.disconnect();

                return response.toString();
            }
        }

        @Override
        protected void onPostExecute(String resultat) {
            try {
                JSONObject oppskrift = new JSONObject(resultat);

                JSONArray oppskriftArray = oppskrift.getJSONArray("records");

                addOppskrift(oppskriftArray);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        public void addOppskrift(JSONArray oppskrifter){
            try {
                for(int i  = 0; i < oppskrifter.length();i++){
                    if (oppskrifter != null && oppskrifter.length() > 0) {

                        Oppskrift oppskrift = new Oppskrift((JSONObject) oppskrifter.get(i));
                        matArray[i] = oppskrift.getNavn();
                        Uri url = Uri.parse(oppskrift.getLink());
                        Intent r = new Intent(Intent.ACTION_VIEW, url);
                        startActivityForResult(r, 0);

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
