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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.adapter.pajillaAdapter;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.Pajilla;
import com.example.a201495_2.porkgestion.bo_clases.Raza;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;

import java.util.ArrayList;

public class PajillaActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    private ListView lvPajillaResult;
    private ArrayList<Pajilla> arrListPajilla = new ArrayList<Pajilla>();
    private int idPajilla=0;
    private int idRaza=0;
    private clsUtilidades objUtil = new clsUtilidades();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pajilla);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Gestión de Pajillas");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(new Pajilla(getApplicationContext()));
            }
        });
        displayResult();
        lvPajillaResult.setClickable(true);
        lvPajillaResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Pajilla objItemPajilla = arrListPajilla.get(position);
                showCustomDialog(objItemPajilla);
            }
        });
    }

    private void displayResult(){
        Pajilla objPajilla = new Pajilla(getApplicationContext());
        arrListPajilla = objPajilla.getAllPajillaByView();
        lvPajillaResult = findViewById(R.id.list_pajillaresult);
        lvPajillaResult.setAdapter(new pajillaAdapter(getApplicationContext(), arrListPajilla ));
    }


    private void showCustomDialog(Pajilla objPajilla) {
        final Dialog dialog = new Dialog(this);
        final spinAdapter sp_Adapter;
        ArrayAdapter<String> pajillaAdapter;
        ArrayList listRazaSql =new ArrayList<Raza>();
        Raza objRaza = new Raza(getApplicationContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_pajilla);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        TextView lbltitulo = dialog.findViewById(R.id.lblTitulo);
        final TextView lblError = dialog.findViewById(R.id.lblError);
        final Spinner sp_razaPajilla = dialog.findViewById(R.id.sp_razaPajilla);
        final EditText et_fechaVencePajilla = dialog.findViewById(R.id.et_fechaVencePajilla);
        final EditText et_codigoPajilla = dialog.findViewById(R.id.et_codigoPajilla);

        lbltitulo.setText("Gestión de pajillas");
        /*llenar el sinner*/
        SpinData Razas[] = new SpinData(getApplicationContext()).getRaza();
        sp_Adapter = new spinAdapter(this, android.R.layout.simple_spinner_item, Razas);
        sp_razaPajilla.setAdapter(sp_Adapter);

        sp_razaPajilla.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_Adapter.getItem(position);
                idRaza = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });


        sp_razaPajilla.setSelection(objUtil.obtenerPosicionItem(sp_razaPajilla, objPajilla.getStrNombreRaza()));

        et_fechaVencePajilla.setText(objPajilla.getStrFechaVence());
        et_codigoPajilla.setText(objPajilla.getStrCodigoPajilla());
        idPajilla = objPajilla.getIdPajilla();

        dialog.findViewById(R.id.bt_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.bt_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pajilla objClass =new Pajilla(getApplicationContext());
                String strCodigoPajilla = et_codigoPajilla.getText().toString();
                //Si tengo IDPajilla es para actualziar
                if(idPajilla>0){
                    objClass.setIdPajilla(idPajilla);
                    objClass.setIdRaza(idRaza);
                    objClass.setStrCodigoPajilla(strCodigoPajilla);
                    objClass.setStrFechaVence(et_fechaVencePajilla.getText().toString());
                    objClass.updatePajilla();
                    displayResult();
                    dialog.dismiss();
                }
                else {
                    if (objClass.existPajilla(strCodigoPajilla)) {
                        lblError.setText(String.format("Ya existe una pajilla con este código %s en el sistema.", strCodigoPajilla));
                    } else {
                        objClass.setIdRaza(idRaza);
                        objClass.setStrCodigoPajilla(strCodigoPajilla);
                        objClass.setStrFechaVence(et_fechaVencePajilla.getText().toString());
                        objClass.insertPajilla();
                        displayResult();
                        dialog.dismiss();
                    }
                }
            }
        });

        dialog.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pajilla objClass =new Pajilla(getApplicationContext());
                if (objClass.existPajillaByReproduccion(idPajilla)) {
                    lblError.setText("No es posible borrar la pajilla,  está asociada a un ciclo de reproducción.");
                }
                else{
                    objClass.setIdPajilla(idPajilla);
                    objClass.deletePajilla();
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
