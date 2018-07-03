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
import android.widget.Toast;

import com.example.a201495_2.porkgestion.adapter.partoAdapter;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.utils.Tools;
import com.example.a201495_2.porkgestion.bo_clases.Parto;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Gestión de Partos");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
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
                Parto objItemParto = arrListParto.get(position);
                showCustomDialog(objItemParto);
            }
        });
    }

    private void displayResult(){
        Parto objParto = new Parto(getApplicationContext());
        arrListParto = objParto.getAllPartoByView();
        lvPartoResult = findViewById(R.id.list_partoresult);
        lvPartoResult.setAdapter(new partoAdapter(getApplicationContext(), arrListParto));
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
        final TextView lblError = dialog.findViewById(R.id.lblError);

        final Spinner sp_Cerdas = dialog.findViewById(R.id.sp_Cerdas);
        final EditText et_fechaParto = dialog.findViewById(R.id.et_FechaParto);
        final EditText et_HembrasMuertas = dialog.findViewById(R.id.et_HembrasMuertas);
        final EditText et_HembrasVivas = dialog.findViewById(R.id.et_HembrasVivas);
        final EditText et_MachosMuertos = dialog.findViewById(R.id.et_MachosMuertos);
        final EditText et_MachosVivos = dialog.findViewById(R.id.et_MachosVivos);
        final EditText et_PesoParto = dialog.findViewById(R.id.et_PesoParto);

        lbltitulo.setText("Gestión de parto");
        /*llenar el sinner*/
        SpinData Cerdo[] = new SpinData(getApplicationContext()).getCerdobySexo("HEMBRA");
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

        dialog.findViewById(R.id.et_FechaParto).setOnClickListener(new View.OnClickListener() {
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
                    if((idCerdo==0)||(et_fechaParto.getText().toString().equals(""))) {
                        Toast.makeText(getApplicationContext(),"Selecciones todos los datos del parto",Toast.LENGTH_SHORT).show();
                    }
                    else{
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
            }
        });

        dialog.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
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
