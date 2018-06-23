package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;

public class monta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monta);
    }

    public void onClick(View view){
        Intent miIntent=new Intent(monta.this,reproduccion.class);
        startActivity(miIntent);



    }
}