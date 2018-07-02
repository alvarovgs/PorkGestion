package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView;

public class MainContenido extends AppCompatActivity{
    ImageView imgbutton;
    TextView strigbutton;
    TextView tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido_inicio);
        imgbutton= findViewById(R.id.ibt_repro);
        imgbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent imgbutton=new Intent(MainContenido.this, reproduccion.class);
                startActivity(imgbutton);

        strigbutton= findViewById(R.id.repro_string);
        strigbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent strigbutton = new Intent(MainContenido.this, reproduccion.class);
                 startActivity(strigbutton);

             }
                });

                }
        });
        tv_info=findViewById(R.id.tv_info);

        tv_info.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent IntentReg = new Intent (MainContenido.this, MainInformacion.class);
            startActivity(IntentReg);
        }
    });
    }
}
