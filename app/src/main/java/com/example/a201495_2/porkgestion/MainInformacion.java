package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainInformacion extends AppCompatActivity {
    TextView tv_ciclo;
    ImageView im_ciclo;
    TextView tv_conceptos;
    ImageView im_conceptos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_informacion);
        tv_ciclo=findViewById(R.id.tv_ciclo);
        im_ciclo=findViewById(R.id.im_ciclo);
        tv_conceptos=findViewById(R.id.tv_conceptos);
        im_conceptos=findViewById(R.id.im_conceptos);

        tv_ciclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainCiclo.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });

        im_ciclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainCiclo.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });


        tv_conceptos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainGlosario.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });

        im_conceptos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainGlosario.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });
    }

    //codigo para pasar de activity con boton
    public void onClick(View view){
        Intent miIntent=new Intent(MainInformacion.this,MenuLateral.class);
        startActivity(miIntent);
    }
}
