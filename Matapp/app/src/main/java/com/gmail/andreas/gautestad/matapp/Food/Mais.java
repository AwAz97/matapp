package com.gmail.andreas.gautestad.matapp.Food;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gmail.andreas.gautestad.matapp.FinnOppskrift;
import com.gmail.andreas.gautestad.matapp.R;

public class Mais extends AppCompatActivity {

    private ListView matListen;

    private String [] matArray = {"Maissuppe med baccon", "Kremet mais", "Grillet mais", "Quesadilla med kjottdeig og mais", "tomatsalat med mais", "Mais og chilisalsa", "Torskepinner med paprika og hvitløksmajones"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mais);

        matListen = (ListView) findViewById(R.id.searchFood);

        matListen.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matArray));

        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Uri url = Uri.parse("https://www.tine.no/oppskrifter/middag-og-hovedretter/supper/maissuppe-med-bacon");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1) {

                    Uri url = Uri.parse("https://www.godt.no/oppskrift/6944/kremet-mais");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {

                    Uri url = Uri.parse("https://www.bama.no/oppskrifter/grillet-mais/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {

                    Uri url = Uri.parse("https://www.matprat.no/oppskrifter/kos/quesadilla-med-kjottdeig-og-mais/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {

                    Uri url = Uri.parse("https://www.matoppskrift.no/oppskrift/tomatsalat-med-mais");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {

                    Uri url = Uri.parse("https://meny.no/oppskrifter/Gronnsaker/Mais-og-chilisalsa/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {

                    Uri url = Uri.parse("https://www.leroyseafood.com/no/smakfull-sjomat/oppskrifter/torskepinner-med-paprika-og-hvitloksmajones/");
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, url);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
