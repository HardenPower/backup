package com.example.todolistclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivityPurchaseAdd extends AppCompatActivity implements View.OnClickListener{

    final String Tag = "lifecycle";
    Button pok;
    EditText editText5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_add);

        editText5 = (EditText) findViewById(R.id.editText5);


        pok = (Button) findViewById(R.id.pok);
        pok.setOnClickListener(this);

        Log.d(Tag,"ActivityPurchaseAdd создано");
    }
    @Override
    public void onClick(View view){

        Intent intent = new Intent(this,ActivityPurchaseScreen.class);
        intent.putExtra("name",editText5.getText().toString());
        startActivity(intent);


    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(Tag,"ActivityPurchaseAdd onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(Tag,"ActivityPurchaseAdd onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(Tag,"ActivityPurchaseAdd onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(Tag,"ActivityPurchaseAdd onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(Tag,"ActivityPurchaseAdd onDestroy");
    }
}
