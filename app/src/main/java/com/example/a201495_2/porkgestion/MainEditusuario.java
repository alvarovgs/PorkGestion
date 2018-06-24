package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.utils.clsUtilidades;
import com.example.a201495_2.porkgestion.bo_clases.Usuario;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

 public class MainEditusuario extends AppCompatActivity {
        private clsUtilidades clsUtil = new clsUtilidades();
       // Button btn_Consultar;
       // Button btnLimpiar;
        Button btnActualizar;
        Button btnEliminar;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main_editusuario);

             btnActualizar = findViewById(R.id.btnActualizar);
             btnEliminar = findViewById(R.id.btnEliminar);
             btnActualizar.setOnClickListener (new View.OnClickListener() {


                 @Override
                 public void onClick(View v) {

                     Usuario miUsuario = new Usuario(getApplicationContext());

                     String strUsuario= ((EditText) findViewById(R.id.txt_usuario)).getText().toString();
                     String strPassword = ((EditText) findViewById(R.id.txt_pass)).getText().toString();
                     String strNombre = ((EditText) findViewById(R.id.txt_nombreusuario)).getText().toString();
                     String strTelefono = ((EditText) findViewById(R.id.txt_telefono)).getText().toString();


                     if(!clsUtil.bValidaString(strUsuario,1))
                         Toast.makeText(getBaseContext(),"Debe digitar el usuario actual (email)",Toast.LENGTH_SHORT).show();
                     else if(!clsUtil.bValidaString(strUsuario,3))
                         Toast.makeText(getBaseContext(),"El usuario debe ser un email válido",Toast.LENGTH_SHORT).show();
                     else if(!clsUtil.bValidaString(strPassword,1))
                         Toast.makeText(getBaseContext(),"Debe digitar un nuevo Password",Toast.LENGTH_SHORT).show();
                     else if(!clsUtil.bValidaString(strNombre,1))
                         Toast.makeText(getBaseContext(),"Debe digitar un nombre de usuario",Toast.LENGTH_SHORT).show();
                     else {
                         miUsuario.setStrEmail(strUsuario);
                         miUsuario.setStrPassword(strPassword);
                         miUsuario.setStrNombre(strNombre);
                         miUsuario.setStrTelefono(strTelefono);

                         if(!miUsuario.existUsuario(strUsuario)){
                             if(miUsuario.updateUsuario()) {
                                 Toast.makeText(getApplicationContext(), "Usuario Actualizado correctamente", Toast.LENGTH_SHORT).show();
                                 Intent IntentReg = new Intent(MainEditusuario.this, MainActivity.class);
                                 MainEditusuario.this.startActivity(IntentReg);
                             }
                             else{
                                 String error = miUsuario.getStrError();
                                 Toast.makeText(getApplicationContext(), "Se presento un error" + error , Toast.LENGTH_SHORT).show();
                             }
                         }
                         else{
                             Toast.makeText(getApplicationContext(), "Actualización Exitosa", Toast.LENGTH_SHORT).show();

                         }
                     }

                 }
             });

     }}



