package com.example.a201495_2.porkgestion;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class raza extends AppCompatActivity {
    /*private clsUtilidades clsUtil = new clsUtilidades();
    private Raza objraza;
    EditText et_nomraza, et_origen, et_descripcion;*/

    EditText campoRazanueva, campoIdRazaNew;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza);
        conn=new ConexionSQLiteHelper(getApplicationContext(), "bd_porcinos", null, 1);

        campoIdRazaNew = (EditText) findViewById(R.id.campoIdRazaNew);
        campoRazanueva = (EditText) findViewById(R.id.campoRazanueva);

//        et_nomraza= (EditText) findViewById(R.id.et_nomraza);
//        et_origen= (EditText) findViewById(R.id.et_origen);
//        et_descripcion= (EditText) findViewById(R.id.et_descripcion);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btningresar:
                ingresarRazanueva();
                break;
            case R.id.btnconsuraza:
                consultarRazaNueva();
                break;
            case R.id.btnlimpiaraza:
                limpiar();
                break;
            case R.id.btnactuaraza:
                actualizaraza();
                break;
            case R.id.btneliraza:
                eliminarraza();
                break;
        }
    }

    private void ingresarRazanueva() {
//        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,8);
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bd_porcinos", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_IDNUEVARAZA,campoIdRazaNew.getText().toString());
        values.put(Utilidades.CAMPO_NUEVARAZA,campoRazanueva.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_RAZAS,Utilidades.CAMPO_IDNUEVARAZA,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
        limpiar();
    }


    private void consultarRazaNueva() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoIdRazaNew.getText().toString()};
        String[] campos={Utilidades.CAMPO_IDNUEVARAZA,Utilidades.CAMPO_NUEVARAZA};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_RAZAS,campos,Utilidades.CAMPO_IDNUEVARAZA+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoIdRazaNew.setText(cursor.getString(0));
            campoRazanueva.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"La raza no existe",Toast.LENGTH_LONG).show();
        }
    }


    private void eliminarraza() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoIdRazaNew.getText().toString()};
        db.delete(Utilidades.TABLA_RAZAS,Utilidades.CAMPO_IDNUEVARAZA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó la raza",Toast.LENGTH_LONG).show();
        campoIdRazaNew.setText("");
        db.close();
        limpiar();
    }

    private void actualizaraza() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoIdRazaNew.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_IDNUEVARAZA,campoIdRazaNew.getText().toString());
        values.put(Utilidades.CAMPO_NUEVARAZA,campoRazanueva.getText().toString());

        db.update(Utilidades.TABLA_RAZAS,values,Utilidades.CAMPO_IDNUEVARAZA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó la raza",Toast.LENGTH_LONG).show();
        db.close();
        limpiar();
    }

    private void limpiar() {
        campoIdRazaNew.setText("");
        campoRazanueva.setText("");
        campoRazanueva.requestFocus();
    }

    //codigo para que no cierre la app por no ingresar datos y presionar el boton consulta
   /* public void consulta(View v) {
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
    }*/

//    public void onClick(View view) {
//        ingresar();
//    }
//
//
//    public void ingresar () {
////        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
////        EditText et2 = (EditText)findViewById(R.id.et_origen);
////        EditText et3 = (EditText)findViewById(R.id.et_descripcion);
//        objraza = new Raza(getApplicationContext());
//        String razacerdo= ((EditText) findViewById(R.id.et_nomraza)).getText().toString();
//        String origen= ((EditText) findViewById(R.id.et_origen)).getText().toString();
//        String descripcion= ((EditText) findViewById(R.id.et_descripcion)).getText().toString();
////        String razacerdo = et_nomraza.getText().toString();
////        String origen = et_origen.getText().toString();
////        String descripcion = et_descripcion.getText().toString();
////        if (!clsUtil.bValidaString(razacerdo,1)){
////            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();
////        }
//
//        objraza.setStrRaza(razacerdo);
//        objraza.setStrOrigen(origen);
//        objraza.setStrDescripcion(descripcion);
//        objraza.insertRaza();
////        resultadoisert=objraza.insertRaza();
////        if (resultadoisert) {
////        if (objraza.insertRaza()) {
////            Toast.makeText(this, "Raza Creada correctametne", Toast.LENGTH_LONG).show();
////        }
////        else {
////            Toast.makeText(this, "Error creando la Raza", Toast.LENGTH_LONG).show();
////        }
//    }

  /* public void actualizar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
        String razacerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(razacerdo,1)){
            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();
        }
    }*/

    /*public void eliminar (View v) {
        EditText et1 = (EditText)findViewById(R.id.et_nomraza);
        String razacerdo = et1.getText().toString();
        if (!clsUtil.bValidaString(razacerdo,1)){
            Toast.makeText(this, "Ingrese la raza",Toast.LENGTH_SHORT).show();
        }
    }*/

   /* public void onClick(View view){
        Intent miIntent=new Intent(raza.this,MenuLateral.class);
        startActivity(miIntent);
    }
*/
}
