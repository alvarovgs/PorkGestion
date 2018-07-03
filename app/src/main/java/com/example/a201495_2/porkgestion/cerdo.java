package com.example.a201495_2.porkgestion;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;
import com.example.a201495_2.porkgestion.utils.Tools;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;

import java.util.Calendar;

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
    private  int dia,mes,ano;
    private clsUtilidades clsUtil = new clsUtilidades();


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

        findViewById(R.id.campoFechanace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDatePickerLight((TextView) view);
            }
        });

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
        if(!clsUtil.bValidaString(campoNombre.getText().toString(),1)) {
            Toast.makeText(getBaseContext(), "Debe digitar el nombre del cerdo", Toast.LENGTH_SHORT).show();
        }
        else if(!clsUtil.bValidaString(campoFechanace.getText().toString(),1)) {
            Toast.makeText(getBaseContext(), "Debe digitar la fecha de nacimiento del cerdo", Toast.LENGTH_SHORT).show();
        }
        else if(!clsUtil.bValidaString(campoPesonace.getText().toString(),1)) {
            Toast.makeText(getBaseContext(), "Debe digitar el peso al nacimiento del cerdo", Toast.LENGTH_SHORT).show();
        }
        else if(comboSexo.getSelectedItemPosition()==0) {
            Toast.makeText(getBaseContext(), "Debe seleccionar el sexo del cerdo", Toast.LENGTH_SHORT).show();
        }
        else if(idRaza==0) {
            Toast.makeText(getBaseContext(), "Debe seleccionar la raza del cerdo", Toast.LENGTH_SHORT).show();
        }
        else if(idMadre==0) {
            Toast.makeText(getBaseContext(), "Debe seleccionar la madre del cerdo", Toast.LENGTH_SHORT).show();
        }
        else if(idPadre==0) {
            Toast.makeText(getBaseContext(), "Debe seleccionar el padre del cerdo", Toast.LENGTH_SHORT).show();
        }
        else {

            Cerdo micerdo = new Cerdo(getApplicationContext());
            micerdo.setStrCodigo(campoNombre.getText().toString());
            micerdo.setStrFechaNace(campoFechanace.getText().toString());
            micerdo.setlPesoNace(Long.parseLong(campoPesonace.getText().toString()));
            micerdo.setStrSexo(strSexo);
            micerdo.setIdRaza(idRaza);
            micerdo.setIdMadre(idMadre);
            micerdo.setIdPadre(idPadre);
            if (micerdo.insertCerdo()) {
                Toast.makeText(getApplicationContext(), "Cerdo registrado correctamente ", Toast.LENGTH_LONG).show();
                limpiar();
            } else {
                Toast.makeText(getApplicationContext(), "Error registrando el cerdo ", Toast.LENGTH_SHORT).show();
            }
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

    private void dialogDatePickerLight(final TextView tv) {
        Calendar cur_calender = Calendar.getInstance();
        com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePicker = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
                new com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        long date_ship_millis = calendar.getTimeInMillis();
                        tv.setText(Tools.getFormattedDateSimple(date_ship_millis));
                    }
                },
                cur_calender.get(Calendar.YEAR),
                cur_calender.get(Calendar.MONTH),
                cur_calender.get(Calendar.DAY_OF_MONTH)
        );
        //set dark light
        datePicker.setThemeDark(false);
        datePicker.setAccentColor(getResources().getColor(R.color.colorPrimary));
        //datePicker.setMinDate(cur_calender);
        datePicker.show(getFragmentManager(), "Datepickerdialog");
    }
}