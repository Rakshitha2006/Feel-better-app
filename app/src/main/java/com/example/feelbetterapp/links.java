package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class links extends AppCompatActivity {

    TextView low;
    TextView belowavg;
    TextView avg;
    TextView aboveavg;
    TextView high;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        low = (TextView) findViewById(R.id.link1);
        belowavg = (TextView) findViewById(R.id.link2);
        avg =(TextView)findViewById(R.id.link3);
        aboveavg =(TextView) findViewById(R.id.link4);
        high =(TextView) findViewById(R.id.link5);

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),lowstress.class);
                startActivity(intent);
            }
        });


        belowavg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),belowavgstress.class);
                startActivity(intent);
            }
        });

        avg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),averagestress.class);
                startActivity(intent);
            }
        });



        aboveavg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),aboveaveragestress.class);
                startActivity(intent);
            }
        });

        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),highstress.class);
                startActivity(intent);
            }
        });



    }

}