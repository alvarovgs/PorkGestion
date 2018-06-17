package com.example.a201495_2.porkgestion;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.utils.clsUtilidades;


public class MainActivity extends AppCompatActivity {
    TextView tv_registrar;
    TextView tv_ingresar;
    TextView tv_info;
    private clsUtilidades clsUtil = new clsUtilidades();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_registrar=findViewById(R.id.tv_registrar);
        tv_ingresar=findViewById(R.id.tv_ingresar);


        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainActivity.this, MainRegistrousuario.class);
                MainActivity.this.startActivity(IntentReg);
            }
        });

        tv_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsuario= ((EditText) findViewById(R.id.txt_usuario)).getText().toString();
                String strPassword = ((EditText) findViewById(R.id.txt_password)).getText().toString();
                if(!clsUtil.bValidaString(strUsuario,1))
                    Toast.makeText(getBaseContext(),"Debe digitar el usuario (email)",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strUsuario,3))
                    Toast.makeText(getBaseContext(),"El usuario debe ser un email válido",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strPassword,1))
                    Toast.makeText(getBaseContext(),"Debe digitar el password",Toast.LENGTH_SHORT).show();
                else if (strUsuario.equals("admin@gmail.com")){
                    //Todo  Validar aceso a BD
                    Intent IntentReg= new Intent (MainActivity.this, MenuLateral.class);
                    MainActivity.this.startActivity(IntentReg);
                }
            }
        });
    }
    public void onClick(View view){
        Intent miIntent=new Intent(MainActivity.this,MainRegistrousuario.class);
        startActivity(miIntent);
    }

}

