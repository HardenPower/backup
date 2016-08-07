package com.example.todolistclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityAuthorization extends AppCompatActivity implements View.OnClickListener {


    EditText etName, etEmail, etUsername;
    Button bLogout, goList;
    final String Tag = "Lifecycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button bLogout = (Button) findViewById(R.id.bLogout);
        Button goList = (Button) findViewById(R.id.goList);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        TextView etUsername = (TextView) findViewById(R.id.etUsername);
        TextView etName = (TextView) findViewById(R.id.etName);
        TextView etEmail = (TextView) findViewById(R.id.etEmail);


        // Display user details
        String message = name + ", добро пожаловать";
        tvWelcomeMsg.setText(message);

        etName.setText(name);

        etUsername.setText(username);

        etEmail.setText(email);

        bLogout.setOnClickListener(this);
        goList.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.goList:
                Intent listIntent = new Intent(this, ActivityPurchaseAdd.class);
                startActivity(listIntent);
                break;
            case R.id.bLogout:
                Intent loginIntent = new Intent(this, MainActivity.class);
                startActivity(loginIntent);
                break;
        }
    }
}
















