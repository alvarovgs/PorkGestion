package com.example.a201495_2.porkgestion;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;

public class MainActivity extends AppCompatActivity {
    private View parent_view;
    private Utils clsUtil = new Utils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_iniciar = findViewById(R.id.bt_iniciar);
        bt_iniciar.setOnClickListener(new View.OnClickListener() {
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
                    startActivity(new Intent(MainActivity.this, MenuLateral.class));
                }
            }
        });
    }

}
