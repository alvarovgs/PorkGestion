package com.example.a201495_2.porkgestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;

public class consultacerdo extends AppCompatActivity {

    EditText campoIdConsulta,campoNombreConsulta,campoFechanaceConsulta,campoPesonaceConsulta;
    spinAdapter sp_AdapterRaza;
    spinAdapter sp_AdapterSexo;
    spinAdapter sp_AdapterPadre;
    spinAdapter sp_AdapterMadre;
    Spinner comboRazas, comboSexo, comboPadre, comboMadre;
    int idRaza = 0;
    String strSexo="";
    int idPadre = 0;
    int idMadre = 0;
    private clsUtilidades objUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultacerdo);

        campoIdConsulta= findViewById(R.id.campoIdConsulta);
        campoNombreConsulta= findViewById(R.id.campoNombreConsulta);
        campoFechanaceConsulta= findViewById(R.id.campoFechanaceConsulta);
        campoPesonaceConsulta= findViewById(R.id.campoPesonaceConsulta);
        comboRazas = findViewById(R.id.campoRazaConsulta);
        comboSexo = findViewById(R.id.campoSexoConsulta);
        comboPadre= findViewById(R.id.campoNombrepadreConsulta);
        comboMadre= findViewById(R.id.campoNombremadreConsulta);

        SpinData Sexo[] = new SpinData(getApplicationContext()).getSexoCerdo();
        sp_AdapterSexo = new spinAdapter(this, android.R.layout.simple_spinner_item, Sexo);
        comboSexo.setAdapter(sp_AdapterSexo);


        SpinData Razas[] = new SpinData(getApplicationContext()).getRaza();
        sp_AdapterRaza = new spinAdapter(this, android.R.layout.simple_spinner_item, Razas);
        comboRazas.setAdapter(sp_AdapterRaza );

        llenarcombo ();

        comboRazas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_AdapterRaza.getItem(position);
                idRaza = sp_item.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        comboSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_AdapterSexo.getItem(position);
                strSexo = sp_item.getValor();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        comboPadre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_AdapterPadre.getItem(position);
                idPadre = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        comboMadre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_AdapterMadre.getItem(position);
                idMadre = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
                //consultarSql();
                break;
            case R.id.btnLimpiar:
                limpiar();
                break;
            case R.id.btnActualizar: actualizarCerdo();
                break;
            case R.id.btnEliminar: eliminarCerdo();
                break;
        }
    }

    private void eliminarCerdo() {
        Cerdo micerdo=new Cerdo(getApplicationContext());
        micerdo.setIdCerdo(Integer.parseInt(campoIdConsulta.getText().toString()));
        if (micerdo.deleteCerdo()){
            Toast.makeText(getApplicationContext(),"Cerdo eliminado correctamente ",Toast.LENGTH_LONG).show();
            limpiar();
        }
        else {
            Toast.makeText(getApplicationContext(),"Error eliminando el cerdo ",Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizarCerdo() {
        Cerdo micerdo=new Cerdo(getApplicationContext());
        micerdo = micerdo.getCerdoByView(campoIdConsulta.getText().toString());
        micerdo.setStrCodigo(campoNombreConsulta.getText().toString());
        micerdo.setStrFechaNace(campoFechanaceConsulta.getText().toString());
        micerdo.setlPesoNace(Long.parseLong(campoPesonaceConsulta.getText().toString()));
        micerdo.setStrSexo(strSexo);
        micerdo.setIdRaza(idRaza);
        micerdo.setIdMadre(idMadre);
        micerdo.setIdPadre(idPadre);
        if (micerdo.updateCerdo()){
            Toast.makeText(getApplicationContext(),"Cerdo actualizado correctamente ",Toast.LENGTH_LONG).show();
            limpiar();
        }
        else {
            Toast.makeText(getApplicationContext(),"Error actualizando el cerdo ",Toast.LENGTH_SHORT).show();
        }

    }


    private void consultar() {
        Cerdo micerdo=new Cerdo(getApplicationContext());
        if (micerdo.existCerdo(campoIdConsulta.getText().toString())){
            micerdo = micerdo.getCerdoByView(campoIdConsulta.getText().toString());
            campoNombreConsulta.setText(micerdo.getStrCodigo());
            campoFechanaceConsulta.setText(micerdo.getStrFechaNace());
            campoPesonaceConsulta.setText(String.valueOf(micerdo.getlPesoNace()));
            comboSexo.setSelection(objUtil.obtenerPosicionItem(comboSexo, micerdo.getStrSexo()));
            comboRazas.setSelection(objUtil.obtenerPosicionItem(comboRazas, micerdo.getStrRaza()));
            comboPadre.setSelection(objUtil.obtenerPosicionItem(comboPadre, micerdo.getStrCodPadre()));
            comboMadre.setSelection(objUtil.obtenerPosicionItem(comboMadre, micerdo.getStrCodMadre()));
        }
        else {
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
        }
    }

    private void llenarcombo(){
        SpinData Padre[] = new SpinData(getApplicationContext()).getCerdobySexo("MACHO");
        sp_AdapterPadre = new spinAdapter(this, android.R.layout.simple_spinner_item, Padre);
        comboPadre.setAdapter(sp_AdapterPadre);
        SpinData Madre[] = new SpinData(getApplicationContext()).getCerdobySexo("HEMBRA");
        sp_AdapterMadre = new spinAdapter(this, android.R.layout.simple_spinner_item, Madre);
        comboMadre.setAdapter(sp_AdapterMadre);
    }

    private void limpiar() {
        llenarcombo ();
        campoIdConsulta.setText("");
        campoNombreConsulta.setText("");
        campoFechanaceConsulta.setText("");
        campoPesonaceConsulta.setText("");
        comboSexo.setSelection(0);
        comboRazas.setSelection(0);
        comboPadre.setSelection(0);
        comboMadre.setSelection(0);
        campoIdConsulta.requestFocus();

    }



}
