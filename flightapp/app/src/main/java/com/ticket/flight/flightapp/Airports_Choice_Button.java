package com.ticket.flight.flightapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Алексей Бут on 15.10.2015.
 */
public class Airports_Choice_Button extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airports_choice_button);
        ListView listView = (ListView) findViewById(R.id.listView);
        final String[] airports_list = new String[]{
                "Воронеж" + "(VOZ)", "Москва" + "(Любой)", "Санкт-Петербург" + "(LED)"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, airports_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;



            }
        });
    }
    public void Click(View view) {
        Intent intent = new Intent(Airports_Choice_Button.this, Activity.class);
        startActivity(intent);
    }
}














