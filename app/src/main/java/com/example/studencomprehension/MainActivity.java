package com.example.studencomprehension;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView registersText;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registersText= findViewById(R.id.registersText);
        btnRegister= findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener((view)->{
            Intent i= new Intent(this, NewRegister.class);
            startActivity(i);
            /*SharedPreferences sp= getSharedPreferences("list", MODE_PRIVATE);

            sp.edit().clear().apply();*/

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp= getSharedPreferences("list", MODE_PRIVATE);

        String registersTxt= sp.getString("users", "No hay registros");
        registersText.setText(registersTxt);


    }
}