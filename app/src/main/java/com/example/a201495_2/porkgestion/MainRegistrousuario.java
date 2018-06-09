package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainRegistrousuario extends AppCompatActivity {

    Button Inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrousuario);

        Inicio = (Button) findViewById(R.id.btn_reg);
        Inicio.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Inicio = new Intent(MainRegistrousuario.this, MainActivity.class);
                startActivity(Inicio);

            }
        });
    }
}