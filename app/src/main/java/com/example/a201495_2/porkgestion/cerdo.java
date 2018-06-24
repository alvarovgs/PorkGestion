package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;
import java.util.ArrayList;
import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;
//import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;


import java.util.ArrayList;

public class  cerdo extends AppCompatActivity {
//    private clsUtilidades clsUtil = new clsUtilidades();
    private Utilidades clsUtil = new Utilidades();
    EditText campoId,campoNombre,campoFechanace,campoPesonace, campoSexo, campoRaza, campoNombremadre, campoNombrepadre;

    Spinner comboRazas, comboSexo;
    ArrayList<String> listaRazas;
    ArrayList<Usuario> razasList;
    ArrayList<String> sexo;


    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerdo);

        //conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,8);
        conn=new ConexionSQLiteHelper(getApplicationContext(), "bd_porcinos", null, 1);
        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_porcinos", null,1);
        comboRazas= (Spinner) findViewById(R.id.comboRazas);

        campoId= (EditText) findViewById(R.id.campoId);
        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoFechanace= (EditText) findViewById(R.id.campoFechanace);
        campoPesonace=(EditText) findViewById(R.id.campoPesonace);
//        campoSexo=(EditText) findViewById(R.id.campoSexo);
//        campoRaza=(EditText) findViewById(R.id.campoRaza);
        campoNombremadre=(EditText) findViewById(R.id.campoNombremadre);
        campoNombrepadre=(EditText) findViewById(R.id.campoNombrepadre);
        comboRazas = (Spinner) findViewById(R.id.comboRazas);
        comboSexo = (Spinner) findViewById(R.id.comboSexo);

        String [] sexo ={"Seleccione el sexo", "Hembra", "Macho"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sexo);
        comboSexo.setAdapter(adapter);


        consultarListaPersonas();
        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter
                (this,android.R.layout.simple_spinner_item, listaRazas);
        comboRazas.setAdapter(adaptador);

    }

    public void onClick(View view) {
        registrarUsuarios();
        //registrarUsuariosSql();
    }

//    private void registrarUsuariosSql() {
//        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
//
//        SQLiteDatabase db=conn.getWritableDatabase();
//        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')
//
//        String insert="INSERT INTO "+Utilidades.TABLA_USUARIO
//                +" ( " +Utilidades.CAMPO_ID+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_TELEFONO+")" +
//                " VALUES ("+campoId.getText().toString()+", '"+campoNombre.getText().toString()+"','"
//                +campoTelefono.getText().toString()+"')";
//
//        db.execSQL(insert);
//        db.close();
//    }


    private void registrarUsuarios() {
        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,8);
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bd_porcinos", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_FECHANACE,campoFechanace.getText().toString());
        values.put(Utilidades.CAMPO_PESONACE,campoPesonace.getText().toString());
//        values.put(Utilidades.CAMPO_SEXO,campoSexo.getText().toString());
//        values.put(Utilidades.CAMPO_RAZA,campoRaza.getText().toString());
        values.put(Utilidades.CAMPO_SEXO,comboSexo.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_RAZA,comboRazas.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_NOMBREMADRE,campoNombremadre.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREPADRE,campoNombrepadre.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
        limpiar();
    }

    private void limpiar() {
        campoId.setText("");
        campoNombre.setText("");
        campoFechanace.setText("");
        campoPesonace.setText("");
//        campoSexo.setText("");
//        campoRaza.setText("");
        comboSexo.setSelection(0);
        comboRazas.setSelection(0);
        campoNombremadre.setText("");
        campoNombrepadre.setText("");
        campoId.requestFocus();

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Usuario raza=null;
        razasList =new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_RAZAS,null);
        while (cursor.moveToNext()){
            raza=new Usuario();
            raza.setId(cursor.getInt(0));
            raza.setNombre(cursor.getString(1));
            Log.i("id",raza.getId().toString());
            Log.i("Nombre",raza.getNombre());
            razasList.add(raza);
        }
        obtenerLista();
    }


    private void obtenerLista() {
        listaRazas =new ArrayList<String>();
        listaRazas.add("Seleccione la raza");
        for(int i = 0; i< razasList.size(); i++){
            listaRazas.add(razasList.get(i).getId()+" - "+razasList.get(i).getNombre());
            //           listaRazas.add(razasList.get(i).getNombre());
        }
    }

    /*para validar el boton cuando no se ha escrito nada pero la funcion ya tiene ese nombre arriba
    public void registrarUsuarios (View v) {
        EditText et1 = (EditText)findViewById(R.id.campoId);
        String numcerdo = et1.getText().toString();
        if (clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }*/

  /*  //codigo para pasar de activity con boton
    public void onClick(View view){
        Intent miIntent=new Intent(cerdo.this,MenuLateral.class);
        startActivity(miIntent);
    }*/
  /*  //codigo para que no cierre la app por no ingresar datos y presionar el boton consulta
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
    }*/

}