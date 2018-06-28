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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.bo_clases.Raza;
import com.example.a201495_2.porkgestion.adapter.razaAdapter;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;

import java.util.ArrayList;

public class RazaActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    private ListView lvRazaResult;
    private ArrayList<Raza> arrListRaza = new ArrayList<>();
    private int idRaza=0;
    private ArrayAdapter<String> razaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(new Raza(getApplicationContext()));
            }
        });
        displayResult();

        lvRazaResult.setClickable(true);
        lvRazaResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Raza objItemRaza = (Raza)arrListRaza.get(position);
                showCustomDialog(objItemRaza);
            }
        });
    }

    private void displayResult(){
        Raza objRaza = new Raza(getApplicationContext());
        arrListRaza = objRaza.getAllRaza();
        lvRazaResult = (ListView) findViewById(R.id.list_razaResult);
        lvRazaResult.setAdapter(new razaAdapter(getApplicationContext(), arrListRaza));
    }


    private void showCustomDialog(Raza objRaza) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_raza);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        TextView lbltitulo = dialog.findViewById(R.id.lblTitulo);
        final TextView lblError = (TextView) dialog.findViewById(R.id.lblError);
        final EditText et_nombreRaza = (EditText) dialog.findViewById(R.id.et_nombreRaza);
        final EditText et_origenRaza = (EditText) dialog.findViewById(R.id.et_origenRaza);
        final EditText et_descRaza = (EditText) dialog.findViewById(R.id.et_descRaza);

        lbltitulo.setText("Gestión de razas");

        et_nombreRaza.setText(objRaza.getStrRaza());
        et_origenRaza.setText(objRaza.getStrOrigen());
        et_descRaza.setText(objRaza.getStrDescripcion());
        idRaza = objRaza.getIdRaza();

        ((Button) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.bt_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Raza objClass = new Raza(getApplicationContext());
                String strNombreRaza = et_nombreRaza.getText().toString();

                //Si tengo ISRaza es para actualziar
                if(idRaza >0){
                    objClass.setIdRaza(idRaza);
                    objClass.setStrRaza(strNombreRaza);
                    objClass.setStrOrigen(et_origenRaza.getText().toString());
                    objClass.setStrDescripcion(et_descRaza.getText().toString());
                    objClass.updateRaza();
                    displayResult();
                    dialog.dismiss();
                }
                else {
                    if (objClass.existRaza(strNombreRaza)) {
                        lblError.setText(String.format("Ya existe la raza %s en el sistema.", strNombreRaza));
                    } else {
                        objClass.setStrRaza(strNombreRaza);
                        objClass.setStrOrigen(et_origenRaza.getText().toString());
                        objClass.setStrDescripcion(et_descRaza.getText().toString());
                        objClass.insertRaza();
                        displayResult();
                        dialog.dismiss();
                    }
                }
            }
        });

        ((Button) dialog.findViewById(R.id.bt_delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cerdo objClassTemp=new Cerdo(getApplicationContext());
                Raza objClass =new Raza(getApplicationContext());
                if (objClassTemp.existCerdoByRaza(idRaza)) {
                    lblError.setText("No es posible borrar el registro,  existen cerdo creados con esta raza.");
                }
                else{
                    objClass.setIdRaza(idRaza);
                    objClass.deleteRaza();
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
