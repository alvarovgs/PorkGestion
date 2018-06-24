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


public class ceprenez extends AppCompatActivity {
    EditText campoidcerda, camponombrecerda, campofechamonta, campoprimercelo, campopesomonta, campoidpajilla, camponombreverraco, campoestado;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceprenez);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_reproduccion",null, 1);

        campoidcerda= (EditText)findViewById(R.id.id_verraco);
        camponombrecerda= (EditText)findViewById(R.id.nameverraco);
        campofechamonta= (EditText)findViewById(R.id.nameraza);
        campoprimercelo=(EditText)findViewById(R.id.nacimientov);
        campopesomonta=(EditText)findViewById(R.id.proveedor);
        campoidpajilla=(EditText)findViewById(R.id.idpajilla);
        camponombreverraco=(EditText)findViewById(R.id.nombreverraco);
        campoestado=(EditText)findViewById(R.id.estado);

    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_actverraco:
                actualizarprenez();
                break;

            case R.id.btn_eliminar:
                eliminarprenez();
                break;

            case R.id.btn_clean:
                limpiar();
                break;

            case R.id.btn_buscar:
                consultar();
                break;

        }


    }

    private void eliminarprenez() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={campoidcerda.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIOS, Utilidades.CAMPO_IDCERDA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Datos Eliminados",Toast.LENGTH_LONG).show();
        camponombrecerda.setText("");
        campofechamonta.setText("");
        campoprimercelo.setText("");
        campopesomonta.setText("");
        campoidpajilla.setText("");
        camponombreverraco.setText("");
        campoestado.setText("");
        db.close();
    }

    private void actualizarprenez() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={campoidcerda.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRECERDA, camponombrecerda.getText().toString());
        values.put(Utilidades.CAMPO_FECHAMONTA, campofechamonta.getText().toString());
        values.put(Utilidades.CAMPO_PRIMERCELO, campoprimercelo.getText().toString());
        values.put(Utilidades.CAMPO_PESOMONTA, campopesomonta.getText().toString());
        values.put(Utilidades.CAMPO_IDPAJILLA, campoidpajilla.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREVERRACO, camponombreverraco.getText().toString());
        values.put(Utilidades.CAMPO_ESTADO, campoestado.getText().toString());

        db.update(Utilidades.TABLA_USUARIOS,values, Utilidades.CAMPO_IDCERDA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Datos Actualizados",Toast.LENGTH_LONG).show();
        db.close();
    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(ceprenez.this, reproduccion.class);
        startActivity(miIntent);
    }
    private void consultar() {

        SQLiteDatabase db=conn.getReadableDatabase();
        String [] parametros={campoidcerda.getText().toString()};
        String [] campos={Utilidades.CAMPO_NOMBRECERDA, Utilidades.CAMPO_FECHAMONTA, Utilidades.CAMPO_PRIMERCELO,
                Utilidades.CAMPO_PESOMONTA, Utilidades.CAMPO_IDPAJILLA, Utilidades.CAMPO_NOMBREVERRACO, Utilidades.CAMPO_ESTADO};

        try{
            Cursor cursor= db.query(Utilidades.TABLA_USUARIOS,campos, Utilidades.CAMPO_IDCERDA+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            camponombrecerda.setText(cursor.getString(0));
            campofechamonta.setText(cursor.getString(1));
            campoprimercelo.setText(cursor.getString(2));
            campopesomonta.setText(cursor.getString(3));
            campoidpajilla.setText(cursor.getString(4));
            camponombreverraco.setText(cursor.getString(5));
            campoestado.setText(cursor.getString(6));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"ID de cerda no valido",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        camponombrecerda.setText("");
        campofechamonta.setText("");
        campoprimercelo.setText("");
        campopesomonta.setText("");
        campoidpajilla.setText("");
        camponombreverraco.setText("");
        campoestado.setText("");
    }



}
