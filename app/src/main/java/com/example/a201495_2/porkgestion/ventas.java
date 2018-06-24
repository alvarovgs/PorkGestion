package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class ventas extends AppCompatActivity {

    //private clsUtilidades clsUtil = new clsUtilidades();
    private Utilidades clsUtil = new Utilidades();
    EditText campoNumeroAniVenta, campoNombAniVenta, campoFechaVenta, campoPesoVenta, campoPrecioVenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);


        campoNumeroAniVenta= (EditText) findViewById(R.id.campoNumeroAniVenta);
        campoNombAniVenta= (EditText) findViewById(R.id.campoNombAniVenta);
        campoFechaVenta= (EditText) findViewById(R.id.campoFechaVenta);
        campoPesoVenta=(EditText) findViewById(R.id.campoPesoVenta);
        campoPrecioVenta=(EditText) findViewById(R.id.campoPrecioVenta);
    }

    public void onClick(View view) {
        registrarVenta();
    }

    private void registrarVenta() {
//        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,8);
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_porcinos", null, 1);


        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_IDANIMALVENTA,campoNumeroAniVenta.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREVENTA,campoNombAniVenta.getText().toString());
        values.put(Utilidades.CAMPO_FECHAVENTA,campoFechaVenta.getText().toString());
        values.put(Utilidades.CAMPO_PESOVENTA,campoPesoVenta.getText().toString());
        values.put(Utilidades.CAMPO_PRECIOVENTA,campoPrecioVenta.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_VENTA,Utilidades.CAMPO_IDANIMALVENTA,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
        limpiar();
    }

    private void limpiar() {
        campoNumeroAniVenta.setText("");
        campoNombAniVenta.setText("");
        campoFechaVenta.setText("");
        campoPesoVenta.setText("");
        campoPrecioVenta.setText("");
        campoNumeroAniVenta.requestFocus();

    }



    /*public void onClick(View view){
        Intent miIntent=new Intent(ventas.this,MenuLateral.class);
        startActivity(miIntent);
    }

    //codigo para que no cierre la app por no ingresar datos y presionar el boton consulta
    public void consulta(View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }

    public void actualizar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }

    public void ingresar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_numa);
        String numcerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(numcerdo,1)){
            Toast.makeText(this, "Digite el número del cerdo",Toast.LENGTH_SHORT).show();
        }
    }*/

}
