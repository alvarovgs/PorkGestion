package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.a201495_2.porkgestion.bo_clases.Cerdo;

import java.util.ArrayList;

public class vergestantes extends AppCompatActivity {
    ArrayList<String> listainformacion;
    ArrayList<Cerdo> listagestantes;
    ListView listviewgestantes;
    //ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vergestantes);
        listviewgestantes=(ListView) findViewById(R.id.listviewgestantes);
        consultarlistagestantes();
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listainformacion);
        listviewgestantes.setAdapter(adaptador);
    }

    private void consultarlistagestantes() {
        Cerdo usuario=null;
        listagestantes= new ArrayList<Cerdo>();
        obtenerlista();
    }

    private void obtenerlista() {
        listainformacion=new ArrayList<String>();
    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(vergestantes.this, prenez.class);
        startActivity(miIntent);
    }

}
