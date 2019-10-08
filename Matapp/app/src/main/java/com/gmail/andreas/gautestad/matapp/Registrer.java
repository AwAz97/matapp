package com.gmail.andreas.gautestad.matapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Objects;

public class Registrer extends AppCompatActivity {

    static final String PHP_CRUD_API_HTTP_OK = "1";


    public void RegBruker(View view) {
        TextView navn = findViewById(R.id.sNavn);
        TextView mail = findViewById(R.id.sMail);
        TextView pass = findViewById(R.id.sPass);

        Bruker bruker = new Bruker(navn.getText().toString(), pass.getText().toString(), mail.getText().toString());
        RegBruker regBruker = new RegBruker(bruker);
        System.out.println("Funka1");
        regBruker.execute();
    }

    class RegBruker extends AsyncTask<String, String, String> {

        String utTxt;
        public final String Endpoint = "https://web01.usn.no/~216728/api.php";

        private Bruker bruker;

        RegBruker(Bruker bruker) {
            this.bruker = bruker;
        }


        @Override
        protected String doInBackground(String... params) {
            String insert_URI = "https://web01.usn.no/~216728/api.php/" + "records/brukere";
            HttpURLConnection connection = null;
            try {
                URL insertURL = new URL(insert_URI);
                connection = (HttpURLConnection) insertURL.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setChunkedStreamingMode(0);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                System.out.println("Funka2");
                connection.connect();
                System.out.println("Funka3");
                JSONObject jsonBruker = bruker.toJSONObject();
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(jsonBruker.toString());
                out.close();
                int status = connection.getResponseCode();
                System.out.println("Funka4" + status);
                if (status == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                    StringBuilder response = new StringBuilder();
                    while (reader.readLine() != null)
                        response = response.append(reader.readLine());
                    reader.close();
                    System.out.println("Responsen er: " + response.toString());
                    if (response.toString().equals(PHP_CRUD_API_HTTP_OK)) return ("ok");
                    else return ("not ok1");
                } else {
                    return ("not ok2");
                }

            } catch (ProtocolException e) {
            Log.e("Protocol error", e.getMessage() + "  ");
            e.printStackTrace();
            return ("not ok3");
        } catch(MalformedURLException e){
            Log.e("MalfromedURL error", e.getMessage());
            e.printStackTrace();
            return ("not ok4");
        } catch(IOException e){
            Log.e("IOE error", e.getMessage());
            e.printStackTrace();
            return ("not ok5");
            } finally {
                if (connection != null)
                connection.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println(result);
            if (result.equals("ok")) {
                System.out.println("Funka5");
            } else {
                System.out.println("Feil");
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

    }

    public void goToMainActivity(View view) {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2);
    }
}
