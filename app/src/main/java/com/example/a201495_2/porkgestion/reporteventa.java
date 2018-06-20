package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class reporteventa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporteventa);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btnRegresar:
                miIntent = new Intent(reporteventa.this, MenuLateral.class);
                break;

            case R.id.bt_consultar:
                miIntent = new Intent(reporteventa.this, fpp.class);
                break;

        }
        startActivity(miIntent);
    }
}