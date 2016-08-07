package com.example.todolistclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.todolistclient.HostingDB.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityRegistration extends AppCompatActivity  {



    final String Tag="Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(ActivityRegistration.this, MainActivity.class);
                                ActivityRegistration.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityRegistration.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, username, email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ActivityRegistration.this);
                queue.add(registerRequest);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(Tag,"ActivityRegistration onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(Tag,"ActivityRegistration onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(Tag,"ActivityRegistration onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(Tag,"ActivityRegistration onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(Tag,"ActivityRegistration onDestroy");
    }


}

