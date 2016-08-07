package com.ticket.flight.flightapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Алексей Бут on 15.10.2015.
 */


public class Airports_Choice_Button extends AppCompatActivity implements View.OnClickListener {

    Button buttonback;

    private ListView list1 = null;
    private String airport_list[] = {"Воронеж" + "(VOZ)", "Москва" + "(DME)", "Санкт-Петербург" + "(LED)"};


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airports_choice_button);
        setTitle(R.string.app_choice);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        if (toolbar != null) {

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }






        list1 = (ListView) findViewById(R.id.list1);
        list1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, airport_list));
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", airport_list[position]);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Airports_Choice_Button.this, MainActivity.class);
        intent.putExtra("name", list1.getOnItemClickListener().toString()); //edTAirportchoice1.getText().toString()
        startActivity(intent);
    }


}

















