package com.sales.tevin.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Toast.makeText(this,intent.getStringExtra("username"), Toast.LENGTH_SHORT).show();


        ListView listView = (ListView)findViewById(R.id.listView);
        final ArrayList<String> friends = new ArrayList<String>();

        friends.add("Currency Converter");
        friends.add("bravo");
        friends.add("charlie");
        friends.add("Current Location Info");
        friends.add("Map Location");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, friends);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(l == 0){
                    Intent intent = new Intent(getApplicationContext(), CurrencyConverter.class);
                    startActivity(intent);
                }
                if(l == 1 || l == 2) {
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    intent.putExtra("name", friends.get(i));
                    startActivity(intent);
                }
                if(l == 3){
                    Intent intent = new Intent(getApplicationContext(), CurrentLocation.class);
                    startActivity(intent);
                }
                if(l == 4){
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }


    public void goToMapActivity(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);

    }


}
