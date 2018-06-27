package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;


import java.util.ArrayList;

public class ververracos extends AppCompatActivity {
    ArrayList<String> listainformacion;
    ArrayList<Usuario> listaverracos;
    ListView listviewverracos;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ververracos);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_reproduccion",null,1);
        listviewverracos=(ListView) findViewById(R.id.listviewverracos);

        consultarlistaverracos();
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listainformacion);
        listviewverracos.setAdapter(adaptador);
    }

    private void consultarlistaverracos() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listaverracos= new ArrayList<Usuario>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_VERRACOS,null);

        while (cursor.moveToNext()){
            usuario= new Usuario();
            usuario.setId_verraco(cursor.getString(0));
            usuario.setNameverraco(cursor.getString(1));
            usuario.setNameraza(cursor.getString(2));
            usuario.setNacimientov(cursor.getString(3));
            usuario.setPesoverraco(cursor.getString(4));
            usuario.setObservacionesv(cursor.getString(5));


            listaverracos.add(usuario);

        }

        obtenerlista();
    }

    private void obtenerlista() {
        listainformacion=new ArrayList<String>();
        for (int i=0; i<listaverracos.size();i++){
            listainformacion.add("ID de Verraco: "+listaverracos.get(i).getId_verraco()+ "\nNombre del verraco: "+listaverracos.get(i).getNameverraco()+"\nRaza del Verraco:"+listaverracos.get(i).getNameverraco()+ "\nFecha de Nacimiento: "+listaverracos.get(i).getNacimientov()+ "\nPeso: "+listaverracos.get(i).getPesoverraco()+ "\nObservaciones: "+listaverracos.get(i).getObservacionesv());
        }

    }
    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(ververracos.this, reproduccion.class);
        startActivity(miIntent);
    }
}
