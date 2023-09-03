package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
public class passwordactivity extends AppCompatActivity {

    EditText username;
    Button reset;
    DBuser DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordactivity);

        username = (EditText) findViewById(R.id.username_reset);
        reset = (Button) findViewById(R.id.btnreset);
        DB = new DBuser(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                Boolean checkuser =DB.checkusername(user);
                if(checkuser==true)
                {
                    Intent intent = new Intent(getApplicationContext(), resetactivity.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(passwordactivity.this, "User does not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
