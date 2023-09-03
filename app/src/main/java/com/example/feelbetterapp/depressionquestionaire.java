package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class depressionquestionaire extends AppCompatActivity  implements View.OnClickListener {

    TextView totalqsa;
    TextView qsa;
    Button yees, noo;
    Button submitbutton;
    int scores=0;
    int totalqsa1 =depressionquestionanswer.question2.length;
    int currentquestionindex2 =0;
    String selectedAnswer2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depressionquestionaire);
        totalqsa =findViewById(R.id.total_question2);
        qsa =findViewById(R.id.question2);
        yees =findViewById(R.id.yes2);
        noo=findViewById(R.id.no2);
        submitbutton=findViewById(R.id.submit_btn2);


        yees.setOnClickListener(this);
        noo.setOnClickListener(this);
        submitbutton.setOnClickListener(this);

        totalqsa.setText("Total questions:" +totalqsa1);
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        yees.setBackgroundColor(Color.TRANSPARENT);
        noo.setBackgroundColor(Color.TRANSPARENT);

        Button clickedButton =(Button) view;
        if(clickedButton.getId()==R.id.submit_btn2){
            if(selectedAnswer2.equals(depressionquestionanswer.choices2[currentquestionindex2][0])){
                scores++;
            }
            currentquestionindex2++;
            loadNewQuestion();
        }else{
            selectedAnswer2 = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLACK);
        }

    }


    void loadNewQuestion(){
        if(currentquestionindex2 ==totalqsa1){
            finishquiz();
            return;
        }

        qsa.setText(depressionquestionanswer.question2[currentquestionindex2]);
        yees.setText(depressionquestionanswer.choices2[currentquestionindex2][0]);
        noo.setText(depressionquestionanswer.choices2[currentquestionindex2][1]);
    }

    void finishquiz() {
        String depressionStatus = " ";
        if (scores <= 2) {
            depressionStatus = "Low depression";
        } else if (scores == 3 || scores == 5) {
            depressionStatus = "Below Average depression";
        } else if (scores >= 6 && scores <= 9) {
            depressionStatus = "Average depression";
        } else if (scores >= 10 && scores <= 12) {
            depressionStatus = "Above Average depression";
        } else if (scores >= 13 && scores<=15)  {
            depressionStatus = "High depression";
        }



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(depressionStatus);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =new Intent(getApplicationContext(), links.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}



