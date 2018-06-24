package com.example.a201495_2.porkgestion;

import android.content.Intent;
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
     private Button btnActualizar;
     private Button btnEliminar;
     private Button btnConsultar;
     private EditText et_Usuario;
     private EditText et_Nombre;
     private EditText et_Password;
     private EditText et_Telefono;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main_editusuario);

             btnActualizar = findViewById(R.id.btnActualizar);
             btnEliminar = findViewById(R.id.btnEliminar);
             btnConsultar = findViewById(R.id.btnConsultar);
            dataBaseOpenHelper midb = new dataBaseOpenHelper(getApplicationContext());

            et_Usuario = findViewById(R.id.txt_usuario);
            et_Nombre = findViewById(R.id.txt_nombreusuario);
            et_Password = findViewById(R.id.txt_pass);
            et_Telefono = findViewById(R.id.txt_telefono);

            btnConsultar.setOnClickListener (new View.OnClickListener() {

                 @Override
                 public void onClick(View v) {
                     Usuario miUsuario = new Usuario(getApplicationContext());
                     String strUsuario= et_Usuario.getText().toString();
                     miUsuario = miUsuario.getUsuario(strUsuario);
                     et_Nombre.setText(miUsuario.getStrNombre());
                     et_Password.setText(miUsuario.getStrPassword());
                     et_Telefono.setText(miUsuario.getStrTelefono());

                     String strPassword = ((EditText) findViewById(R.id.txt_pass)).getText().toString();
                     String strNombre = ((EditText) findViewById(R.id.txt_nombreusuario)).getText().toString();
                     String strTelefono = ((EditText) findViewById(R.id.txt_telefono)).getText().toString();

                     if(!clsUtil.bValidaString(strUsuario,1))
                         Toast.makeText(getBaseContext(),"Debe digitar el usuario (email)",Toast.LENGTH_SHORT).show();
                     else if(!clsUtil.bValidaString(strUsuario,3))
                         Toast.makeText(getBaseContext(),"El usuario debe ser un email válido",Toast.LENGTH_SHORT).show();

                         else{
                         miUsuario = miUsuario.getUsuario(strUsuario);
                         miUsuario.setStrPassword(strPassword);
                         miUsuario.setStrNombre(strNombre);
                         miUsuario.setStrTelefono(strTelefono);

                         if(miUsuario.existUsuario(strUsuario)) {
                             Toast.makeText(getBaseContext(),"Éstos son sus datos de usuario Actuales",Toast.LENGTH_SHORT).show();
                         }else {
                             Toast.makeText(getBaseContext(),"No existe el Usuario ingresado, por favor vuelva a intentarlo",Toast.LENGTH_SHORT).show();
                         }
                     }
                 }

            });

             btnActualizar.setOnClickListener (new View.OnClickListener() {

                 @Override
                     public void onClick(View v) {
                        updateUsuario();
             }
             });

             btnEliminar.setOnClickListener (new View.OnClickListener() {
                 @Override
                    public void onClick(View v) {
                         deleteUsuario();
             }
             });
     }

     private void updateUsuario (){
         String strUsuario= et_Usuario.getText().toString();
         String strPassword = et_Password.getText().toString();
         String strNombre = et_Nombre.getText().toString();
         String strTelefono = et_Telefono.getText().toString();
         if(!clsUtil.bValidaString(strPassword,1))
             Toast.makeText(getBaseContext(),"Debe digitar un nuevo password",Toast.LENGTH_SHORT).show();
         else if(!clsUtil.bValidaString(strNombre,1))
             Toast.makeText(getBaseContext(),"Debe digitar un nombre de usuario",Toast.LENGTH_SHORT).show();
         else{
             Usuario miUsuario = new Usuario(getApplicationContext());
             miUsuario = miUsuario.getUsuario(strUsuario);
             miUsuario.setStrPassword(strPassword);
             miUsuario.setStrNombre(strNombre);
             miUsuario.setStrTelefono(strTelefono);
             if(miUsuario.updateUsuario()) {
                 Toast.makeText(getBaseContext(),"Usuario actualizado correctamente",Toast.LENGTH_SHORT).show();
                 Intent IntentReg = new Intent(MainEditusuario.this, MainActivity.class);
                 IntentReg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                 finish();
                 MainEditusuario.this.startActivity(IntentReg);
             }else {
                 Toast.makeText(getBaseContext(),"Se presentaron errores actualizando el usuario",Toast.LENGTH_SHORT).show();
             }
         }
     }

         private void deleteUsuario (){
             String strUsuario= et_Usuario.getText().toString();
             String strPassword = et_Password.getText().toString();
             String strNombre = et_Nombre.getText().toString();
             String strTelefono = et_Telefono.getText().toString();
             if(!clsUtil.bValidaString(strPassword,1))
                 Toast.makeText(getBaseContext(),"Debe digitar el password de Usuario",Toast.LENGTH_SHORT).show();
             else{
                 Usuario miUsuario = new Usuario(getApplicationContext());
                 miUsuario = miUsuario.getUsuario(strUsuario);
                 miUsuario.setStrPassword(strPassword);
                 miUsuario.setStrNombre(strNombre);
                 miUsuario.setStrTelefono(strTelefono);
                 if(miUsuario.deleteUsuario()) {
                     Toast.makeText(getBaseContext(),"Usuario eliminado correctamente",Toast.LENGTH_SHORT).show();
                     Intent IntentReg = new Intent(MainEditusuario.this, MainActivity.class);
                     IntentReg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                     finish();
                     MainEditusuario.this.startActivity(IntentReg);
                 }else {
                     Toast.makeText(getBaseContext(),"Se presentaron errores Eliminando el usuario",Toast.LENGTH_SHORT).show();
                 }
             }
         }
 }





