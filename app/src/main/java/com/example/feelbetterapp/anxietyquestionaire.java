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
public class anxietyquestionaire extends AppCompatActivity implements View.OnClickListener {

    TextView totalquestion;
    TextView question;
    Button yee,noo;
    Button submitbtn;
    int score1=0;
    int totalQuestion1 =anxietyquestionanswer.question1.length;
    int currentquestionindex1 =0;
    String selectedAnswer1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anxietyquestionaire);
        totalquestion =findViewById(R.id.total_question1);
        question =findViewById(R.id.question1);
        yee =findViewById(R.id.yes1);
        noo =findViewById(R.id.no1);
        submitbtn =findViewById(R.id.submit_btn1);

        yee.setOnClickListener(this);
        noo.setOnClickListener(this);
        submitbtn.setOnClickListener(this);

        totalquestion.setText("Total Questions:" +totalQuestion1);
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        yee.setBackgroundColor(Color.TRANSPARENT);
        noo.setBackgroundColor(Color.TRANSPARENT);


        Button clickedButton =(Button) view;
        if(clickedButton.getId()==R.id.submit_btn1){
            if(selectedAnswer1.equals(anxietyquestionanswer.choices1[currentquestionindex1][0])){
                score1++;
            }
            currentquestionindex1++;
            loadNewQuestion();
        }else{
            selectedAnswer1 = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLACK);
        }

    }
    void loadNewQuestion(){

        if(currentquestionindex1 ==totalQuestion1){
            finishquiz();
            return;
        }

        question.setText(anxietyquestionanswer.question1[currentquestionindex1]);
        yee.setText(anxietyquestionanswer.choices1[currentquestionindex1][0]);
        noo.setText(anxietyquestionanswer.choices1[currentquestionindex1][1]);
    }

    void finishquiz() {
        String anxietyStatus = " ";
        if (score1 <= 3) {
            anxietyStatus = "Low anxiety";
        } else if (score1 == 4 || score1 == 8) {
            anxietyStatus = "Below Average anxiety";
        } else if (score1 >= 9 && score1 <= 12) {
            anxietyStatus = "Average anxiety";
        } else if (score1 >= 13 && score1 <= 16) {
            anxietyStatus = "Above Average anxiety";
        } else if (score1 >= 17 && score1<=19)  {
            anxietyStatus = "High anxiety";
        }



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(anxietyStatus);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =new Intent(getApplicationContext(), depressionquestionaire.class);
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
