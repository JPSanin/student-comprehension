package com.example.studencomprehension;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class NewRegister extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextCode;

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        editTextName= findViewById(R.id.editTextName);
        editTextCode= findViewById(R.id.editTextCode);
        btnContinue= findViewById(R.id.btnContinue);

        SharedPreferences sp= getSharedPreferences("list", MODE_PRIVATE);

        btnContinue.setOnClickListener((view)->{
            boolean sameCode=false;
            String name=editTextName.getText().toString();
            String code=editTextCode.getText().toString();
            String codesString= sp.getString("codes","empty");
           if(!codesString.equals("empty")){
               String[] codes= codesString.split(",");
               for(int i=0; i< codes.length && sameCode==false; i++){
                   if(codes[i].equalsIgnoreCase(code)){
                       Toast.makeText(this, "Código ya registrado, pruebe con otro", Toast.LENGTH_SHORT).show();
                       sameCode=true;
                   }
               }
           }

            if(sameCode==false){
               // Toast.makeText(this, name+code, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(this, Preparation.class);
                i.putExtra("name", name);
                i.putExtra("code", code);
                startActivity(i);
                finish();

            }


        });

    }
}