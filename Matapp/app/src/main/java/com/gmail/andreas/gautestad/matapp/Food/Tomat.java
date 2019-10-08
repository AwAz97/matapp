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

public class Tomat extends AppCompatActivity {

    private ListView matListen;

    private String [] matArray = {"Bruschetta med tomat og basilikum", "Shakshuka (Tunisisk egg i tomatsaus)", "Tomat- og brødsalat ", "Spagetti med tomat", "Guacamole med tomat", "Bruschetta med tomater", "Halvtørkede tomater"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomat);

        matListen = (ListView) findViewById(R.id.searchFood);

        matListen.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matArray));

        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Uri url = Uri.parse("https://www.godt.no/oppskrift/4524/bruschetta-med-tomat-og-basilikum");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1) {

                    Uri url = Uri.parse("https://www.etkjokken.com/2016/04/shakshukah/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {

                    Uri url = Uri.parse("https://www.matprat.no/oppskrifter/gjester/tomat--og-brodsalat/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {

                    Uri url = Uri.parse("https://trinesmatblogg.no/recipe/spagetti-med-tomat-basilikum-og-parmesan/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {

                    Uri url = Uri.parse("https://www.bama.no/oppskrifter/guacamole-med-tomat/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {

                    Uri url = Uri.parse("https://www.frukt.no/oppskrifter/smaretter/bruschetta-med-tomater/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {

                    Uri url = Uri.parse("https://www.dansukker.no/no/oppskrifter/halvtoerkede-tomater.aspx");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
