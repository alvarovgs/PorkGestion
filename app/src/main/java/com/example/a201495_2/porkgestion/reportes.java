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

            case R.id.btn_verracos:
                miIntent = new Intent(reportes.this, reporteverracos.class);
                break;

            case R.id.btn_ventas:
                miIntent = new Intent(reportes. this, reporteventa.class);
                break;
        }
        startActivity(miIntent);
    }
}