package com.example.a201495_2.porkgestion;

<<<<<<< HEAD
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.bo_clases.reproduccion;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;


public class prenez extends AppCompatActivity {
    Button btn_reg;


    private clsUtilidades clsUtil = new clsUtilidades();
=======
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
>>>>>>> origin/fabian

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenez);

<<<<<<< HEAD
        btn_reg = findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reproduccion prenez = new reproduccion(getApplicationContext());

                String strTipoMonta = ((EditText) findViewById(R.id.tipomonta)).getText().toString();
                String strIdHembra = ((EditText) findViewById(R.id.idcerda)).getText().toString();
                String strIdVerraco = ((EditText) findViewById(R.id.idverraco)).getText().toString();
                String strIdPajilla = ((EditText) findViewById(R.id.idpajilla)).getText().toString();
                String strFechaMonta = ((EditText) findViewById(R.id.fechamonta)).getText().toString();
                String strEstado = ((EditText) findViewById(R.id.estado)).getText().toString();


                if(!clsUtil.bValidaString(strTipoMonta,1))
                    Toast.makeText(getBaseContext(),"Debe registrar tipo de monta",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strIdHembra,2))
                    Toast.makeText(getBaseContext(),"Debe registrar el ID de la Hembra",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strFechaMonta,4))
                    Toast.makeText(getBaseContext(),"Debe registrar Fecha de monta",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strEstado,1))
                    Toast.makeText(getBaseContext(),"Debe registrar estado de la Prenez",Toast.LENGTH_SHORT).show();
                else {
                    prenez.setStrTipoMonta(strTipoMonta);
                    prenez.setIdHembra(Integer.parseInt(strIdHembra));
                    prenez.setIdVerraco(Integer.parseInt(strIdVerraco));
                    prenez.setIdPajilla(Integer.parseInt(strIdPajilla));
                    prenez.setStrFechaMonta(strFechaMonta);
                    prenez.setStrEstado(strEstado);




                    if(prenez.regprenez()) {
                            Toast.makeText(getApplicationContext(), "Prenez registrada correctamente", Toast.LENGTH_SHORT).show();
                            Intent IntentReg = new Intent(prenez.this, prenez.class);
                            prenez.this.startActivity(IntentReg);
                        }
                        else{
                            String error = prenez.getStrError();
                            Toast.makeText(getApplicationContext(), "Se presento un error" + error, Toast.LENGTH_SHORT).show();
                        }

                }

            }
        }



        );}}
=======
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
>>>>>>> origin/fabian
