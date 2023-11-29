package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textLevel;
    TextView textRightAnswered;
    TextView textQuestion;

    Button buttonOp1;
    Button buttonOp2;
    Button buttonOp3;
    Button buttonOp4;

    int level = 0;
    int great = 0;
    int rightAnswer = 0;
    String realOperation = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        textLevel = findViewById(R.id.textQuestionNumber);
        textRightAnswered = findViewById(R.id.textRightAnswered);
        textQuestion = findViewById(R.id.textQuestion);

        buttonOp1 = findViewById(R.id.buttonOption1);
        buttonOp2 = findViewById(R.id.buttonOption2);
        buttonOp3 = findViewById(R.id.buttonOption3);
        buttonOp4 = findViewById(R.id.buttonOption4);

        textLevel.setText("Q  :  " + level + " / 10");
        textRightAnswered.setText("RC  : " + great + " / 10");

        if (level < 10) {
            getARandomQuestion();
        }
    }


    @SuppressLint("SetTextI18n")
    private void getARandomQuestion() {

        buttonOp1.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp2.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp3.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp4.setBackgroundResource(R.drawable.buttons_option_bg);

        int firstNumber = new Random().nextInt(20);
        int secondNumber = new Random().nextInt(20);

        int operation = new Random().nextInt(3) + 1;

        int optionA = new Random().nextInt(100);
        int optionB = new Random().nextInt(100);
        int optionC = new Random().nextInt(100);

        if (operation == 1) {
            realOperation = "+";
            rightAnswer = firstNumber + secondNumber;
            textQuestion.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
        } else {
            if (operation == 2) {
                realOperation = "*";
                rightAnswer = firstNumber * secondNumber;
                textQuestion.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
            } else {
                realOperation = "-";
                if (firstNumber < secondNumber) {
                    rightAnswer = secondNumber - firstNumber;
                    textQuestion.setText(secondNumber + " " + realOperation + " " + firstNumber + " = ?");
                } else {
                    rightAnswer = firstNumber - secondNumber;
                    textQuestion.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
                }
            }
        }

        int position = new Random().nextInt(4) + 1;

        if (position == 1) {
            buttonOp1.setText("" + rightAnswer);
            buttonOp2.setText("" + optionA);
            buttonOp3.setText("" + optionB);
            buttonOp4.setText("" + optionC);
        } else {
            buttonOp1.setText("" + optionA);
            if (position == 2) {
                buttonOp2.setText("" + rightAnswer);
                buttonOp3.setText("" + optionB);
                buttonOp4.setText("" + optionC);
            } else {
                buttonOp2.setText("" + optionB);
                if (position == 3) {
                    buttonOp3.setText("" + rightAnswer);
                    buttonOp4.setText("" + optionC);
                } else {
                    buttonOp3.setText("" + optionC);
                    buttonOp4.setText("" + rightAnswer);
                }
            }
        }


        buttonOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonOp1.getText().equals(""+rightAnswer)){
                    buttonOp1.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    textRightAnswered.setText("RC  :" + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    buttonOp1.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10){
                            getARandomQuestion();
                        }else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("RC", great);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000);
            }
        });

        buttonOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonOp2.getText().equals(""+rightAnswer)){
                    buttonOp2.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    textRightAnswered.setText("RC  :" + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    buttonOp2.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10){
                            getARandomQuestion();
                        }else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("RC", great);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000);
            }
        });

        buttonOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonOp3.getText().equals(""+rightAnswer)){
                    buttonOp3.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    textRightAnswered.setText("RC  :" + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    buttonOp3.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10){
                            getARandomQuestion();
                        }else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("RC", great);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000);
            }
        });

        buttonOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonOp4.getText().equals(""+rightAnswer)){
                    buttonOp4.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    textRightAnswered.setText("RC  :" + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel.setText("Q  :  " + level + " / 10");
                    buttonOp4.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10){
                            getARandomQuestion();
                        }else {
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("RC", great);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000);
            }
        });
    }
}