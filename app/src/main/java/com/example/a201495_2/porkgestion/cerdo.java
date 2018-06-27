package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;

public class  cerdo extends AppCompatActivity {
    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerdo);
    }

    //codigo para pasar de activity con boton
    public void onClick(View view){
        Intent miIntent=new Intent(cerdo.this,MenuLateral.class);
        startActivity(miIntent);
    }
    //codigo para que no cierre la app por no ingresar datos y presionar el boton consulta
    public void consulta(View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
        else{
            Cerdo miCerdo = new Cerdo(getApplicationContext());
            if(miCerdo.existCerdo(numcerdo)){
                miCerdo.getCerdoByView(numcerdo);
                String nombrePadre = miCerdo.getStrCodPadre();
                String nombreRaza= miCerdo.getStrRaza();
                String Fecha= miCerdo.getStrFechaNace();
            }
            else{
                Toast.makeText(this, "No existe el cerdo",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void eliminar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }

    public void ingresar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }



    }

    public void actualizar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }

}