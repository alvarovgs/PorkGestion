package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainReporteHV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reporte_hv);
    }

    public void onClick(View view){
        Intent miIntent=new Intent(MainReporteHV.this,reportes.class);
        startActivity(miIntent);
    }
}
