package com.example.todolistclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.todolistclient.HostingDB.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    final String Tag="Lifecycle";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final TextView withoutRegistration = (TextView) findViewById(R.id.withoutRegistration);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView11 = (TextView) findViewById(R.id.textView11);
        final Button bSignIn = (Button) findViewById(R.id.bSignIn);
        withoutRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.withoutRegistration:
                        Intent gotoList = new Intent(MainActivity.this, ActivityPurchaseAdd.class);
                        startActivity(gotoList);
                        break;
                }
            }
        });



        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.tvRegisterLink:
                        Intent registerIntent = new Intent(MainActivity.this, ActivityRegistration.class);
                        MainActivity.this.startActivity(registerIntent);
                        break;


                }
            }
        });

        bSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String name = jsonResponse.getString("name");
                                String username =jsonResponse.getString("username");
                                String email = jsonResponse.getString("email");


                                Intent intent = new Intent(MainActivity.this, ActivityAuthorization.class);
                                intent.putExtra("name", name);
                                intent.putExtra("username", username);
                                intent.putExtra("email", email);

                                MainActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Ошибка авторизациии")
                                        .setNegativeButton("Повторить", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };




                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });





    }




    @Override
    protected void onStart(){
        super.onStart();
        Log.d(Tag,"MainActivity onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(Tag,"MainActivity onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(Tag,"MainActivity onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(Tag,"MainActivity onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(Tag,"MainActivity onDestroy");
    }

}
