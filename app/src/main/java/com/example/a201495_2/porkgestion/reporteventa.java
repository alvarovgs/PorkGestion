package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.a201495_2.porkgestion.bo_clases.Venta;
import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class reporteventa extends AppCompatActivity {

    EditText campoIdConsuVe,campoEdadConsuVe,campoPesoConsuVe,campoPreConsuVe;
    Spinner comboIdConsuVe;
    spinAdapter sp_AdapterNumventa;
    int idcerdo = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporteventa);


        //campoIdConsuVe= (EditText) findViewById(R.id.campoIdConsuVe);
        campoEdadConsuVe= (EditText) findViewById(R.id.campoEdadConsuVe);
        campoPesoConsuVe= (EditText) findViewById(R.id.campoPesoConsuVe);
        campoPreConsuVe=(EditText) findViewById(R.id.campoPreConsuVe);
        comboIdConsuVe= (Spinner) findViewById(R.id.comboIdConsuVe);

        SpinData IDCERDO [] = new SpinData(getApplicationContext()).getCerdo();
        sp_AdapterNumventa = new spinAdapter(this, android.R.layout.simple_spinner_item, IDCERDO);
        comboIdConsuVe.setAdapter(sp_AdapterNumventa);


        comboIdConsuVe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinData sp_item = sp_AdapterNumventa.getItem(position);
                idcerdo = sp_item.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> sp_Adapter) {  }
        });
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar: consultarVenta();
                break;
            case R.id.btnLimpiar: limpiar();
                break;
            case R.id.btnActualizar: actualizarVenta();
                break;
            case R.id.btnEliminar: eliminarVenta();
                break;
        }
    }

    private void eliminarVenta() {
        //SQLiteDatabase db=conn.getWritableDatabase();
        Venta miventa=new Venta(getApplicationContext());
        miventa.setIdCerdo(idcerdo);
        if (miventa.deleteVenta()){
            Toast.makeText(getApplicationContext(),"Venta eliminada correctamente ",Toast.LENGTH_LONG).show();
            limpiar();
        }
        else {
            Toast.makeText(getApplicationContext(),"Error eliminando la venta ",Toast.LENGTH_SHORT).show();
        }

    }

    private void actualizarVenta() {
        Venta miventa=new Venta(getApplicationContext());
        miventa = miventa.getVenta(idcerdo);
        miventa.setEdad(Integer.parseInt(campoEdadConsuVe.getText().toString()));
        miventa.setPesoVivo(Long.parseLong(campoPesoConsuVe.getText().toString()));
        miventa.setPrecioventa(Double.parseDouble(campoPreConsuVe.getText().toString()));
        if (miventa.updateVenta()){
            Toast.makeText(getApplicationContext(),"Venta actualizada correctamente ",Toast.LENGTH_LONG).show();
            limpiar();
        }
        else {
            Toast.makeText(getApplicationContext(),"Error actualizando la venta ",Toast.LENGTH_SHORT).show();
        }

    }


    private void consultarVenta() {
        Venta miventa=new Venta(getApplicationContext());
        if (miventa.existVenta(idcerdo)){
            miventa = miventa.getVenta(idcerdo);
            campoEdadConsuVe.setText(String.valueOf(miventa.getEdad()));
            campoPesoConsuVe.setText(String.valueOf(miventa.getPesoVivo()));
            campoPreConsuVe.setText(String.valueOf(miventa.getPrecioventa()));
        }
        else {
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
        }
    }

    private void limpiar() {
        comboIdConsuVe.setSelection(0);
        campoEdadConsuVe.setText("");
        campoPesoConsuVe.setText("");
        campoPreConsuVe.setText("");
        comboIdConsuVe.requestFocus();
    }

}
