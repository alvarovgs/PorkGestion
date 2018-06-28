package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utilidades.Utilidades;


public class cepajillas extends AppCompatActivity {
    EditText camponumpajilla, camponomverraco, camponomraza, campovencimiento, campoproveedor, campoobservaciones;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cepajillas);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_reproduccion",null, 1);

        camponumpajilla= (EditText)findViewById(R.id.numpajilla);
        camponomverraco= (EditText)findViewById(R.id.nomverraco);
        camponomraza= (EditText)findViewById(R.id.nomraza);
        campovencimiento=(EditText)findViewById(R.id.vencimiento);
        campoproveedor=(EditText)findViewById(R.id.proveedor);
        campoobservaciones=(EditText)findViewById(R.id.observaciones);

    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_actpajillas:
                actualizarpajillas();
                break;

            case R.id.btn_eliminar:
                eliminarpajillas();
                break;

            case R.id.btn_clean:
                limpiar();
                break;

            case R.id.btn_buscar:
                consultar();
                break;

        }


    }

    private void eliminarpajillas() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={camponumpajilla.getText().toString()};

        db.delete(Utilidades.TABLA_PAJILLAS, Utilidades.CAMPO_NUMPAJILLA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Datos Eliminados",Toast.LENGTH_LONG).show();
        camponomverraco.setText("");
        camponomraza.setText("");
        campovencimiento.setText("");
        campoproveedor.setText("");
        campoobservaciones.setText("");
        db.close();
    }

    private void actualizarpajillas() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={camponumpajilla.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMVERRACO, camponomverraco.getText().toString());
        values.put(Utilidades.CAMPO_NOMRAZA, camponomraza.getText().toString());
        values.put(Utilidades.CAMPO_VENCIMIENTO, campovencimiento.getText().toString());
        values.put(Utilidades.CAMPO_PROVEEDOR, campoproveedor.getText().toString());
        values.put(Utilidades.CAMPO_OBSERVACIONES, campoobservaciones.getText().toString());


        db.update(Utilidades.TABLA_PAJILLAS,values, Utilidades.CAMPO_NUMPAJILLA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Datos Actualizados",Toast.LENGTH_LONG).show();
        db.close();
    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(cepajillas.this, prenez.class);
        startActivity(miIntent);
    }
    private void consultar() {

        SQLiteDatabase db=conn.getReadableDatabase();
        String [] parametros={camponumpajilla.getText().toString()};
        String [] campos={Utilidades.CAMPO_NOMVERRACO, Utilidades.CAMPO_NOMRAZA, Utilidades.CAMPO_VENCIMIENTO,
                Utilidades.CAMPO_PROVEEDOR, Utilidades.CAMPO_OBSERVACIONES,};

        try{
            Cursor cursor= db.query(Utilidades.TABLA_PAJILLAS,campos, Utilidades.CAMPO_NUMPAJILLA+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            camponomverraco.setText(cursor.getString(0));
            camponomraza.setText(cursor.getString(1));
            campovencimiento.setText(cursor.getString(2));
            campoproveedor.setText(cursor.getString(3));
            campoobservaciones.setText(cursor.getString(4));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"ID de pajilla no valido",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        camponomverraco.setText("");
        camponomraza.setText("");
        campovencimiento.setText("");
        campoproveedor.setText("");
        campoobservaciones.setText("");
    }



}
