package com.example.studencomprehension;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Preparation extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private Button btnContinue2;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation);

        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        btnContinue2 = findViewById(R.id.btnContinue2);


        String name = getIntent().getExtras().getString("name");
        String code = getIntent().getExtras().getString("code");
        score = 0;


        checkBox1.setOnClickListener((v) -> {
            if (checkBox1.isChecked()) {
                checkBox3.setChecked(false);
                score += 1;
            } else {
                score -= 1;
            }

            if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                btnContinue2.setEnabled(true);
            } else {
                btnContinue2.setEnabled(false);
            }
        });

        checkBox2.setOnClickListener((v) -> {

            if (checkBox2.isChecked()) {
                checkBox3.setChecked(false);
                score += 3;
            } else {
                score -= 3;
            }

            if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                btnContinue2.setEnabled(true);
            } else {
                btnContinue2.setEnabled(false);
            }
        });

        checkBox3.setOnClickListener((v) -> {

            if (checkBox3.isChecked()) {
                score = 0;
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
            }

            if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                btnContinue2.setEnabled(true);
            } else {
                btnContinue2.setEnabled(false);
            }
        });

        btnContinue2.setOnClickListener( (v) -> {
                    Intent i = new Intent(this, Autoevaluation.class);
                    i.putExtra("name", name);
                    i.putExtra("code", code);
                    i.putExtra("score", ""+score);
                    startActivity(i);
                    finish();
                }
        );
    }


}
