package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainInformacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_informacion);
    }

    //codigo para pasar de activity con boton
    public void onClick(View view){
        Intent miIntent=new Intent(MainInformacion.this,MenuLateral.class);
        startActivity(miIntent);
    }
}
