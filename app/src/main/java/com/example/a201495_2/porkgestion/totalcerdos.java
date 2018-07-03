package com.example.a201495_2.porkgestion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.a201495_2.porkgestion.bo_clases.Cerdo;




public class totalcerdos extends AppCompatActivity {

    ListView listViewCerdos;
    ArrayList<String> listaInformacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalcerdos);


        listViewCerdos = findViewById(R.id.listViewCerdos);
        Cerdo lista = new Cerdo(getApplicationContext());
        listaInformacion = lista.consultaCerdo();
        // consultarListaPersonas();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaInformacion);
        listViewCerdos.setAdapter(adaptador);
    }
}
