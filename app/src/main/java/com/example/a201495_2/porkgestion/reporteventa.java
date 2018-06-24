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

import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class reporteventa extends AppCompatActivity {

    EditText campoIdConsuVe,campoNomConsuVe,campoFeConsuVe,campoPeConsuVe, campoPreConsuVe;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporteventa);

        //conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,8);
        conn=new ConexionSQLiteHelper(getApplicationContext(), "bd_porcinos", null, 1);

        campoIdConsuVe= (EditText) findViewById(R.id.campoIdConsuVe);
        campoNomConsuVe= (EditText) findViewById(R.id.campoNomConsuVe);
        campoFeConsuVe= (EditText) findViewById(R.id.campoFeConsuVe);
        campoPeConsuVe=(EditText) findViewById(R.id.campoPeConsuVe);
        campoPreConsuVe=(EditText) findViewById(R.id.campoPreConsuVe);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar: consultar();
                break;
            case R.id.btnLimpiar: limpiar();
                break;
            case R.id.btnActualizar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarUsuario();
                break;
        }
    }

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoIdConsuVe.getText().toString()};
        db.delete(Utilidades.TABLA_VENTA,Utilidades.CAMPO_IDANIMALVENTA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el cerdo",Toast.LENGTH_LONG).show();
        campoIdConsuVe.setText("");
        db.close();
        limpiar();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoIdConsuVe.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_IDANIMALVENTA,campoIdConsuVe.getText().toString());
        values.put(Utilidades.CAMPO_NOMBREVENTA,campoNomConsuVe.getText().toString());
        values.put(Utilidades.CAMPO_FECHAVENTA,campoFeConsuVe.getText().toString());
        values.put(Utilidades.CAMPO_PESOVENTA,campoPeConsuVe.getText().toString());
        values.put(Utilidades.CAMPO_PRECIOVENTA,campoPreConsuVe.getText().toString());

        db.update(Utilidades.TABLA_VENTA,values,Utilidades.CAMPO_IDANIMALVENTA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el cerdo",Toast.LENGTH_LONG).show();
        db.close();
        limpiar();
    }


    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoIdConsuVe.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBREVENTA,Utilidades.CAMPO_FECHAVENTA,Utilidades.CAMPO_PESOVENTA,Utilidades.CAMPO_PRECIOVENTA};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_VENTA,campos,Utilidades.CAMPO_IDANIMALVENTA+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNomConsuVe.setText(cursor.getString(0));
            campoFeConsuVe.setText(cursor.getString(1));
            campoPeConsuVe.setText(cursor.getString(2));
            campoPreConsuVe.setText(cursor.getString(3));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El cerdo no existe",Toast.LENGTH_LONG).show();
        }
    }

    private void limpiar() {
        campoIdConsuVe.setText("");
        campoNomConsuVe.setText("");
        campoFeConsuVe.setText("");
        campoPeConsuVe.setText("");
        campoPreConsuVe.setText("");
        campoIdConsuVe.requestFocus();
    }





    /*public void onClick(View view){
        Intent miIntent=new Intent(reporteventa.this,reportes.class);
        startActivity(miIntent);
    }*/
}
