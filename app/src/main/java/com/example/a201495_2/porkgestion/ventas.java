package com.example.a201495_2.porkgestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.a201495_2.porkgestion.adapter.spinAdapter;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;
import com.example.a201495_2.porkgestion.bo_clases.Venta;

public class ventas extends AppCompatActivity {
    EditText campoEdadVenta, campoPesoVenta, campoPrecioVenta;
    spinAdapter sp_AdapterNumventa;
    Spinner comboNumeroAniVenta;
    int idcerdo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);


        comboNumeroAniVenta= findViewById(R.id.comboNumeroAniVenta);
        campoEdadVenta= findViewById(R.id.campoEdadVenta);
        campoPesoVenta= findViewById(R.id.campoPesoVenta);
        campoPrecioVenta= findViewById(R.id.campoPrecioVenta);

        SpinData IDCERDO [] = new SpinData(getApplicationContext()).getCerdonovendido();
        sp_AdapterNumventa = new spinAdapter(this, android.R.layout.simple_spinner_item, IDCERDO);
        comboNumeroAniVenta.setAdapter(sp_AdapterNumventa);


        comboNumeroAniVenta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        registrarVenta();
    }

    private void registrarVenta() {

        Venta miventa = new Venta(getApplicationContext());
        miventa.setIdCerdo(idcerdo);
        miventa.setEdad(Integer.parseInt(campoEdadVenta.getText().toString()));
        miventa.setPesoVivo(Long.parseLong(campoPesoVenta.getText().toString()));
        miventa.setPrecioventa(Double.parseDouble(campoPrecioVenta.getText().toString()));

        if (miventa.insertVenta()) {
            Toast.makeText(getApplicationContext(), "Venta registrada correctamente ", Toast.LENGTH_LONG).show();
            limpiar();
        } else {
            Toast.makeText(getApplicationContext(), "Error registrando la venta ", Toast.LENGTH_SHORT).show();
        }
    }



    private void limpiar() {
        comboNumeroAniVenta.setSelection(0);
        campoEdadVenta.setText("");
        campoPesoVenta.setText("");
        campoPrecioVenta.setText("");
        comboNumeroAniVenta.requestFocus();

    }


}
