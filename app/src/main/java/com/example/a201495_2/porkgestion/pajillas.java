package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class pajillas extends AppCompatActivity {

    EditText camponumpajilla, camponomverraco, camponomraza, campovencimiento, campoproveedor, campoobservaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pajillas);

        camponumpajilla= (EditText)findViewById(R.id.numpajilla);
        camponomverraco= (EditText)findViewById(R.id.nomverraco);
        camponomraza= (EditText)findViewById(R.id.nomraza);
        campovencimiento=(EditText)findViewById(R.id.vencimiento);
        campoproveedor=(EditText)findViewById(R.id.proveedor);
        campoobservaciones=(EditText)findViewById(R.id.observaciones);

    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(pajillas.this, reproduccion.class);
        startActivity(miIntent);
    }

    public void onClick (View view) {
        registropajillas();
    }

    private void registropajillas() {

       // ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_reproduccion",null,2);
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_reproduccion",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_NUMPAJILLA,camponumpajilla.getText().toString());
        values.put(Utilidades.CAMPO_NOMVERRACO,camponomverraco.getText().toString());
        values.put(Utilidades.CAMPO_NOMRAZA,camponomraza.getText().toString());
        values.put(Utilidades.CAMPO_VENCIMIENTO,campovencimiento.getText().toString());
        values.put(Utilidades.CAMPO_PROVEEDOR,campoproveedor.getText().toString());
        values.put(Utilidades.CAMPO_OBSERVACIONES,campoobservaciones.getText().toString());


        Long idResultante= db.insert(Utilidades.TABLA_PAJILLAS, Utilidades.CAMPO_NUMPAJILLA,values);
        Toast.makeText(getApplicationContext(),"Registrada Pajilla #: "+ idResultante, Toast.LENGTH_SHORT).show();

    }
}
