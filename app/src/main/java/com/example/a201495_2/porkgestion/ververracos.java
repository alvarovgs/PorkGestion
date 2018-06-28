package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.a201495_2.porkgestion.bo_clases.Cerdo;

import java.util.ArrayList;

public class ververracos extends AppCompatActivity {
    ArrayList<String> listainformacion;
    ArrayList<Cerdo> listaverracos;
    ListView listviewverracos;
    //ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ververracos);
        listviewverracos=(ListView) findViewById(R.id.listviewverracos);
        consultarlistaverracos();
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listainformacion);
        listviewverracos.setAdapter(adaptador);
    }

    private void consultarlistaverracos() {
        Cerdo usuario=null;
        listaverracos= new ArrayList<Cerdo>();
        obtenerlista();
    }

    private void obtenerlista() {
        listainformacion=new ArrayList<String>();
/*
        for (int i=0; i<listaverracos.size();i++){
            listainformacion.add("ID de Verraco: "+listaverracos.get(i).getId_verraco()+ "\nNombre del verraco: "+listaverracos.get(i).getNameverraco()+"\nRaza del Verraco:"+listaverracos.get(i).getNameverraco()+ "\nFecha de Nacimiento: "+listaverracos.get(i).getNacimientov()+ "\nPeso: "+listaverracos.get(i).getPesoverraco()+ "\nObservaciones: "+listaverracos.get(i).getObservacionesv());
        }
*/

    }
    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(ververracos.this, prenez.class);
        startActivity(miIntent);
    }
}
