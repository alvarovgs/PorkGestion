package com.example.a201495_2.porkgestion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.a201495_2.porkgestion.AdminSQLiteOpenHelper;

public class Parto_Activity extends AppCompatActivity {
    private EditText codigoparto,numerocerda, nombrecerda, fechaparto, totallechones, hembrasvivas, hembrasmuertas,
    machosvivos, machosmuertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parto_);
        codigoparto=(EditText)findViewById(R.id.ed_codigparto);
        numerocerda=(EditText)findViewById(R.id.ed_numerocerda);
        nombrecerda=(EditText)findViewById(R.id.ed_nombrecerda);
        fechaparto=(EditText)findViewById(R.id.ed_fechaparto);
        totallechones=(EditText)findViewById(R.id.ed_totallechones);
        hembrasvivas=(EditText)findViewById(R.id.ed_hembrasvivas);
        hembrasmuertas=(EditText)findViewById(R.id.ed_hembrasmuertas);
        machosvivos=(EditText)findViewById(R.id.ed_machosvivos);
        machosmuertos=(EditText)findViewById(R.id.ed_machosmuertos);

    }

    public void ingresar(View view){
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(this, "reproduccion", null, 1);
        SQLiteDatabase BaseDatos=admin.getWritableDatabase();

        String Codigoparto = codigoparto.getText().toString();
        String Numerocerda = numerocerda.getText().toString();
        String Nombrecerda = nombrecerda.getText().toString();
        String Fechaparto= fechaparto.getText().toString();
        String Totallechones = totallechones.getText().toString();
        String Hembrasvivas = hembrasvivas.getText().toString();
        String Hembrasmuertas = hembrasmuertas.getText().toString();
        String Machosvivos = machosvivos.getText().toString();
        String Machosmuertos = machosmuertos.getText().toString();

        if(!Codigoparto.isEmpty()&&!Numerocerda.isEmpty() &&!Nombrecerda.isEmpty()
                &&!Fechaparto.isEmpty()&&!Totallechones.isEmpty()){
            ContentValues regsitro=new ContentValues();
            regsitro.put("campo_codigoparto", Codigoparto);
            regsitro.put("campo_numerocerda", Numerocerda);
            regsitro.put("campo_nombrecerda", Nombrecerda);
            regsitro.put("campo_fechaparto", Fechaparto);
            regsitro.put("campo_hembrasvivas", Hembrasvivas);
            regsitro.put("campo_hembrasmuertas", Hembrasmuertas);
            regsitro.put("campo_machosvivos", Machosvivos);
            regsitro.put("campo_machosmuertos", Machosmuertos);

            BaseDatos.insert("parto", null, regsitro);
            BaseDatos.close();
            codigoparto.setText("");
            numerocerda.setText("");
            nombrecerda.setText("");
            fechaparto.setText("");
            totallechones.setText("");
            hembrasvivas.setText("");
            hembrasmuertas.setText("");
            machosvivos.setText("");
            machosmuertos.setText("");

            Toast.makeText(this,"Se ha Ingresado un regsitro de Parto",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Debes ingresar Los Datos",Toast.LENGTH_LONG).show();

        }

    }

    //Método para consultar un Regsitro de Parto
    public void Consultar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "reproduccion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String Codigoparto = codigoparto.getText().toString();

        if(!Codigoparto.isEmpty()){
            Cursor fila = BaseDatos.rawQuery
                    ("select campo_numerocerda, campo_nombrecerda, campo_fechaparto, campo_totallechones," +
                            " campo_hembrasvivas, campo_hembrasmuertas, campo_machosvivos,campo_machosmuertos" +
                            " from parto where campo_codigoparto =" + Codigoparto, null);

            if(fila.moveToFirst()){
                numerocerda.setText(fila.getString(0));
                nombrecerda.setText(fila.getString(1));
                fechaparto.setText(fila.getString(2));
                totallechones.setText(fila.getString(3));
                hembrasvivas.setText(fila.getString(4));
                hembrasmuertas.setText(fila.getString(5));
                machosvivos.setText(fila.getString(6));
                machosmuertos.setText(fila.getString(7));
                BaseDatos.close();
            } else {
                Toast.makeText(this,"No existe Registro de parto con ese código", Toast.LENGTH_SHORT).show();
                BaseDatos.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir el codigo de Parto a Consultar", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view){
        codigoparto.setText("");
        numerocerda.setText("");
        nombrecerda.setText("");
        fechaparto.setText("");
        totallechones.setText("");
        hembrasvivas.setText("");
        hembrasmuertas.setText("");
        machosvivos.setText("");
        machosmuertos.setText("");
        codigoparto.requestFocus();
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_regresar3:
                miIntent = new Intent(Parto_Activity.this, Partolact.class);
                break;
        }
        startActivity(miIntent);
    }
}
