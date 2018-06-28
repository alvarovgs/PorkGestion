package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.bo_clases.reproduccion;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;


public class ceprenez extends AppCompatActivity {
    Button btn_act;
    Button btn_buscar;
    Button btn_eliminar;

    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceprenez);

        btn_act = findViewById(R.id.btn_act);
        btn_buscar = findViewById(R.id.btn_buscar);
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });

        btn_eliminar = findViewById(R.id.btn_eliminar);
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });

        btn_act.setOnClickListener (new View.OnClickListener() {
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
                    Toast.makeText(getBaseContext(),"Debe digitar tipo de monta",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strIdHembra,2))
                    Toast.makeText(getBaseContext(),"Debe digitar el ID de la Hembra",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strFechaMonta,4))
                    Toast.makeText(getBaseContext(),"Debe digitar Fecha de monta",Toast.LENGTH_SHORT).show();
                else if(!clsUtil.bValidaString(strEstado,1))
                    Toast.makeText(getBaseContext(),"Debe digitar estado de la Prenez",Toast.LENGTH_SHORT).show();
                else {
                    prenez.setStrTipoMonta(strTipoMonta);
                    prenez.setIdHembra(Integer.parseInt(strIdHembra));
                    prenez.setIdVerraco(Integer.parseInt(strIdVerraco));
                    prenez.setIdPajilla(Integer.parseInt(strIdPajilla));
                    prenez.setStrFechaMonta(strFechaMonta);
                    prenez.setStrEstado(strEstado);



                    if(prenez.updateprenez()) {
                        Toast.makeText(getApplicationContext(), "Prenez actualizada correctamente", Toast.LENGTH_SHORT).show();
                        Intent IntentReg = new Intent(ceprenez.this, ceprenez.class);
                        ceprenez.this.startActivity(IntentReg);
                    }
                    else{
                        String error = prenez.getStrError();
                        Toast.makeText(getApplicationContext(), "Se presento un error" + error, Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });}

    private void eliminar() {
        String strIdCerda = ((EditText) findViewById(R.id.idcerda)).getText().toString();
        reproduccion eliminar = new reproduccion(getApplicationContext());
        eliminar.setIdHembra(Integer.parseInt(strIdCerda));
        if (eliminar.deleteprenez()){
            Toast.makeText(getApplicationContext(), "Registro Preñez Eliminado", Toast.LENGTH_SHORT).show();
            Intent IntentReg = new Intent(ceprenez.this, ceprenez.class);
            ceprenez.this.startActivity(IntentReg);

        }
        else{
            Toast.makeText(getApplicationContext(), "Se presento un error", Toast.LENGTH_SHORT).show();
        }
    }

    private void consultar() {
        String strIdCerda = ((EditText) findViewById(R.id.idcerda)).getText().toString();
        reproduccion consultar = new reproduccion(getApplicationContext());
        consultar= consultar.getPrenezByView(strIdCerda);
        ((EditText) findViewById(R.id.tipomonta)).setText(consultar.getStrTipoMonta());
        ((EditText) findViewById(R.id.idverraco)).setText(String.valueOf(consultar.getIdVerraco()));
        ((EditText) findViewById(R.id.idpajilla)).setText(String.valueOf(consultar.getIdPajilla()));
        ((EditText) findViewById(R.id.fechamonta)).setText(consultar.getStrFechaMonta());
        ((EditText) findViewById(R.id.estado)).setText(consultar.getStrEstado());


    }


}




