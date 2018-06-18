package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utils.clsUtilidades;

public class MainEditusuario extends AppCompatActivity {
    Button btn_reg;
    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_editusuario);

        btn_reg = findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsuario= ((EditText) findViewById(R.id.txt_usuario)).getText().toString();
                String strPassword = ((EditText) findViewById(R.id.txt_pass)).getText().toString();
                if(!clsUtil.bValidaString(strUsuario,1))
                    Toast.makeText(getBaseContext(),"Debe digitar un nuevo usuario (email)",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strUsuario,3))
                    Toast.makeText(getBaseContext(),"El usuario debe ser un email válido",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strPassword,1))
                    Toast.makeText(getBaseContext(),"Debe digitar un nuevo password",Toast.LENGTH_SHORT).show();
                else if (strUsuario.equals("admin@gmail.com")){
                    //Todo  Validar aceso a BD
                    Intent IntentReg= new Intent (MainEditusuario.this, MainActivity.class);
                    MainEditusuario.this.startActivity(IntentReg);
                }

            }
        });

    }}