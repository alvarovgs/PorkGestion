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

public class vergestantes extends AppCompatActivity {
    ArrayList<String> listainformacion;
    ArrayList<Usuario> listagestantes;
    ListView listviewgestantes;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vergestantes);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_reproduccion",null,1);
        listviewgestantes=(ListView) findViewById(R.id.listviewgestantes);

    consultarlistagestantes();
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listainformacion);
        listviewgestantes.setAdapter(adaptador);
    }

    private void consultarlistagestantes() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listagestantes= new ArrayList<Usuario>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIOS,null);

        while (cursor.moveToNext()){
            usuario= new Usuario();
            usuario.setIdcerda(cursor.getInt(0));
            usuario.setNombrecerda(cursor.getString(1));
            usuario.setFechamonta(cursor.getString(2));
            usuario.setPrimercelo(cursor.getString(3));
            usuario.setPesomonta(cursor.getString(4));
            usuario.setIdpajilla(cursor.getString(5));
            usuario.setNombreverraco(cursor.getString(6));
            usuario.setEstado(cursor.getString(7));

            listagestantes.add(usuario);

        }

        obtenerlista();
    }

    private void obtenerlista() {
        listainformacion=new ArrayList<String>();
        for (int i=0; i<listagestantes.size();i++){
            listainformacion.add("ID de Cerda: "+listagestantes.get(i).getIdcerda()+ "\nNombre de la cerda: "+listagestantes.get(i).getNombrecerda()+"\nFecha de Monta:"+listagestantes.get(i).getFechamonta()+ "\nFecha del primer celo: "+listagestantes.get(i).getPrimercelo()+ "\nPeso al momento de la monta: "+listagestantes.get(i).getPesomonta()+ "\nId de Pajilla/Nombre de Verraco: "+listagestantes.get(i).getIdpajilla()+listagestantes.get(i).getNombreverraco()+"\nEstado de la gestacion: "+listagestantes.get(i).getEstado());
    }

}
    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(vergestantes.this, reproduccion.class);
        startActivity(miIntent);
    }
}
