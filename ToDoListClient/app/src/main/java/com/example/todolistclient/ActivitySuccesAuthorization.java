package com.example.todolistclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ActivitySuccesAuthorization extends AppCompatActivity {
    final String Tag = "lifecycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_authorization);

        Log.d(Tag,"ActivitySuccesAuthorization создано");

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(Tag,"ActivitySuccesAuthorization onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(Tag,"ActivitySuccesAuthorization onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(Tag,"ActivitySuccesAuthorization onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(Tag,"ActivitySuccesAuthorization onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(Tag,"ActivitySuccesAuthorization onDestroy");
    }
}
