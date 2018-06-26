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


public class verraco extends AppCompatActivity {

    EditText campoid_verraco, camponameverraco, camponameraza, camponacimientov, campopesoverraco, campoobservacionesv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verraco);

        campoid_verraco= (EditText)findViewById(R.id.id_verraco);
        camponameverraco = (EditText)findViewById(R.id.nameverraco);
        camponameraza= (EditText)findViewById(R.id.nameraza);
        camponacimientov=(EditText)findViewById(R.id.nacimientov);
        campopesoverraco=(EditText)findViewById(R.id.pesoverraco);
        campoobservacionesv=(EditText)findViewById(R.id.observacionesv);

    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(verraco.this, prenez.class);
        startActivity(miIntent);
    }

    public void onClick (View view) {
        registroverraco();
    }

    private void registroverraco() {

        // ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_reproduccion",null,2);
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_reproduccion",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_IDVERRACO,campoid_verraco.getText().toString());
        values.put(Utilidades.CAMPO_NAMEVERRACO,camponameverraco.getText().toString());
        values.put(Utilidades.CAMPO_NAMERAZA,camponameraza.getText().toString());
        values.put(Utilidades.CAMPO_NACIMIENTOV,camponacimientov.getText().toString());
        values.put(Utilidades.CAMPO_PESOVERRACO,campopesoverraco.getText().toString());
        values.put(Utilidades.CAMPO_OBSERVACIONESV,campoobservacionesv.getText().toString());


        Long idResultante= db.insert(Utilidades.TABLA_VERRACOS, Utilidades.CAMPO_IDVERRACO,values);
        Toast.makeText(getApplicationContext(),"Registrada Pajilla #: "+ idResultante, Toast.LENGTH_SHORT).show();

    }
}
