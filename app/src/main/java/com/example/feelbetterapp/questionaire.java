package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
public class questionaire extends AppCompatActivity implements View.OnClickListener {

    TextView total_question;
    TextView question;
    Button yes,no;
    Button submit_btn;
    int score=0;
    int totalQuestion =questionanswer.question.length;
    int currentquestionindex =0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);
        total_question =findViewById(R.id.total_question);
        question =findViewById(R.id.question);
        yes =findViewById(R.id.yes);
        no =findViewById(R.id.no);
        submit_btn =findViewById(R.id.submit_btn);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        submit_btn.setOnClickListener(this);

        total_question.setText("Total Questions:" +totalQuestion);
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        yes.setBackgroundColor(Color.TRANSPARENT);
        no.setBackgroundColor(Color.TRANSPARENT);


        Button clickedButton =(Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(questionanswer.choices[currentquestionindex][0])){
                score++;
            }
            currentquestionindex++;
            loadNewQuestion();
        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLACK);
        }

    }
    void loadNewQuestion(){

        if(currentquestionindex ==totalQuestion){
            finishquiz();
            return;
        }

        question.setText(questionanswer.question[currentquestionindex]);
        yes.setText(questionanswer.choices[currentquestionindex][0]);
        no.setText(questionanswer.choices[currentquestionindex][1]);
    }

    void finishquiz() {
        String stressStatus = " ";
        if (score <= 2) {
            stressStatus = "Low stress";
        } else if (score == 3 || score == 4) {
            stressStatus = "Below Average stress";
        } else if (score >= 5 && score <= 8) {
            stressStatus = "Average stress";
        } else if (score >= 9 && score <= 11) {
            stressStatus = "Above Average stress";
        } else if (score >= 12 && score<=14)  {
            stressStatus = "High stress";
        }



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(stressStatus);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =new Intent(getApplicationContext(), anxietyquestionaire.class);
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