package com.example.a201495_2.porkgestion;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.Usuario;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.database.*;

public class MainActivity extends AppCompatActivity {
    TextView tv_registrar;
    Button btn_ingresar;

    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_registrar=findViewById(R.id.tv_registrar);
        btn_ingresar=findViewById(R.id.btn_ingresar);
        final GlobalClass datosGlobales = (GlobalClass) getApplicationContext();

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainActivity.this, MainRegistrousuario.class);
                MainActivity.this.startActivity(IntentReg);
            }
        });

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsuario= ((EditText) findViewById(R.id.txt_usuario)).getText().toString();
                String strPassword = ((EditText) findViewById(R.id.txt_password)).getText().toString();
                Usuario miusuario = new Usuario(getApplicationContext()).getUsuario(strUsuario);
                if(!clsUtil.bValidaString(strUsuario,1))
                    Toast.makeText(getBaseContext(),"Debe digitar el usuario (email)",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strUsuario,3))
                    Toast.makeText(getBaseContext(),"El usuario debe ser un email válido",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strPassword,1))
                    Toast.makeText(getBaseContext(),"Debe digitar el password",Toast.LENGTH_SHORT).show();
                else{
                    if (miusuario.validateUsuario(strUsuario,strPassword)) {
                        datosGlobales.setActiveUser(miusuario);
                        Intent IntentReg = new Intent(MainActivity.this, MenuLateral.class);
                        Toast.makeText(getBaseContext(),"Bienvenido a PorkGestión",Toast.LENGTH_SHORT).show();
                        MainActivity.this.startActivity(IntentReg);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "No existe usuario con los datos suministrados", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void onClick(View view){
        Intent miIntent=new Intent(MainActivity.this,MainRegistrousuario.class);
        startActivity(miIntent);
    }

}

