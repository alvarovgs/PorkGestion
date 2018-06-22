package com.example.a201495_2.porkgestion;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.Raza;
public class raza extends AppCompatActivity {
    private clsUtilidades clsUtil = new clsUtilidades();
    private Raza objraza;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza);
    }
    //codigo para que no cierre la app por no ingresar datos y presionar el boton consulta
    public void consulta(View v) {
        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
        String razacerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(razacerdo,1)){
            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();
        }
        objraza = new Raza(getApplicationContext());
        objraza.getRaza(razacerdo);
        EditText et2 = (EditText)findViewById(R.id.et_origen);
        EditText et3 = (EditText)findViewById(R.id.et_descripcion);
        et2.setText(objraza.getStrOrigen());
        et3.setText(objraza.getStrDescripcion());

    }

    public void ingresar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
        EditText et2 = (EditText)findViewById(R.id.et_origen);
        EditText et3 = (EditText)findViewById(R.id.et_descripcion);
        String origen = et2.getText().toString();
        String descripcion = et3.getText().toString();
        
        String razacerdo = et1.getText().toString();
        boolean resultadoisert;
        if (!clsUtil.bValidaString(razacerdo,1)){
            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();

        }
        objraza = new Raza(getApplicationContext());
        objraza.setStrRaza(razacerdo);
        objraza.setStrOrigen(origen);
        objraza.setStrDescripcion(descripcion);
        resultadoisert=objraza.insertRaza();
        if (resultadoisert) {
            Toast.makeText(this, "Raza Creada correctametne", Toast.LENGTH_LONG).show();
        }
        else {
                Toast.makeText(this, "Error creando la Raza", Toast.LENGTH_LONG).show();
        }

    }
    public void actualizar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
        String razacerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(razacerdo,1)){
            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
        String razacerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(razacerdo,1)){
            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view){
        Intent miIntent=new Intent(raza.this,MenuLateral.class);
        startActivity(miIntent);
    }

}
