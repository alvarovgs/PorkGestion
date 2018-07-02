package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class reproduccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduccion);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_back:
                miIntent = new Intent(reproduccion.this, MenuLateral.class);
                break;

            case R.id.btn_rmonta:
                miIntent = new Intent(reproduccion.this, gestantes.class);
                break;

            case R.id.btn_rpajilla:
                miIntent = new Intent(reproduccion.this, PajillaActivity.class);
                break;

            case R.id.btn_fpp:
                miIntent = new Intent(reproduccion.this, fpp.class);
                break;
        }
        startActivity(miIntent);
    }


}


