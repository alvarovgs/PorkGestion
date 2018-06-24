package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Partolact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partolact);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_back:
                miIntent = new Intent(Partolact.this, MenuLateral.class);
                break;

            case R.id.btn_fpp:
                miIntent = new Intent(Partolact.this, fpp.class);
                break;

            case R.id.btn_rparto:
                miIntent = new Intent(Partolact.this, Parto_Activity.class);
                break;


        }
        startActivity(miIntent);
    }
}