package com.example.a201495_2.porkgestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;
import com.example.a201495_2.porkgestion.bo_clases.SanidadCerdo;
import com.example.a201495_2.porkgestion.bo_clases.reproduccion;
//import com.example.a201495_2.porkgestion.bo_clases.parto;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

public class MainReporteHV extends AppCompatActivity {
    private Button btnConsultar;
    private EditText et_Codigo;
    private TextView et_NombreCerdo;
    private TextView et_FechaNace;
    private TextView et_Peso;
    private TextView et_Raza;
    private TextView et_Sexo;

    private TextView et_tipo;
    private TextView et_nombreMed;
    private TextView et_via;
    private TextView et_dosis;
    private TextView et_fecha;

    private TextView et_idhembra;
    private TextView et_idverraco;
    private TextView et_idpajilla;
    private TextView et_fechacelo;
    private TextView et_fechamonta;
    private TextView et_tipomonta;

    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reporte_hv);

        btnConsultar = findViewById(R.id.btnConsultar);
        dataBaseOpenHelper midb = new dataBaseOpenHelper(getApplicationContext());

        et_Codigo = findViewById(R.id.et_Codigo);
        et_NombreCerdo = findViewById(R.id.txt_nombrecerdo);
        et_FechaNace = findViewById(R.id.txt_fechanace);
        et_Peso = findViewById(R.id.txt_peso);
        et_Raza = findViewById(R.id.txt_raza);
        et_Sexo = findViewById(R.id.txt_sexo);

        et_tipo = findViewById(R.id.et_tipo);
        et_nombreMed = findViewById(R.id.et_nombreMed);
        et_via = findViewById(R.id.et_via);
        et_dosis = findViewById(R.id.et_dosis);
        et_fecha = findViewById(R.id.et_Fecha);

        et_idhembra = findViewById(R.id.et_idhembra);
        et_idverraco = findViewById(R.id.et_idverraco);
        et_idpajilla = findViewById(R.id.et_idpajilla);
        et_fechacelo = findViewById(R.id.et_fechacelo);
        et_fechamonta = findViewById(R.id.et_fechamonta);
        et_tipomonta = findViewById(R.id.et_tipomonta);


        btnConsultar.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Cerdo miCerdo = new Cerdo(getApplicationContext());
                SanidadCerdo misanidad = new SanidadCerdo(getApplicationContext());
                reproduccion mireproduccion = new reproduccion(getApplicationContext());

                String Codigo= et_Codigo.getText().toString();

                if(!clsUtil.bValidaString( Codigo,1))
                    Toast.makeText(getBaseContext(),"Debe digitar el código o el nombre del cerdo",Toast.LENGTH_SHORT).show();
                else{
                    if(miCerdo.existCerdo(Codigo)) {
                        miCerdo = miCerdo.getCerdoByView(Codigo);
                        misanidad = misanidad.getSanidadCerdo(miCerdo.getIdCerdo());
                        mireproduccion = mireproduccion.getreproduccionByTable(String.valueOf(miCerdo.getIdCerdo()));

                        et_NombreCerdo.setText(miCerdo.getStrCodigo());
                        et_FechaNace.setText(miCerdo.getStrFechaNace());
                        et_Peso.setText(String.valueOf(miCerdo.getlPesoNace()));
                        et_Raza.setText(miCerdo.getStrRaza());
                        et_Sexo.setText(miCerdo.getStrSexo());

                        if(misanidad.existSanidadCerdoByIdCerdo(miCerdo.getIdCerdo())) {

                            et_tipo.setText(misanidad.getStrTipoMedicamento());
                            et_nombreMed.setText(misanidad.getStrNombreMedicamento());
                            et_via.setText(misanidad.getStrViaAdministracion());
                            et_dosis.setText(String.valueOf(misanidad.getdDosis()));
                            et_fecha.setText(misanidad.getStrFechaAdministracion());

                        }else {
                            et_tipo.setText("");
                            et_nombreMed.setText("");
                            et_via.setText("");
                            et_dosis.setText("");
                            et_fecha.setText("");
                            Toast.makeText(getBaseContext(),"No existe Información de Sanidad asociada a éste Código",Toast.LENGTH_SHORT).show();
                        }
                         if (mireproduccion.existReproduccion(miCerdo.getIdCerdo())) {

                                et_idhembra.setText(String.valueOf(mireproduccion.getIdHembra()));
                                et_idverraco.setText(String.valueOf(mireproduccion.getIdVerraco()));
                                et_idpajilla.setText(String.valueOf(mireproduccion.getIdPajilla()));
                                et_fechacelo.setText(mireproduccion.getStrFechaCelo());
                                et_fechamonta.setText(mireproduccion.getStrFechaMonta());
                                et_tipomonta.setText(mireproduccion.getStrTipoMonta());

                                Toast.makeText(getBaseContext(),"No existe Información de Reproducción asociada a éste Código",Toast.LENGTH_SHORT).show();
                            } else {
                                et_idhembra.setText("");
                                et_idverraco.setText("");
                                et_idpajilla.setText("");
                                et_fechacelo.setText("");
                                et_fechamonta.setText("");
                                et_tipomonta.setText("");
                            }

                        Toast.makeText(getBaseContext(),"Éstos son los datos asociados a ese Animal",Toast.LENGTH_SHORT).show();
                    }else {
                        et_NombreCerdo.setText("");
                        et_FechaNace.setText("");
                        et_Peso.setText("");
                        et_Raza.setText("");
                        et_Sexo.setText("");
                        Toast.makeText(getBaseContext(),"No existe un cerdo asociado a ese código, por favor vuelva a intentarlo",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}