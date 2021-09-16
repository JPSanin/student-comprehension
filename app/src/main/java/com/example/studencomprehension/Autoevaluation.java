package com.example.studencomprehension;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Autoevaluation extends AppCompatActivity {

    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;

    private Button btnFinish;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoevaluation);

        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        btnFinish = findViewById(R.id.btnFinish);

        String name = getIntent().getExtras().getString("name");
        String code = getIntent().getExtras().getString("code");
        score = Integer.parseInt(getIntent().getExtras().getString("score"));


        checkBox4.setOnClickListener((v) -> {
            if (checkBox4.isChecked()) {
                checkBox6.setChecked(false);
                score += 3;
            } else {
                score -= 3;
            }

            if (checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()) {
                btnFinish.setEnabled(true);
            } else {
                btnFinish.setEnabled(false);
            }
        });

        checkBox5.setOnClickListener((v) -> {

            if (checkBox5.isChecked()) {
                checkBox6.setChecked(false);
                score += 3;
            } else {
                score -= 3;
            }

            if (checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()) {
                btnFinish.setEnabled(true);
            } else {
                btnFinish.setEnabled(false);
            }
        });

        checkBox6.setOnClickListener((v) -> {

            if (checkBox6.isChecked()) {
                if (checkBox4.isChecked()) {
                    score -= 3;
                }
                if (checkBox5.isChecked()) {
                    score -= 3;
                }
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
            }

            if (checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()) {
                btnFinish.setEnabled(true);
            } else {
                btnFinish.setEnabled(false);
            }
        });


        btnFinish.setOnClickListener((v) -> {
                    //Users
                    SharedPreferences sp = getSharedPreferences("list", MODE_PRIVATE);

                    String registersTxt = sp.getString("users", "No hay registros");

                    if (registersTxt.equals("No hay registros")) {
                        registersTxt = name + " " + score + "\n";
                    } else {
                        registersTxt += name + " " + score + "\n";
                    }
                    sp.edit().putString("users", registersTxt).apply();

                    //Codes
                    String codesString = sp.getString("codes", "empty");
                    if (codesString.equals("empty")) {
                        codesString = code + ",";
                    } else {
                        codesString += code + ",";
                    }
                    sp.edit().putString("codes", codesString).apply();
                    finish();
                }
        );

    }
}