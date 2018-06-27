package com.example.a201495_2.porkgestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;
import com.example.a201495_2.porkgestion.entidades.Usuario;

public class reproduccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduccion);

        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_reproduccion",null,1);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_prenez:
                miIntent = new Intent(reproduccion.this, prenez.class);
                break;

            case R.id.btn_actprenez:
                miIntent = new Intent(reproduccion.this, ceprenez.class);
                break;


            case R.id.btn_actverraco:
                miIntent = new Intent(reproduccion.this, verraco.class);
                break;


        }
        startActivity(miIntent);
    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(reproduccion.this, MenuLateral.class);
        startActivity(miIntent);
    }
}
