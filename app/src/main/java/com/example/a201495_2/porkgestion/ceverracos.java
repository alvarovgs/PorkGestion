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


public class ceverracos extends AppCompatActivity {

    EditText campoid_verraco, camponameverraco, camponameraza, camponacimientov, campopesoverraco, campoobservacionesv;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceverracos);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_reproduccion",null, 1);

        campoid_verraco= (EditText)findViewById(R.id.idcerda);
        camponameverraco = (EditText)findViewById(R.id.tipomonta);
        camponameraza= (EditText)findViewById(R.id.idverraco);
        camponacimientov=(EditText)findViewById(R.id.idpajilla);
        campopesoverraco=(EditText)findViewById(R.id.idraza);
        campoobservacionesv=(EditText)findViewById(R.id.observacionesv);


    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_act:
                actualizarverracos();
                break;

            case R.id.btn_eliminar:
                eliminarverracos();
                break;

            case R.id.btn_clean:
                limpiar();
                break;

            case R.id.btn_buscar:
                consultar();
                break;

        }


    }

    private void eliminarverracos() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={campoid_verraco.getText().toString()};

        db.delete(Utilidades.TABLA_VERRACOS, Utilidades.CAMPO_IDVERRACO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Datos Eliminados",Toast.LENGTH_LONG).show();
        campoid_verraco.setText("");
        camponameverraco.setText("");
        camponameraza.setText("");
        camponacimientov.setText("");
        campopesoverraco.setText("");
        campoobservacionesv.setText("");
        db.close();
    }

    private void actualizarverracos() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={campoid_verraco.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NAMEVERRACO, camponameverraco.getText().toString());
        values.put(Utilidades.CAMPO_NAMERAZA, camponameraza.getText().toString());
        values.put(Utilidades.CAMPO_NACIMIENTOV, camponacimientov.getText().toString());
        values.put(Utilidades.CAMPO_PESOVERRACO, campopesoverraco.getText().toString());
        values.put(Utilidades.CAMPO_OBSERVACIONESV, campoobservacionesv.getText().toString());


        db.update(Utilidades.TABLA_VERRACOS,values, Utilidades.CAMPO_IDVERRACO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Datos Actualizados",Toast.LENGTH_LONG).show();
        db.close();
    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(ceverracos.this, reproduccion.class);
        startActivity(miIntent);
    }
    private void consultar() {

        SQLiteDatabase db=conn.getReadableDatabase();
        String [] parametros={campoid_verraco.getText().toString()};
        String [] campos={Utilidades.CAMPO_NAMEVERRACO, Utilidades.CAMPO_NAMEVERRACO, Utilidades.CAMPO_NACIMIENTOV,
                Utilidades.CAMPO_PESOVERRACO, Utilidades.CAMPO_OBSERVACIONESV,};

        try{
            Cursor cursor= db.query(Utilidades.TABLA_VERRACOS,campos, Utilidades.CAMPO_IDVERRACO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            camponameverraco.setText(cursor.getString(0));
            camponameraza.setText(cursor.getString(1));
            camponacimientov.setText(cursor.getString(2));
            campopesoverraco.setText(cursor.getString(3));
            campoobservacionesv.setText(cursor.getString(4));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"ID de Verraco no valido",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        camponameverraco.setText("");
        camponameraza.setText("");
        camponacimientov.setText("");
        campopesoverraco.setText("");
        campoobservacionesv.setText("");
    }



}
