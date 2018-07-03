package com.example.a201495_2.porkgestion;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.example.a201495_2.porkgestion.adapter.sanidadAdapter;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.Sanidad;
import com.example.a201495_2.porkgestion.bo_clases.SanidadCerdo;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;

import java.util.ArrayList;

public class SanidadActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ListView lvSanidadResult;
    private ArrayList<Sanidad> arrListSanidad = new ArrayList<Sanidad>();
    private int idSanidad=0;
    private String strTipoMed;
    private clsUtilidades objUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanidad);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(new Sanidad(getApplicationContext()));
            }
        });
        displayResult();

        lvSanidadResult.setClickable(true);
        lvSanidadResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Sanidad objItemSanidad = arrListSanidad.get(position);
                showCustomDialog(objItemSanidad);
            }

        });
    }

    private void displayResult(){
        Sanidad objSanidad = new Sanidad(getApplicationContext());
        arrListSanidad = objSanidad.getAllSanidad();
        lvSanidadResult = findViewById(R.id.list_sanidadresult);
        lvSanidadResult.setAdapter(new sanidadAdapter(getApplicationContext(), arrListSanidad ));
    }


    private void showCustomDialog(Sanidad objSanidad) {
        final Dialog dialog = new Dialog(this);
        final spinAdapter sp_Adapter;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_sanidad);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        TextView lbltitulo = dialog.findViewById(R.id.lblTitulo);
        final TextView lblError = dialog.findViewById(R.id.lblError);
        final Spinner sp_tipoMed = dialog.findViewById(R.id.sp_tipoMed);
        final EditText et_nombreMed = dialog.findViewById(R.id.et_nombreMed);
        final EditText et_descMed = dialog.findViewById(R.id.et_descMed);

        sp_tipoMed.setOnItemSelectedListener(null);

        lbltitulo.setText("Gestión de medicamentos");

        SpinData TipoMed[] = new SpinData(getApplicationContext()).getTipoMed();
        sp_Adapter = new spinAdapter(this, android.R.layout.simple_spinner_item, TipoMed);
        sp_tipoMed.setAdapter(sp_Adapter);

        sp_tipoMed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_Adapter.getItem(position);
                strTipoMed = sp_item.getValor();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        sp_tipoMed.setSelection(objUtil.obtenerPosicionItem(sp_tipoMed, objSanidad.getStrTipoMedicamento()));
        et_nombreMed.setText(objSanidad.getStrNombreMedicamento());
        et_descMed.setText(objSanidad.getStrObservaciones());
        idSanidad = objSanidad.getIdSanidad();

        dialog.findViewById(R.id.bt_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.bt_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sanidad objClass =new Sanidad(getApplicationContext());
                String strNombreMed = et_nombreMed.getText().toString();
                //Si tengo IDSanidad es para actualziar
                if(idSanidad>0){
                    objClass.setIdSanidad(idSanidad);
                    objClass.setStrTipoMedicamento(strTipoMed);
                    objClass.setStrNombreMedicamento(strNombreMed);
                    objClass.setStrObservaciones(et_descMed.getText().toString());
                    objClass.updateSanidad();
                    displayResult();
                    dialog.dismiss();
                }
                else {
                    if (objClass.existSanidad(strNombreMed)) {
                        lblError.setText(String.format("Ya existe el medicamento %s en el sistema.", strNombreMed));
                    } else {
                        objClass.setStrTipoMedicamento(strTipoMed);
                        objClass.setStrNombreMedicamento(strNombreMed);
                        objClass.setStrObservaciones(et_descMed.getText().toString());
                        objClass.insertSanidad();
                        displayResult();
                        dialog.dismiss();
                    }
                }
            }
        });

        dialog.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanidadCerdo objClassTemp =new SanidadCerdo(getApplicationContext());
                Sanidad objClass =new Sanidad(getApplicationContext());
                if (objClassTemp.existSanidadCerdoByIdSanidad(idSanidad)) {
                    lblError.setText("No es posible borrar el medicamento,  está atado al registro médico de un cerdo.");
                }
                else{
                    objClass.setIdSanidad(idSanidad);
                    objClass.deleteSanidad();
                    displayResult();
                    dialog.dismiss();
                }
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
