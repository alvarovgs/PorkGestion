package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.pchmn.materialchips.R2.id.container;

public class reproduccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerdo);

    }

    //    codigo para pasar de activity con boton
    public void onClick(View view){
        Intent miIntent=new Intent(reproduccion.this,MenuLateral.class);
        startActivity(miIntent);
    }


}
