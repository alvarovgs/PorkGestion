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

public class MainEditusuario extends AppCompatActivity {
    private Button btn_Actualizar;
    private Button btn_Eliminar;
    private EditText et_Usuario;
    private EditText et_Nombre;
    private EditText et_Password;
    private EditText et_Telefono;
    private Usuario miUsuario;
    private clsUtilidades clsUtil = new clsUtilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_editusuario);
        final GlobalClass datosGlobales = (GlobalClass) getApplicationContext();
        miUsuario = datosGlobales.getActiveUser();

        btn_Actualizar = findViewById(R.id.btnActualizar);
        btn_Eliminar = findViewById(R.id.btnEliminar);
        et_Usuario = findViewById(R.id.et_Codigo);
        et_Nombre = findViewById(R.id.txt_nombreusuario);
        et_Password = findViewById(R.id.txt_pass);
        et_Telefono = findViewById(R.id.txt_telefono);

        et_Usuario.setText(miUsuario.getStrEmail());
        et_Nombre.setText(miUsuario.getStrNombre());
        et_Password.setText(miUsuario.getStrPassword());
        et_Telefono.setText(miUsuario.getStrTelefono());

        btn_Actualizar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    upateUsuario();
                }
            }
        );

        btn_Eliminar.setOnClickListener (new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) { deleteUsuario(); }
                                           }
        );
    }

    private void upateUsuario (){
        String strPassword = et_Password.getText().toString();
        String strNombre = et_Nombre.getText().toString();
        String strTelefono = et_Telefono.getText().toString();
        if(!clsUtil.bValidaString(strPassword,1))
            Toast.makeText(getBaseContext(),"Debe digitar un nuevo password",Toast.LENGTH_SHORT).show();
        else{
            miUsuario.setStrPassword(strPassword);
            miUsuario.setStrNombre(strNombre);
            miUsuario.setStrTelefono(strTelefono);
            if(miUsuario.updateUsuario()) {
                Toast.makeText(getBaseContext(),"Usuario actualizado correctamente",Toast.LENGTH_SHORT).show();
                Intent IntentReg = new Intent(MainEditusuario.this, MainActivity.class);
                IntentReg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                finish();
                startActivity(IntentReg);
            }else {
                Toast.makeText(getBaseContext(),"Se presentaron errores actualizando el usuario",Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void deleteUsuario (){
        if(miUsuario.deleteUsuario()) {
            Toast.makeText(getBaseContext(),"Usuario eliminado correctamente",Toast.LENGTH_SHORT).show();
            finish();
            Intent IntentReg = new Intent(MainEditusuario.this, MainActivity.class);
            IntentReg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            finish();
            startActivity(IntentReg);
        }else {
            Toast.makeText(getBaseContext(),"Se presentaron errores eliminando el usuario",Toast.LENGTH_SHORT).show();
        }
    }
}
