package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;

public class ventas extends AppCompatActivity {

    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
    }

    public void onClick(View view){
        Intent miIntent=new Intent(ventas.this,MenuLateral.class);
        startActivity(miIntent);
    }

    //codigo para que no cierre la app por no ingresar datos y presionar el boton consulta
    public void consulta(View v) {
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

    public void ingresar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }

}
