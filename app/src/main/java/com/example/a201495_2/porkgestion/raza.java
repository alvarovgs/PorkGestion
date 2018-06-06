package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class raza extends AppCompatActivity {
    private Utilidades clsUtil = new Utilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza);
    }

    public void onClick(View view){
        Intent miIntent=new Intent(raza.this,MenuLateral.class);
        startActivity(miIntent);
    }

    //codigo para que no cierre la app por no ingresar datos y presionar el boton consulta
    public void consulta(View v) {
        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
        String razacerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(razacerdo,1)){
            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();
        }
    }

}
