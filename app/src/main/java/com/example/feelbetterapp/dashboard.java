package com.example.feelbetterapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {

    TextView dashboard;

    CardView card_home;
    CardView card_about;
    CardView card_therapy;
    CardView card_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        dashboard =(TextView) findViewById(R.id.dashboard);
        card_home =(CardView) findViewById(R.id.card_home);
        card_about=(CardView) findViewById(R.id.card_about);
        card_therapy =(CardView) findViewById(R.id.card_therapy);
        card_logout =(CardView) findViewById(R.id.card_logout);

        card_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),homepage.class);
                startActivity(intent);
            }
        });

        card_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),aboutus.class);
                startActivity(intent);
            }
        });

        card_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),ourtherapies.class);
                startActivity(intent);
            }
        });

        card_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(dashboard.this);
                builder.setTitle("Alert!!!!");
                builder.setMessage("Are you sure you want to exit");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.create().show();
            }
        });
    }
}


