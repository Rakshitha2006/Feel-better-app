package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class feedback extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView nulltext;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ratingBar =findViewById(R.id.ratingbarid);
        nulltext =findViewById(R.id.textnull);
        button =findViewById(R.id.btnsend);

        nulltext.setText("Value:" +ratingBar.getProgress());

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                nulltext.setText("Value:" +rating );
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(feedback.this, "Feedback submitted successfully!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}