package com.gmail.andreas.gautestad.matapp;

import android.content.Context;
import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Bakgrunn extends AsyncTask<String,Void,Void> {
    Context context;
    BakgrunnJobb (Context ctx){
        context = ctx;
    }
    @Override
    protected Void doInBackground(String... voids) {
        String type = params[0];
        String login_url = "https://web01.usn.no/~216728/api.php/records/brukere/?include=brukernavn,passord&filter=passord,eq" + passordVar + "&filter=brukernavn,eq," + brukernavnVar;
        if(type.equals("login")) {
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                a.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
    @Override
    onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
