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

public class Kjottdeig extends AppCompatActivity {

    private ListView matListen;

    private String [] matArray = {"Middagsgryte med kjøttdeig", "Kjøttdeig- og makaroniform", "Pastagrateng med kjøttdeig", "Løkpanne med kjøttdeig", "Krydret kjøttdeig med egg", "Moussaka med kjøttdeig", "Kjøttdeig, spinat og fetaost"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kjottdeig);

        matListen = (ListView) findViewById(R.id.searchFood);

        matListen.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matArray));

        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Uri url = Uri.parse("https://www.matprat.no/oppskrifter/rask/rask-middagsgryte-med-kjottdeig/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1) {

                    Uri url = Uri.parse("https://www.aperitif.no/oppskrifter/oppskrift/kjottdeig-og-makaroniform/69873");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {

                    Uri url = Uri.parse("https://meny.no/oppskrifter/Pasta/Pastagrateng-med-kjottdeig/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {

                    Uri url = Uri.parse("https://www.frukt.no/oppskrifter/smaretter/lokpanne/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {

                    Uri url = Uri.parse("https://www.etkjokken.com/2017/11/krydret-kjottdeig-med-egg/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {

                    Uri url = Uri.parse("https://kolonial.no/oppskrifter/1969-spoon-moussaka-med-kjottdeig/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {

                    Uri url = Uri.parse("https://joker.no/Oppskrifter/Kjottdeig-spinat-og-fetaost/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
