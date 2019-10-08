package com.gmail.andreas.gautestad.matapp.Food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gmail.andreas.gautestad.matapp.R;

public class Melk extends AppCompatActivity {

    private ListView matListen;

    private String [] matArray = {"Havregrøt", "Smoothie - grunnoppskrift", "Hveteboller uten melk og egg", "Pannekaker med syrnet melk", "Den perfekte eggerøren", "Frokostblanding med frukt og melk", "Yoghurt"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melk);

        matListen = (ListView) findViewById(R.id.searchFood);

        matListen.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matArray));

        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Uri url = Uri.parse("https://www.matprat.no/oppskrifter/familien/havregrot/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1) {

                    Uri url = Uri.parse("https://www.melk.no/Oppskrifter/Kalde-drikker/Smoothies/Smoothie-grunnoppskrift");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {

                    Uri url = Uri.parse("https://meny.no/oppskrifter/Bakst/Sot-gjarbakst/Hveteboller-uten-melk-og-egg/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {

                    Uri url = Uri.parse("https://www.tine.no/oppskrifter/middag-og-hovedretter/pannekaker/pannekaker-med-syrnet-melk");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {

                    Uri url = Uri.parse("http://www.prior.no/oppskrifter/den-perfekte-eggeroren/#beskrivelse");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {

                    Uri url = Uri.parse("https://www.roede.com/oppskrifter/frokostblanding-med-frukt-og-melk");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {

                    Uri url = Uri.parse("https://www.etkjokken.com/2019/04/hvordan-lage-hjemmelaget-yoghurt/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}


