package com.gmail.andreas.gautestad.matapp;

import org.json.JSONException;
import org.json.JSONObject;

//Klasse for å opprette objekter utifra API respons
public class Bruker {
    String brukernavn, passord, email;
    static final String TABELL_NAVN = "Bruker";
    static final String KOL_Navn = "brukernavn";
    static final String KOL_Email = "email";
    static final String KOL_Passord = "passord";

    public Bruker(String brukernavn, String passord, String email) {
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.email = email;

    }


    public JSONObject toJSONObject() {
        JSONObject bruker = new JSONObject();
        try {
            bruker.put(KOL_Navn, this.brukernavn);
            bruker.put(KOL_Email, this.email);
            bruker.put(KOL_Passord, this.passord);

        } catch (JSONException e) {
            return null;
        }
        return bruker;
    }

    public String toString() {
        return "Brukernavn : " + this.brukernavn + ", Email: " + this.email + ", Passord: " + this.passord;
    }
}
