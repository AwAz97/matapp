package com.gmail.andreas.gautestad.matapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.gmail.andreas.gautestad.matapp.Food.Agurk;
import com.gmail.andreas.gautestad.matapp.Food.Eple;
import com.gmail.andreas.gautestad.matapp.Food.Kjottdeig;
import com.gmail.andreas.gautestad.matapp.Food.Mais;
import com.gmail.andreas.gautestad.matapp.Food.Melk;
import com.gmail.andreas.gautestad.matapp.Food.Potet;
import com.gmail.andreas.gautestad.matapp.Food.Tomat;

import java.util.Objects;

public class FinnOppskrift extends AppCompatActivity {

    private ListView matListen;

    private String [] matArray = {"Mais", "Tomat", "Potet", "Kjøttdeig", "Eple", "Agurk", "Melk"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finn_oppskrift);



        matListen = (ListView) findViewById(R.id.searchFood);

        matListen.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matArray));

        matListen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent myIntent = new Intent(FinnOppskrift.this, Mais.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {

                    Intent myIntent = new Intent(FinnOppskrift.this, Tomat.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {

                    Intent myIntent = new Intent(FinnOppskrift.this, Potet.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {

                    Intent myIntent = new Intent(FinnOppskrift.this, Kjottdeig.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {

                    Intent myIntent = new Intent(FinnOppskrift.this, Eple.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {

                    Intent myIntent = new Intent(FinnOppskrift.this, Agurk.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {

                    Intent myIntent = new Intent(FinnOppskrift.this, Melk.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}