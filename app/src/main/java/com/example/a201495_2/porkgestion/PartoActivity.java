package com.example.a201495_2.porkgestion;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.adapter.partoAdapter;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.Parto;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;

import java.util.ArrayList;

public class PartoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ListView lvPartoResult;
    private ArrayList<Parto> arrListParto = new ArrayList<Parto>();
    private int idParto=0;
    private int idCerdo=0;
    private clsUtilidades objUtil = new clsUtilidades();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(new Parto(getApplicationContext()));
            }
        });
        displayResult();
        lvPartoResult.setClickable(true);
        lvPartoResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Parto objItemParto = (Parto) arrListParto.get(position);
                showCustomDialog(objItemParto);
            }
        });
    }


    private void displayResult(){
        Parto objParto = new Parto(getApplicationContext());
        arrListParto = objParto.getAllPartoByView();
        lvPartoResult = (ListView) findViewById(R.id.list_partoresult);
        lvPartoResult.setAdapter(new partoAdapter(getApplicationContext(), arrListParto));
    }

    private void showCustomDialog(Parto objParto) {
        final Dialog dialog = new Dialog(this);
        final spinAdapter sp_Adapter;

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_parto);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        TextView lbltitulo = dialog.findViewById(R.id.lblTitulo);
        final TextView lblError = (TextView) dialog.findViewById(R.id.lblError);

        final Spinner sp_Cerdas = (Spinner) dialog.findViewById(R.id.sp_Cerdas);
        final EditText et_fechaParto = (EditText) dialog.findViewById(R.id.et_FechaParto);
        final EditText et_HembrasMuertas = (EditText) dialog.findViewById(R.id.et_HembrasMuertas);
        final EditText et_HembrasVivas = (EditText) dialog.findViewById(R.id.et_HembrasVivas);
        final EditText et_MachosMuertos = (EditText) dialog.findViewById(R.id.et_MachosMuertos);
        final EditText et_MachosVivos = (EditText) dialog.findViewById(R.id.et_MachosVivos);
        final EditText et_PesoParto = (EditText) dialog.findViewById(R.id.et_PesoParto);

        lbltitulo.setText("Gestión de parto");
        /*llenar el sinner*/
        SpinData Cerdo[] = new SpinData(getApplicationContext()).getCerdo();
        sp_Adapter = new spinAdapter(this, android.R.layout.simple_spinner_item, Cerdo);
        sp_Cerdas.setAdapter(sp_Adapter);

        sp_Cerdas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_Adapter.getItem(position);
                idCerdo = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });


        sp_Cerdas.setSelection(objUtil.obtenerPosicionItem(sp_Cerdas, objParto.getStrCodigoCerdo()));

        et_fechaParto.setText(objParto.getStrFechaParto());
        et_HembrasMuertas.setText(String.valueOf(objParto.getMuertosHembras()));
        et_HembrasVivas.setText(String.valueOf(objParto.getVivosHembras()));
        et_MachosMuertos.setText(String.valueOf(objParto.getMuertosMachos()));
        et_MachosVivos.setText(String.valueOf(objParto.getVivosMachos()));
        et_PesoParto.setText(String.valueOf(objParto.getPromediPeso()));
        idParto = objParto.getIdParto();

        ((Button) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.bt_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parto objClass =new Parto(getApplicationContext());
                //Si tengo idParto es para actualziar
                if(idParto>0){
                    objClass.setIdParto(idParto);
                    objClass.setIdCerdo(idCerdo);
                    objClass.setStrFechaParto(et_fechaParto.getText().toString());
                    objClass.setPromediPeso(Long.parseLong(et_PesoParto.getText().toString()));
                    objClass.setVivosHembras(Integer.parseInt(et_HembrasVivas.getText().toString()));
                    objClass.setVivosMachos(Integer.parseInt(et_MachosVivos.getText().toString()));
                    objClass.setMuertosHembras(Integer.parseInt(et_HembrasMuertas.getText().toString()));
                    objClass.setMuertosMachos(Integer.parseInt(et_MachosMuertos.getText().toString()));
                    objClass.updateParto();
                    displayResult();
                    dialog.dismiss();
                }
                else {
                    objClass.setIdCerdo(idCerdo);
                    objClass.setStrFechaParto(et_fechaParto.getText().toString());
                    objClass.setPromediPeso(Long.parseLong(et_PesoParto.getText().toString()));
                    objClass.setVivosHembras(Integer.parseInt(et_HembrasVivas.getText().toString()));
                    objClass.setVivosMachos(Integer.parseInt(et_MachosVivos.getText().toString()));
                    objClass.setMuertosHembras(Integer.parseInt(et_HembrasMuertas.getText().toString()));
                    objClass.setMuertosMachos(Integer.parseInt(et_MachosMuertos.getText().toString()));
                    objClass.setIndicemortalidad(objClass.indiceMortalidad());
                    objClass.insertParto();
                    displayResult();
                    dialog.dismiss();
                }
            }
        });

        ((Button) dialog.findViewById(R.id.bt_delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parto objClass =new Parto(getApplicationContext());
                objClass.setIdParto(idParto);
                objClass.deleteParto();
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
