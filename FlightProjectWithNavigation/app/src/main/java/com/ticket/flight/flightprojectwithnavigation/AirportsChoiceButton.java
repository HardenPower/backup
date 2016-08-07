package com.ticket.flight.flightprojectwithnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



/* * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AirportsChoiceButton.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AirportsChoiceButton#newInstance} factory method to
 * create an instance of this fragment.*/


public class AirportsChoiceButton extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_airports_choice_button);
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
        Intent intent = new Intent(AirportsChoiceButton.this, Activity.class);
        startActivity(intent);
    }
}

