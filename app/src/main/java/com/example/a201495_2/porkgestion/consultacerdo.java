package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class consultacerdo extends AppCompatActivity {

    EditText campoIdConsulta,campoNombreConsulta,campoFechanaceConsulta,campoPesonaceConsulta, campoSexoConsulta, campoRazaConsulta, campoNombremadreConsulta, campoNombrepadreConsulta;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultacerdo);

        //conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,8);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_porcinos", null,1);
        campoIdConsulta= (EditText) findViewById(R.id.campoIdConsulta);
        campoNombreConsulta= (EditText) findViewById(R.id.campoNombreConsulta);
        campoFechanaceConsulta= (EditText) findViewById(R.id.campoFechanaceConsulta);
        campoPesonaceConsulta=(EditText) findViewById(R.id.campoPesonaceConsulta);
        campoSexoConsulta=(EditText) findViewById(R.id.campoSexoConsulta);
        campoRazaConsulta=(EditText) findViewById(R.id.campoRazaConsulta);
        campoNombremadreConsulta=(EditText) findViewById(R.id.campoNombremadreConsulta);
        campoNombrepadreConsulta=(EditText) findViewById(R.id.campoNombrepadreConsulta);

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
                //consultarSql();
                break;
            case R.id.btnLimpiar:
                limpiar();
                break;
            case R.id.btnActualizar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarUsuario();
                break;
        }
    }

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoIdConsulta.getText().toString()};
        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el cerdo",Toast.LENGTH_LONG).show();
        campoIdConsulta.setText("");
        db.close();
        limpiar();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoIdConsulta.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombreConsulta.getText().toString());
        values.put(Utilidades.CAMPO_FECHANACE,campoFechanaceConsulta.getText().toString());
        values.put(Utilidades.CAMPO_PESONACE,campoPesonaceConsulta.getText().toString());
        values.put(Utilidades.CAMPO_SEXO,campoSexoConsulta.getText().toString());
        values.put(Utilidades.CAMPO_RAZA,campoRazaConsulta.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREMADRE,campoNombremadreConsulta.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREPADRE,campoNombrepadreConsulta.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el cerdo",Toast.LENGTH_LONG).show();
        db.close();
        limpiar();

    }

//    private void consultarSql() {
//        SQLiteDatabase db=conn.getReadableDatabase();
//        String[] parametros={campoId.getText().toString()};
//
//        try {
//            //select nombre,telefono from usuario where codigo=?
//            Cursor cursor=db.rawQuery("SELECT "+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_TELEFONO+
//                    " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_ID+"=? ",parametros);
//
//            cursor.moveToFirst();
//            campoNombre.setText(cursor.getString(0));
//            campoTelefono.setText(cursor.getString(1));
//
//        }catch (Exception e){
//            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
//            limpiar();
//        }
//    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoIdConsulta.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_FECHANACE,Utilidades.CAMPO_PESONACE,Utilidades.CAMPO_SEXO,Utilidades.CAMPO_RAZA,Utilidades.CAMPO_NOMBREMADRE,Utilidades.CAMPO_NOMBREPADRE};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombreConsulta.setText(cursor.getString(0));
            campoFechanaceConsulta.setText(cursor.getString(1));
            campoPesonaceConsulta.setText(cursor.getString(2));
            campoSexoConsulta.setText(cursor.getString(3));
            campoRazaConsulta.setText(cursor.getString(4));
            campoNombremadreConsulta.setText(cursor.getString(5));
            campoNombrepadreConsulta.setText(cursor.getString(6));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El cerdo no existe",Toast.LENGTH_LONG).show();
        }
    }

    private void limpiar() {
        campoIdConsulta.setText("");
        campoNombreConsulta.setText("");
        campoFechanaceConsulta.setText("");
        campoPesonaceConsulta.setText("");
        campoSexoConsulta.setText("");
        campoRazaConsulta.setText("");
        campoNombremadreConsulta.setText("");
        campoNombrepadreConsulta.setText("");
        campoIdConsulta.requestFocus();
    }


}
