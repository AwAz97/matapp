package com.gmail.andreas.gautestad.matapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class FinnOppskriftDark extends AppCompatActivity {

    ListView searchFood;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finn_oppskrift_dark);

        searchFood = (ListView) findViewById(R.id.searchFood);

        ArrayList<String> arrayFood = new ArrayList<>();
        arrayFood.addAll(Arrays.asList(getResources().getStringArray(R.array.myFood)));

        adapter = new ArrayAdapter<String>(
                FinnOppskriftDark.this,
                android.R.layout. simple_list_item_1,
                arrayFood
        );

        searchFood.setAdapter(adapter);
    }

    @Override
    public void onResume(){
        super.onResume();


        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.nattmodus), Context.MODE_PRIVATE);
        String sjekk = sharedPref.getString("nattmodus", null);

        if(sjekk.equals("Sann")) {
            setContentView(R.layout.activity_finn_oppskrift_dark);
        }
        else{
            setContentView(R.layout.activity_finn_oppskrift);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.searchFood);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }
}