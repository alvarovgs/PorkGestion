package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class consultapajilla extends AppCompatActivity {

    EditText campoNumpajilla, campoFecompajilla, campoRazapajilla, campoNompro, campoObpajilla;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultapajilla);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_porcinos", null,1);
        campoNumpajilla= (EditText) findViewById(R.id.campoIdConsulta);
        campoFecompajilla= (EditText) findViewById(R.id.campoFepajiconsulta);
        campoRazapajilla= (EditText) findViewById(R.id.campoRazpajiconsulta);
        campoNompro= (EditText) findViewById(R.id.campoNompropajiconsulta);
        campoObpajilla= (EditText) findViewById(R.id.campoObserpajilla);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar:
                consultarPajilla();
                //consultarSql();
                break;
            case R.id.btnLimpiar:
                limpiar();
                break;
            case R.id.btnActualizar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarPajilla();
                break;
        }
    }

    private void eliminarPajilla() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoNumpajilla.getText().toString()};
        db.delete(Utilidades.TABLA_PAJILLA,Utilidades.CAMPO_IDPAJILLA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el cerdo",Toast.LENGTH_LONG).show();
        campoNumpajilla.setText("");
        db.close();
        limpiar();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoNumpajilla.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_FECHACOMPRAPAJILLA,campoFecompajilla.getText().toString());
        values.put(Utilidades.CAMPO_RAZAPAJILLA,campoRazapajilla.getText().toString());
        values.put(Utilidades.CAMPO_NOMPROVEPAJILLA,campoNompro.getText().toString());
        values.put(Utilidades.CAMPO_OBSEPAJILLA,campoObpajilla.getText().toString());


        db.update(Utilidades.TABLA_PAJILLA,values,Utilidades.CAMPO_IDPAJILLA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó la pajilla",Toast.LENGTH_LONG).show();
        db.close();
        limpiar();

    }

    private void consultarPajilla() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoNumpajilla.getText().toString()};
        String[] campos={Utilidades.CAMPO_FECHACOMPRAPAJILLA,Utilidades.CAMPO_RAZAPAJILLA,Utilidades.CAMPO_NOMPROVEPAJILLA,Utilidades.CAMPO_OBSEPAJILLA};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_PAJILLA,campos,Utilidades.CAMPO_IDPAJILLA+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoFecompajilla.setText(cursor.getString(0));
            campoRazapajilla.setText(cursor.getString(1));
            campoNompro.setText(cursor.getString(2));
            campoObpajilla.setText(cursor.getString(3));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"La pajilla no existe",Toast.LENGTH_LONG).show();
        }
    }

    private void limpiar() {
        campoNumpajilla.setText("");
        campoFecompajilla.setText("");
        campoRazapajilla.setText("");
        campoNompro.setText("");
        campoObpajilla.setText("");
        campoNumpajilla.requestFocus();
    }



}
