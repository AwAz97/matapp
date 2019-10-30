package com.gmail.andreas.gautestad.matapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;


/**
 * <p>Finnoppskrift klasse, for å finne ingrediensene</p>
 * @author Terje bakken, Andreas Gautestad, Nick Becker
 * */

public class FinnOppskrift extends AppCompatActivity {

    //Setter inn array for list.
    private ListView matListen;
    private String [] matArray = {"Agurk", "Tomat", "Potet", "Kjøttdeig", "Eple", "Mais", "Melk"};
    SharedPreferences ingrediens = getApplicationContext().getSharedPreferences("loginData", MODE_PRIVATE);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finn_oppskrift);



        //Henter id fra activity_finn_oppskrift
        matListen = (ListView) findViewById(R.id.searchFood);

        matListen.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matArray));

        //Item til hvilken posisjon. Går til ny aktivitet
        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent myIntent = new Intent(FinnOppskrift.this, OppskriftListe.class);
                    checkPos(position);
                    startActivity(myIntent);
                }

                if (position == 1) {

                    Intent myIntent = new Intent(FinnOppskrift.this, OppskriftListe.class);
                    checkPos(position);
                    startActivity(myIntent);
                }

                if (position == 2) {

                    Intent myIntent = new Intent(FinnOppskrift.this, OppskriftListe.class);
                    checkPos(position);
                    startActivity(myIntent);
                }

                if (position == 3) {

                    Intent myIntent = new Intent(FinnOppskrift.this, OppskriftListe.class);
                    checkPos(position);
                    startActivity(myIntent);
                }

                if (position == 4) {

                    Intent myIntent = new Intent(FinnOppskrift.this, OppskriftListe.class);
                    checkPos(position);
                    startActivity(myIntent);
                }

                if (position == 5) {

                    Intent myIntent = new Intent(FinnOppskrift.this, OppskriftListe.class);
                    checkPos(position);
                    startActivity(myIntent);
                }

                if (position == 6) {

                    Intent myIntent = new Intent(FinnOppskrift.this, OppskriftListe.class);
                    checkPos(position);
                    startActivity(myIntent);
                }
            }
        });
    }
    //Endrer layout basert på dark_state sin verdi.
    @Override
    public void onResume(){
        super.onResume();

        SharedPreferences blackings = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkstate = blackings.getBoolean("dark_mode", false);
        if (darkstate) {
            LinearLayout currentLayout = (LinearLayout) findViewById(R.id.finnOppskrift);
            currentLayout.setBackgroundColor(Color.parseColor("#2B2626"));
        }
        else {
            LinearLayout currentLayout = (LinearLayout) findViewById(R.id.finnOppskrift);
            currentLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }

    public void checkPos(int i){

        SharedPreferences.Editor editor = ingrediens.edit();
        editor.putInt("ingrediens", i+1);
        editor.commit();

    }
}