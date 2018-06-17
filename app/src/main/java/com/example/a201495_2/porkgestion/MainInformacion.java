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
    TextView tv_datos;
    ImageView im_datos;
    TextView tv_links;
    ImageView im_links;
    TextView tv_uso;
    ImageView im_uso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_informacion);
        tv_ciclo=findViewById(R.id.tv_ciclo);
        im_ciclo=findViewById(R.id.im_ciclo);
        tv_conceptos=findViewById(R.id.tv_conceptos);
        im_conceptos=findViewById(R.id.im_conceptos);
        tv_datos=findViewById(R.id.tv_datos);
        im_datos=findViewById(R.id.im_datos);
        tv_links=findViewById(R.id.tv_links);
        im_links=findViewById(R.id.im_links);
        tv_uso=findViewById(R.id.tv_uso);
        im_uso=findViewById(R.id.im_uso);

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


        tv_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainDatosOrg.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });

        im_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainDatosOrg.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });

        tv_links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainLinks.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });

        im_links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainLinks.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });

        tv_uso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainRecomendaciones.class);
                MainInformacion.this.startActivity(IntentReg);
            }
        });

        im_uso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainInformacion.this, MainRecomendaciones.class);
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
