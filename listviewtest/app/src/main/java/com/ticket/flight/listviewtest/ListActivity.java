package com.ticket.flight.listviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Алексей Бут on 17.01.2016.
 */
public class ListActivity extends MainActivity implements View.OnClickListener {
    EditText edTAirportchoice1;
    TextView text1;
    TextView text2;
    private ListView list1 = null;
    private String s1[] = {"google", "yahoo", "bing"};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);



        list1 = (ListView) findViewById(R.id.list1);

        list1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, s1));
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", s1[position]);
                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });


        }

    public void onClick(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        intent.putExtra("name", list1.getOnItemClickListener().toString());
        startActivity(intent);

    }
}

