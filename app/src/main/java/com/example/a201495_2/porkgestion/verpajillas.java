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

public class verpajillas extends AppCompatActivity {
    ArrayList<String> listainformacion;
    ArrayList<Usuario> listapajillas;
    ListView listviewpajillas;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verpajillas);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_reproduccion",null,1);
        listviewpajillas=(ListView) findViewById(R.id.listviewpajillas);

        consultarlistapajillas();
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listainformacion);
        listviewpajillas.setAdapter(adaptador);
    }

    private void consultarlistapajillas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listapajillas= new ArrayList<Usuario>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_PAJILLAS,null);

        while (cursor.moveToNext()){
            usuario= new Usuario();
            usuario.setNumpajilla(cursor.getString(0));
            usuario.setNomverraco(cursor.getString(1));
            usuario.setNomraza(cursor.getString(2));
            usuario.setVencimiento(cursor.getString(3));
            usuario.setProveedor(cursor.getString(4));
            usuario.setObservaciones(cursor.getString(5));


            listapajillas.add(usuario);

        }

        obtenerlista();
    }

    private void obtenerlista() {
        listainformacion=new ArrayList<String>();
        for (int i=0; i<listapajillas.size();i++){
            listainformacion.add("ID de Pajilla: "+listapajillas.get(i).getNumpajilla()+ "\nNombre del verraco: "+listapajillas.get(i).getNomverraco()+"\nRaza:"+listapajillas.get(i).getNomraza()+ "\nFecha de vencimiento: "+listapajillas.get(i).getVencimiento()+ "\nProveedor: "+listapajillas.get(i).getProveedor()+ "\nObservaciones: "+listapajillas.get(i).getObservaciones());
        }

    }
    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(verpajillas.this, prenez.class);
        startActivity(miIntent);
    }
}
