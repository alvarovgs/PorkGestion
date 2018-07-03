package com.example.a201495_2.porkgestion;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.adapter.sanidadCerdoAdapter;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.Sanidad;
import com.example.a201495_2.porkgestion.bo_clases.SanidadCerdo;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.utils.Tools;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class SanidadCerdoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ListView lvSanidadCerdoResult;
    private ArrayList<SanidadCerdo> arrListSanidad = new ArrayList<SanidadCerdo>();
    private int idSanidad=0;
    private int idCerdo=0;
    private int idCerdoInicial=0;
    private int idSanidadInicial=0;
    private String strFechaInicial="";
    private clsUtilidades objUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanidad_cerdo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Gestión de Sanidad");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(new SanidadCerdo(getApplicationContext()));
            }
        });
        displayResult();

        lvSanidadCerdoResult.setClickable(true);
        lvSanidadCerdoResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                SanidadCerdo objItemSanidad = arrListSanidad.get(position);
                showCustomDialog(objItemSanidad);
            }

        });

    }

    private void displayResult(){
        SanidadCerdo objSanidad = new SanidadCerdo(getApplicationContext());
        arrListSanidad = objSanidad.getAllSanidadCerdo();
        lvSanidadCerdoResult = findViewById(R.id.list_sanidadCerdoResult);
        lvSanidadCerdoResult.setAdapter(new sanidadCerdoAdapter(getApplicationContext(), arrListSanidad ));
    }

    private void dialogDatePickerLight(final TextView tv) {
        Calendar cur_calender = Calendar.getInstance();
        DatePickerDialog datePicker = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
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

    private void showCustomDialog(SanidadCerdo objSanidad) {
        final Dialog dialog = new Dialog(this);
        final spinAdapter CerdoAdapter, SanidadAdapter ;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_sanidad_cerdo);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        TextView lbltitulo = dialog.findViewById(R.id.lblTitulo);
        final TextView lblError = dialog.findViewById(R.id.lblError);
        final Spinner sp_Cerdo = dialog.findViewById(R.id.sp_Cerdo);
        final Spinner sp_nombreMed = dialog.findViewById(R.id.sp_nombreMed);
        final EditText et_FechaAdmin = dialog.findViewById(R.id.et_FechaAdmin);
        final EditText et_Dosis = dialog.findViewById(R.id.et_Dosis);
        final EditText et_ViaAdmin = dialog.findViewById(R.id.et_ViaAdmin);
        idSanidadInicial=objSanidad.getIdSanidad();
        idCerdoInicial=objSanidad.getIdCerdo();
        strFechaInicial=objSanidad.getStrFechaAdministracion();
        lbltitulo.setText("Sanidad por Cerdo");

        SpinData Cerdo[] = new SpinData(getApplicationContext()).getCerdo();
        CerdoAdapter = new spinAdapter(this, android.R.layout.simple_spinner_item, Cerdo);
        sp_Cerdo.setAdapter(CerdoAdapter);

        SpinData Medicamento[] = new SpinData(getApplicationContext()).getMedicamento();
        SanidadAdapter = new spinAdapter(this, android.R.layout.simple_spinner_item, Medicamento);
        sp_nombreMed.setAdapter(SanidadAdapter );

        sp_Cerdo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = CerdoAdapter.getItem(position);
                idCerdo = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        sp_nombreMed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = SanidadAdapter .getItem(position);
                idSanidad = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        sp_Cerdo.setSelection(objUtil.obtenerPosicionItem(sp_Cerdo, objSanidad.getStrCodigoCerdo()));
        sp_nombreMed.setSelection(objUtil.obtenerPosicionItem(sp_nombreMed, objSanidad.getStrNombreMedicamento()));

        et_FechaAdmin.setText(objSanidad.getStrFechaAdministracion());
        et_Dosis.setText(objSanidad.getStrDosis());
        et_ViaAdmin.setText(objSanidad.getStrViaAdministracion());

        ((TextView) dialog.findViewById(R.id.et_FechaAdmin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDatePickerLight((TextView) view);
            }
        });

        dialog.findViewById(R.id.bt_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.bt_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanidadCerdo objClass = new SanidadCerdo(getApplicationContext());
                //Si tengo IDSanidad es para actualziar
                if(idSanidadInicial>0){
                    objClass.setIdCerdoPK(idCerdoInicial);
                    objClass.setIdSanidadPK(idSanidadInicial);
                    objClass.setStrFechaAdministracionPK(strFechaInicial);
                    objClass.setIdSanidad(idSanidad);
                    objClass.setIdCerdo(idCerdo);
                    objClass.setStrFechaAdministracion(et_FechaAdmin.getText().toString());
                    objClass.setStrDosis(et_Dosis.getText().toString());
                    objClass.setStrViaAdministracion(et_ViaAdmin.getText().toString());
                    objClass.updateSanidadCerdo();
                    Toast.makeText(getApplicationContext(),"Registro Actualizado",Toast.LENGTH_LONG).show();
                    displayResult();
                    dialog.dismiss();
                }
                else {
                    if(!objClass.existSanidadCerdoByIdSanidadCerdo(idSanidad,idCerdo, et_FechaAdmin.getText().toString())) {
                        objClass.setIdSanidad(idSanidad);
                        objClass.setIdCerdo(idCerdo);
                        objClass.setStrFechaAdministracion(et_FechaAdmin.getText().toString());
                        objClass.setStrDosis(et_Dosis.getText().toString());
                        objClass.setStrViaAdministracion(et_ViaAdmin.getText().toString());
                        objClass.insertSanidadCerdo();
                        Toast.makeText(getApplicationContext(),"Registro Agregado",Toast.LENGTH_LONG).show();
                        displayResult();
                        dialog.dismiss();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Ya existe un registro para el cerdo, la fecha y el medicamento seleccionado",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        dialog.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanidadCerdo objClass =new SanidadCerdo(getApplicationContext());
                objClass.setIdSanidadPK(idSanidadInicial);
                objClass.setIdCerdoPK(idCerdoInicial);
                objClass.setStrFechaAdministracionPK(strFechaInicial);
                objClass.deleteSanidadCerdo();
                displayResult();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
