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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.adapter.reproduccionAdapter;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.reproduccion;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.utils.Tools;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class gestantes extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ListView lvGestantesResult;
    private ArrayList<reproduccion> arrListreproduccion = new ArrayList<reproduccion>();
    private int idReproduccion=0;
    private int idCerda=0;
    private int idPajilla=0;
    private int idVerraco=0;
    private int idEstado =0;
    private String  strTipoMonta="";
    private clsUtilidades objUtil = new clsUtilidades();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(new reproduccion(getApplicationContext()));
            }
        });
        displayResult();
        lvGestantesResult.setClickable(true);
        lvGestantesResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                reproduccion objItemreproduccion = (reproduccion) arrListreproduccion.get(position);
                showCustomDialog(objItemreproduccion);
            }
        });
    }

    private void displayResult(){
        reproduccion objreproduccion = new reproduccion(getApplicationContext());
        arrListreproduccion = objreproduccion.getAllReproduccionByView();
        lvGestantesResult = (ListView) findViewById(R.id.list_gestacionresult);
        lvGestantesResult.setAdapter(new reproduccionAdapter(getApplicationContext(), arrListreproduccion));
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

    private void showCustomDialog(reproduccion objReproduccion) {
        final Dialog dialog = new Dialog(this);
        final spinAdapter sp_Adapcerda,sp_Adapterverraco,sp_Adapterpajilla,sp_AdapterEstado, sp_AdapTipoMonta;

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_gestantes);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        TextView lbltitulo = dialog.findViewById(R.id.lblTitulo);
        final TextView lblError = (TextView) dialog.findViewById(R.id.lblError);

        final Spinner sp_Cerdas = (Spinner) dialog.findViewById(R.id.sp_idCerda);
        final Spinner sp_tipomonta = (Spinner) dialog.findViewById(R.id.sp_tipomonta);
        final EditText fechamonta = (EditText) dialog.findViewById(R.id.FechaMonta);
        final Spinner sp_idverraco = (Spinner) dialog.findViewById(R.id.sp_idverraco);
        final Spinner sp_idpajilla = (Spinner) dialog.findViewById(R.id.sp_idPajilla);
        final Spinner sp_estado = (Spinner) dialog.findViewById(R.id.sp_estadoprenez);
        idReproduccion = objReproduccion.getIdReproduccion();

        lbltitulo.setText("Gestión de reproduccion");
        /*llenar el sinner de cerdas*/
        SpinData Cerda[] = new SpinData(getApplicationContext()).getCerdobySexo("HEMBRA");
        sp_Adapcerda = new spinAdapter(this, android.R.layout.simple_spinner_item, Cerda);
        sp_Cerdas.setAdapter(sp_Adapcerda);

        /*llenar el sinner de tipomonta*/
        SpinData TipoMonta[] = new SpinData(getApplicationContext()).getTipoMonta();
        sp_AdapTipoMonta = new spinAdapter(this, android.R.layout.simple_spinner_item, TipoMonta);
        sp_tipomonta.setAdapter(sp_AdapTipoMonta);

        /*llenar el sinner de veerracos*/
        SpinData Verraco[] = new SpinData(getApplicationContext()).getCerdobySexo("MACHO");
        sp_Adapterverraco= new spinAdapter(this, android.R.layout.simple_spinner_item, Verraco);
        sp_idverraco.setAdapter(sp_Adapterverraco);

        /*llenar el sinner de pajilla*/
        SpinData Pajilla[] = new SpinData(getApplicationContext()).getPajilla();
        sp_Adapterpajilla = new spinAdapter(this, android.R.layout.simple_spinner_item, Pajilla);
        sp_idpajilla.setAdapter(sp_Adapterpajilla);

        /*llenar el sinner de estado*/
        SpinData estadoMonta[] = new SpinData(getApplicationContext()).getEstadoMonta();
        sp_AdapterEstado= new spinAdapter(this, android.R.layout.simple_spinner_item, estadoMonta);
        sp_estado.setAdapter(sp_AdapterEstado);

        //ageregar metodos para capturar la selección de cada spnner

        sp_Cerdas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_Adapcerda.getItem(position);
                idCerda = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapcerda) {  }
        });

        sp_tipomonta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_AdapTipoMonta.getItem(position);
                strTipoMonta = sp_item.getValor();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapcerda) {  }
        });

        sp_idverraco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_Adapterverraco.getItem(position);
                idVerraco = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapterverraco) {  }
        });

        sp_idpajilla.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_Adapterpajilla.getItem(position);
                idPajilla = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        sp_estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_AdapterEstado.getItem(position);
                idEstado = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });

        //Ubicar los combos en la posicion correcta según el el item seleccionado

        sp_Cerdas.setSelection(objUtil.obtenerPosicionItem(sp_Cerdas, objReproduccion.getStrCodigoHembra()));

        sp_tipomonta.setSelection(objUtil.obtenerPosicionItem(sp_tipomonta, objReproduccion.getStrTipoMonta ()));

        sp_idverraco.setSelection(objUtil.obtenerPosicionItem(sp_idverraco, objReproduccion.getStrCodigoVerraco()));

        sp_idpajilla.setSelection(objUtil.obtenerPosicionItem(sp_idpajilla, objReproduccion.getStrCodigoPajilla()));

        sp_estado.setSelection(objUtil.obtenerPosicionItem(sp_estado, objReproduccion.getstrEstado()));

        fechamonta.setText(objReproduccion.getStrFechaMonta());
        ((TextView) dialog.findViewById(R.id.FechaMonta)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDatePickerLight((TextView) view);
            }
        });


        ((Button) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ((Button) dialog.findViewById(R.id.bt_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproduccion objClass =new reproduccion(getApplicationContext());
                //Si tengo idreproduccion es para actualziar
                if(idReproduccion>0){
                    objClass.setIdReproduccion(idReproduccion);
                    objClass.setIdHembra(idCerda);
                    objClass.setStrTipoMonta(strTipoMonta);
                    objClass.setStrFechaMonta(fechamonta.getText().toString());
                    objClass.setIdPajilla(idPajilla);
                    objClass.setIdVerraco(idVerraco);
                    objClass.setIdEstado(idEstado);
                    objClass.updateReproduccion();
                    displayResult();
                    dialog.dismiss();
                }
                else {
                    objClass.setIdHembra(idCerda);
                    objClass.setStrTipoMonta(strTipoMonta);
                    objClass.setStrFechaMonta(fechamonta.getText().toString());
                    objClass.setIdPajilla(idPajilla);
                    objClass.setIdVerraco(idVerraco);
                    objClass.setIdEstado(idEstado);
                    objClass.insertReproduccion();
                    displayResult();
                    dialog.dismiss();
                }
            }
        });

        ((Button) dialog.findViewById(R.id.bt_delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproduccion objClass =new reproduccion(getApplicationContext());
                objClass.setIdReproduccion(idReproduccion);
                objClass.deleteReproduccion();
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
