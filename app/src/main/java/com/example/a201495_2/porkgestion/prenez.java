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


public class prenez extends AppCompatActivity {
    Button btn_reg;


    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenez);

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
