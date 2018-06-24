package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class prenez extends AppCompatActivity {
    private Utilidades clsUtil = new Utilidades();
    EditText campoIdanimonta,campoNombremonta,campoEdadmonta,campoPesomonta, campoFecha1celo, campoFecha2celo, campoFechaeco ;
    Spinner comboTipoprenez, comboNomverraco,comboNumpajilla;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenez);

        conn=new ConexionSQLiteHelper(getApplicationContext(), "bd_porcinos", null, 1);

        campoIdanimonta= (EditText) findViewById(R.id.campoIdanimonta);
        campoNombremonta= (EditText) findViewById(R.id.campoNombremonta);
        campoEdadmonta= (EditText) findViewById(R.id.campoEdadmonta);
        campoPesomonta=(EditText) findViewById(R.id.campoPesomonta);
        campoFecha1celo=(EditText) findViewById(R.id.campoFecha1celo);
        campoFecha2celo=(EditText) findViewById(R.id.campoFecha2celo);
        campoFechaeco=(EditText) findViewById(R.id.campoFechaeco);
        comboTipoprenez = (Spinner) findViewById(R.id.comboTipoprenez);
        comboNomverraco = (Spinner) findViewById(R.id.comboNomverraco);
        comboNumpajilla= (Spinner) findViewById(R.id.comboNumpajilla);
    }

    public void onClick(View view) {
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,8);
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bd_porcinos", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_IDANIMONTA,campoIdanimonta.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREMONTA,campoNombremonta.getText().toString());
        values.put(Utilidades.CAMPO_EDADMONTA,campoEdadmonta.getText().toString());
        values.put(Utilidades.CAMPO_PESOMONTA,campoPesomonta.getText().toString());
//        values.put(Utilidades.CAMPO_SEXO,campoSexo.getText().toString());
//        values.put(Utilidades.CAMPO_RAZA,campoRaza.getText().toString());
        values.put(Utilidades.CAMPO_FECHA1CELO,campoFecha1celo.getText().toString());
        values.put(Utilidades.CAMPO_FECHA2CELO,campoFecha2celo.getText().toString());
        values.put(Utilidades.CAMPO_FECHAECO,campoFechaeco.getText().toString());
        values.put(Utilidades.CAMPO_TIPOPRENEZ,comboTipoprenez.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_NOMVERRACO,comboNomverraco.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_NUMPAJILLA,comboNumpajilla.getSelectedItem().toString());

        Long idResultante=db.insert(Utilidades.TABLA_PRENEZ,Utilidades.CAMPO_IDANIMONTA,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
        limpiar();
    }

    private void limpiar() {
        campoIdanimonta.setText("");
        campoNombremonta.setText("");
        campoEdadmonta.setText("");
        campoPesomonta.setText("");
        campoFecha1celo.setText("");
        campoFecha2celo.setText("");
        campoFechaeco.setText("");
        comboTipoprenez.setSelection(0);
        comboNomverraco.setSelection(0);
        comboNumpajilla.setSelection(0);
        campoIdanimonta.requestFocus();

    }
}
