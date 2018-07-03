package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuventa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuventa);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_back:
                miIntent = new Intent(menuventa.this, MenuLateral.class);
                break;

            case R.id.btn_newventa:
                miIntent = new Intent(menuventa.this, ventas.class);
                break;

            case R.id.btn_caventa:
                miIntent = new Intent(menuventa.this, reporteventa.class);
                break;

        }
        startActivity(miIntent);
    }
}
