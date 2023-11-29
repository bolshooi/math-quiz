package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    TextView textResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        textResult = findViewById(R.id.textResult);

        textResult.setText("Você acertou " + getIntent().getIntExtra("RC", 0) + " / 10");
    }
}