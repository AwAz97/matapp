package com.gmail.andreas.gautestad.matapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.usb.UsbEndpoint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OppskriftListe extends AppCompatActivity {

    private ListView matListen;
    private String [] matArray = new String[10];
    SimpleAdapter oppskrift;
    ArrayList<Map<String,Object>> itemDataList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oppskrifter);
        matListen = findViewById(R.id.oppskrifter);

        //Her kommer innlegging i arrayet, for så å legge det til i listView
        HentOppskrift h = new HentOppskrift();
        System.out.println("TTTTTTT");
        h.execute();

        oppskrift = new SimpleAdapter(this,itemDataList,android.R.layout.simple_list_item_2,
                new String[]{"title","description"},new int[]{android.R.id.text1,android.R.id.text2});



    }


    //Indreklasse for å hgente ut oppskrifter fra API
    class HentOppskrift extends AsyncTask<String , String , String> {
        private String ENDPOINT = "https://web01.usn.no/~216728/api.php/records/";
        SharedPreferences ingrediens = getSharedPreferences("ingrediens", MODE_PRIVATE);
        int ingNr = ingrediens.getInt("ingrediens", 0);

        private String hentOppskrift = ENDPOINT + "oppskrifter/?include=oppNavn,oppLink&filter=ingId,eq," + ingNr;


        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            StringBuilder response = new StringBuilder();
            System.out.println("Sjekklink: " + hentOppskrift);
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
                        final String oppLink = oppskrift.getLink();


                        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                                Uri url = Uri.parse(oppLink);
                                Intent r = new Intent(Intent.ACTION_VIEW, url);
                                startActivity(r);

                            }
                        });
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for(int i =0; i < oppskrifter.length(); i++) {
                Map<String,Object> listItemMap = new HashMap<>();
                listItemMap.put("title", matArray[i]);
                itemDataList.add(listItemMap);
            }

            if (matArray!=null){
                matListen.setAdapter(oppskrift);
            }
        }
    }

}
