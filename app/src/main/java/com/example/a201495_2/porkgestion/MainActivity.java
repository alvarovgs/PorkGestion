package com.example.a201495_2.porkgestion;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.a201495_2.porkgestion.R.id.tv_registrar;

public class MainActivity extends AppCompatActivity {
    TextView tv_registrar;
    TextView tv_ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_registrar=findViewById(R.id.tv_registrar);
        tv_ingresar=findViewById(R.id.tv_ingresar);


        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainActivity.this, MainRegistrousuario.class);
                MainActivity.this.startActivity(IntentReg);
            }
        });

        tv_ingresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent IntentReg= new Intent (MainActivity.this, MainContenido.class);
                MainActivity.this.startActivity(IntentReg);
            }
        });
    }
}
