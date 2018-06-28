package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.Usuario;

    public class MainRegistrousuario extends AppCompatActivity {
     Button btn_reg;
    private clsUtilidades clsUtil = new clsUtilidades();

        @Override
     protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_registrousuario);

        btn_reg = findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Usuario miUsuario = new Usuario(getApplicationContext());

                        String strUsuario = ((EditText) findViewById(R.id.et_Codigo)).getText().toString();
                        String strPassword = ((EditText) findViewById(R.id.txt_pass)).getText().toString();
                        String strNombre = ((EditText) findViewById(R.id.txt_nombreusuario)).getText().toString();
                        String strTelefono = ((EditText) findViewById(R.id.txt_telefono)).getText().toString();


                        if(!clsUtil.bValidaString(strUsuario,1))
                            Toast.makeText(getBaseContext(),"Debe digitar el usuario (email)",Toast.LENGTH_SHORT).show();
                        else if(!clsUtil.bValidaString(strUsuario,3))
                            Toast.makeText(getBaseContext(),"El usuario debe ser un email válido",Toast.LENGTH_SHORT).show();
                        else if(!clsUtil.bValidaString(strPassword,1))
                            Toast.makeText(getBaseContext(),"Debe digitar el password",Toast.LENGTH_SHORT).show();
                        else if(!clsUtil.bValidaString(strNombre,1))
                            Toast.makeText(getBaseContext(),"Debe digitar un nombre de usuario",Toast.LENGTH_SHORT).show();
                        else {
                            miUsuario.setStrEmail(strUsuario);
                            miUsuario.setStrPassword(strPassword);
                            miUsuario.setStrNombre(strNombre);
                            miUsuario.setStrTelefono(strTelefono);

                            if(!miUsuario.existUsuario(strUsuario)){
                                if(miUsuario.insertUsuario()) {
                                    Toast.makeText(getApplicationContext(), "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                    Intent IntentReg = new Intent(MainRegistrousuario.this, MainActivity.class);
                                    MainRegistrousuario.this.startActivity(IntentReg);
                                }
                                else{
                                    String error = miUsuario.getStrError();
                                    Toast.makeText(getApplicationContext(), "Se presento un error" + error , Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "ya existe un usuario con el email digitado", Toast.LENGTH_SHORT).show();
                            }
                        }

            }
        });

    }}
