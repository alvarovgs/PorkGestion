package com.example.a201495_2.porkgestion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;

public class  cerdo extends AppCompatActivity {
    EditText campoId,campoNombre,campoFechanace,campoPesonace;
    spinAdapter sp_AdapterRaza;
    spinAdapter sp_AdapterSexo;
    spinAdapter sp_AdapterPadre;
    spinAdapter sp_AdapterMadre;
    Spinner comboRazas, comboSexo, comboPadre, comboMadre;
    int idRaza = 0;
    String strSexo="";
    int idPadre = 0;
    int idMadre = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerdo);

        campoNombre= findViewById(R.id.campoNombre);
        campoFechanace= findViewById(R.id.campoFechanace);
        campoPesonace= findViewById(R.id.campoPesonace);
        comboRazas = findViewById(R.id.comboRazas);
        comboSexo = findViewById(R.id.comboSexo);
        comboPadre= findViewById(R.id.comboPadre);
        comboMadre= findViewById(R.id.comboMadre);

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
        registrarCerdo();
    }

    private void registrarCerdo() {
        //instanciar el objeto de la clase cerdo
        Cerdo micerdo=new Cerdo(getApplicationContext());
        micerdo.setStrCodigo(campoNombre.getText().toString());
        micerdo.setStrFechaNace(campoFechanace.getText().toString());
        micerdo.setlPesoNace(Long.parseLong(campoPesonace.getText().toString()));
        micerdo.setStrSexo(strSexo);
        micerdo.setIdRaza(idRaza);
        micerdo.setIdMadre(idMadre);
        micerdo.setIdPadre(idPadre);
        if (micerdo.insertCerdo()){
            Toast.makeText(getApplicationContext(),"Cerdo registrado correctamente ",Toast.LENGTH_LONG).show();
            limpiar();
        }
        else {
            Toast.makeText(getApplicationContext(),"Error registrando el cerdo ",Toast.LENGTH_SHORT).show();
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
        campoNombre.setText("");
        campoFechanace.setText("");
        campoPesonace.setText("");
        comboSexo.setSelection(0);
        comboRazas.setSelection(0);
        comboPadre.setSelection(0);
        comboMadre.setSelection(0);
        campoNombre.requestFocus();

    }


}