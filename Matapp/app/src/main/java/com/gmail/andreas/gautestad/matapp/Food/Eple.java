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

public class Eple extends AppCompatActivity {

    private ListView matListen;

    private String [] matArray = {"Eple- og karamell-langpanne", "Smuldrepai med epler", "Krydderkokte epler", "Glutenfri eple-cobbler", "Kandiserte epler", "Bakt eple med luftig vaniljesaus", "Bestemors eplekake"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eple);

        matListen = (ListView) findViewById(R.id.searchFood);

        matListen.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matArray));

        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Uri url = Uri.parse("https://www.godt.no/oppskrift/8206/eple-og-karamell-langpanne");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1) {

                    Uri url = Uri.parse("https://www.matprat.no/oppskrifter/kos/smuldrepai-med-epler/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {

                    Uri url = Uri.parse("https://www.frukt.no/oppskrifter/dessert/krydderkokte-epler/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {

                    Uri url = Uri.parse("https://www.mills.no/oppskrift/melange/eple-cobbler/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {

                    Uri url = Uri.parse("https://www.dansukker.no/no/oppskrifter/kandiserte-epler.aspx");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {

                    Uri url = Uri.parse("https://www.tine.no/oppskrifter/desserter/frukt-og-bar/bakt-eple-med-luftig-vaniljesaus");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {

                    Uri url = Uri.parse("https://www.melk.no/Oppskrifter/Kaker/Frukt-og-baerkaker/Bestemors-eplekake");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}

