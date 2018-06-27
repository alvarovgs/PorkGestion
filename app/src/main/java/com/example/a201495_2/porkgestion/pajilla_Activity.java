package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.a201495_2.porkgestion.entidades.Pajilla;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class pajilla_Activity extends AppCompatActivity {

    //private Utilidades clsUtil = new Utilidades();
    EditText campoNumpajilla, campoFecompajilla, campoNompro, campoObpajilla;
    Spinner comboRazas;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pajilla);

        campoNumpajilla= (EditText) findViewById(R.id.campoNumpajilla);
        campoFecompajilla= (EditText) findViewById(R.id.campoFecompajilla);
        comboRazas= (Spinner) findViewById(R.id.comboRazas);
        campoNompro=(EditText) findViewById(R.id.campoNompro);
        campoObpajilla=(EditText) findViewById(R.id.campoObpajilla);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_porcinos",null,1);
    }

    public void onClick(View view) {
        registrarPajilla();
    }

    private void registrarPajilla() {
        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_porcinos", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_IDPAJILLA,campoNumpajilla.getText().toString());
        values.put(Utilidades.CAMPO_FECHACOMPRAPAJILLA,campoFecompajilla.getText().toString());
        values.put(Utilidades.CAMPO_RAZAPAJILLA,comboRazas.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_NOMPROVEPAJILLA,campoNompro.getText().toString());
        values.put(Utilidades.CAMPO_OBSEPAJILLA,campoObpajilla.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_PAJILLA,Utilidades.CAMPO_IDPAJILLA,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
        limpiar();

    }

    private void limpiar() {
        campoNumpajilla.setText("");
        campoFecompajilla.setText("");
        comboRazas.setSelection(0);
        campoNompro.setText("");
        campoObpajilla.setText("");
        campoNumpajilla.requestFocus();

    }


        /*public void onClick(View view){
            Intent miIntent=null;

            switch (view.getId()) {
                case R.id.btn_regresar:
                    miIntent = new Intent(pajilla_Activity.this, reproduccion.class);
                    break;
            }
            startActivity(miIntent);
        }*/
}
