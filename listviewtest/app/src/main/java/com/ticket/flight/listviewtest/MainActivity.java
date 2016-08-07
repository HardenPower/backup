package com.ticket.flight.listviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edTAirportchoice1;
    Button button1;

    TextView text2;
    public static final int REQUEST_LIST = 1;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);


        edTAirportchoice1 = (EditText) findViewById(R.id.edTAirportchoice1);
        edTAirportchoice1.setOnClickListener(this);


        text2 = (TextView) findViewById(R.id.text2);
    }


    public void onClick(View v) {

        Intent intent = new Intent(this, ListActivity.class);
        startActivityForResult(intent, REQUEST_LIST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_LIST:
                    if (data == null) {
                        return;
                    } String name = data.getStringExtra("name");
                    edTAirportchoice1.setText(name);
                    break;
                default:
                    break;

            }

        }

    }
}






