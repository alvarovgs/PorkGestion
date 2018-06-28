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


public class ceverracos extends AppCompatActivity {
    EditText campoid_verraco, camponameverraco, camponameraza, camponacimientov, campopesoverraco, campoobservacionesv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceverracos);

        campoid_verraco= findViewById(R.id.id_verraco);
        camponameverraco = findViewById(R.id.nameverraco);
        camponameraza= findViewById(R.id.nameraza);
        camponacimientov= findViewById(R.id.nacimientov);
        campopesoverraco= findViewById(R.id.pesoverraco);
        campoobservacionesv= findViewById(R.id.observacionesv);


    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_actverraco:
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

    }

    private void actualizarverracos() {

    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(ceverracos.this, prenez.class);
        startActivity(miIntent);
    }
    private void consultar() {




    }

    private void limpiar() {
        camponameverraco.setText("");
        camponameraza.setText("");
        camponacimientov.setText("");
        campopesoverraco.setText("");
        campoobservacionesv.setText("");
    }



}
