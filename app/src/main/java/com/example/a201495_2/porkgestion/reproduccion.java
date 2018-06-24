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
            case R.id.btn_preñez:
                miIntent = new Intent(reproduccion.this, prenez.class);
                break;

            case R.id.btn_gestantes:
                miIntent = new Intent(reproduccion.this, ceprenez.class);
                break;


            case R.id.btn_pajilla:
                miIntent = new Intent(reproduccion.this, pajillas.class);
                break;

            case R.id.btn_acpajillas:
                miIntent = new Intent(reproduccion.this, cepajillas.class);
                break;


            case R.id.btn_verracos:
                miIntent = new Intent(reproduccion.this, verraco.class);
                break;

            case R.id.btc_acverracos:
                miIntent = new Intent(reproduccion.this, ceverracos.class);
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
