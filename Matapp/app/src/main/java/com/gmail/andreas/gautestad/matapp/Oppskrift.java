package com.gmail.andreas.gautestad.matapp;

import org.json.JSONObject;

//Klasse for å opprette objekt av oppskrifter
public class Oppskrift {
    private String oppNavn;
    private String oppLink;


    public Oppskrift(JSONObject oppskrift){
        this.oppNavn = oppskrift.optString("oppNavn");
        this.oppLink = oppskrift.optString("oppLink");

    }

    public String getLink(){
        return this.oppLink;
    }

    public void setLink(String link){
        this.oppLink = link;
    }

    public String getNavn(){
        return this.oppNavn;
    }

    public void setNavn(String navn){
        this.oppNavn = navn;
    }
}

