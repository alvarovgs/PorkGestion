package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class prenez extends AppCompatActivity {

    EditText campoidcerda, camponombrecerda, campofechamonta, campoprimercelo, campopesomonta, campoidpajilla, camponombreverraco, campoestado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenez);

        campoidcerda= (EditText)findViewById(R.id.id_verraco);
        camponombrecerda= (EditText)findViewById(R.id.nameverraco);
        campofechamonta= (EditText)findViewById(R.id.nameraza);
        campoprimercelo=(EditText)findViewById(R.id.nacimientov);
        campopesomonta=(EditText)findViewById(R.id.proveedor);
        campoidpajilla=(EditText)findViewById(R.id.idpajilla);
        camponombreverraco=(EditText)findViewById(R.id.nombreverraco);
        campoestado=(EditText)findViewById(R.id.estado);

    }

    public void Regresar(View view) {
        Intent miIntent=null;
                miIntent = new Intent(prenez.this, prenez.class);
        startActivity(miIntent);
    }

    public void onClick (View view) {
        registroprenez();
    }

    private void registroprenez() {

     /*   ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_reproduccion",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_IDCERDA,campoidcerda.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRECERDA,camponombrecerda.getText().toString());
        values.put(Utilidades.CAMPO_FECHAMONTA,campofechamonta.getText().toString());
        values.put(Utilidades.CAMPO_PRIMERCELO,campoprimercelo.getText().toString());
        values.put(Utilidades.CAMPO_PESOMONTA,campopesomonta.getText().toString());
        values.put(Utilidades.CAMPO_IDPAJILLA,campoidpajilla.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREVERRACO,camponombreverraco.getText().toString());
        values.put(Utilidades.CAMPO_ESTADO,campoestado.getText().toString());


     Long idResultante= db.insert(Utilidades.TABLA_USUARIOS, Utilidades.CAMPO_IDCERDA,values);
        Toast.makeText(getApplicationContext(),"id Registro: "+ idResultante, Toast.LENGTH_SHORT).show();
*/
    }
}
