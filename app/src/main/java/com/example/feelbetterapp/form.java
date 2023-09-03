package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class form extends AppCompatActivity {

    Button sub;
    Button lo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        sub = (Button) findViewById(R.id.subform);
        lo = (Button) findViewById(R.id.sublogin);


        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), loginactivity.class);
                startActivity(intent);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(form.this, "form submitted successfully!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}