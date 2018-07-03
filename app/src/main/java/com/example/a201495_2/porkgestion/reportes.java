package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class reportes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_regresar:
                miIntent = new Intent(reportes.this, MenuLateral.class);
                break;

            case R.id.btn_parto:
                miIntent = new Intent(reportes.this, reporteparto.class);
                break;

            case R.id.btn_reproduccion:
                miIntent = new Intent(reportes.this, vergestantes.class);
                break;

            case R.id.btn_verracos:
                miIntent = new Intent(reportes.this, ververracos.class);
                break;

            case R.id.btn_repoventas:
                miIntent = new Intent(reportes.this, repovecerdo.class);
                break;
            case R.id.btn_rreproduccion:
                miIntent = new Intent(reportes.this, rreproduccion.class);
                break;

            case R.id.btn_hv:
                miIntent = new Intent(reportes.this, MainReporteHV.class);
                break;
        }
        startActivity(miIntent);
    }

    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(reportes.this, MenuLateral.class);
        startActivity(miIntent);
    }
}
