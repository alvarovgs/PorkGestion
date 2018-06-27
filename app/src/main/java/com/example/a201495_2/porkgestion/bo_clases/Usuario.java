package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

import java.util.ArrayList;

public class Usuario {
    private Context appContext;
    private dataBaseOpenHelper dbAcces;
    private int idUsuario;
    private String strNombre,strPassword,strEmail,strTelefono, strError;

    public Usuario(Context appContext, int idUsuario, String strNombre, String strPassword, String strEmail, String strTelefono) {
        this.appContext = appContext;
        this.idUsuario = idUsuario;
        this.strNombre = strNombre;
        this.strPassword = strPassword;
        this.strEmail = strEmail;
        this. strTelefono = strTelefono;
    }

    public Usuario(Context appContext) {
        this.appContext = appContext;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public String getStrError() {
        return strError;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public String getStrTelefono() {
        return strTelefono;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public void setStrTelefono(String strTelefono) {
        this.strTelefono = strTelefono;
    }

    public boolean insertUsuario(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("NOMBRE",this.strNombre);
        ctValores.put("PASSWORD",this.strPassword);
        ctValores.put("EMAIL",this.strEmail);
        ctValores.put("TELEFONO",this.strTelefono);
        dbAcces.insertDatabase("Usuario",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateUsuario(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("NOMBRE",this.strNombre);
        ctValores.put("PASSWORD",this.strPassword);
        ctValores.put("EMAIL",this.strEmail);
        ctValores.put("TELEFONO",this.strTelefono);
        String strArgs[] = new String[]{String.valueOf(this.idUsuario)};
        dbAcces.updateDatabase("Usuario",ctValores,"IDUSUARIO=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteUsuario(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idUsuario)};
        dbAcces.deleteDatabase ("Usuario","IDUsuario=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public Object getUsuario(String strEmail){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDUSUARIO","NOMBRE","PASSWORD","EMAIL","TELEFONO"};
        String strArgs[] = new String[]{strEmail,strEmail};
        Usuario tmpObject = new Usuario(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("USUARIO", strColumns, "EMAIL=?",null,null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdUsuario(crResult.getInt(0));
            tmpObject.setStrNombre(crResult.getString(1));
            tmpObject.setStrEmail(crResult.getString(2));
            tmpObject.setStrPassword(crResult.getString(3));
            tmpObject.setStrTelefono(crResult.getString(4));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<Usuario> getAllUsuario(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDUSUARIO","NOMBRE","PASSWORD","EMAIL","TELEFONO"};
        Cursor crResult;
        ArrayList<Usuario> listObject = new ArrayList<Usuario>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("USUARIO", strColumns, null,null,null);
        if (crResult.moveToFirst()) {
            do {
                Usuario tmpObject = new Usuario(appContext);
                tmpObject.setIdUsuario(crResult.getInt(0));
                tmpObject.setStrNombre(crResult.getString(1));
                tmpObject.setStrEmail(crResult.getString(2));
                tmpObject.setStrPassword(crResult.getString(3));
                tmpObject.setStrTelefono(crResult.getString(4));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<Usuario>  getUsuarioByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        ArrayList<Usuario> listObject = new ArrayList<Usuario>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                Usuario tmpObject = new Usuario(appContext);
                tmpObject.setIdUsuario(crResult.getInt(0));
                tmpObject.setStrNombre(crResult.getString(1));
                tmpObject.setStrEmail(crResult.getString(2));
                tmpObject.setStrPassword(crResult.getString(3));
                tmpObject.setStrTelefono(crResult.getString(4));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }

        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public Boolean execDatabaseByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.execSqlCommand(strSql);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean existUsuario(String strEmail){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM USUARIO WHERE EMAIL='%s'",strEmail);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (dbAcces.getErrorDB()==null){
            if (crResult.moveToFirst()) {
                bResult  =  crResult.getInt(0)>0;
            }
        }
        else {
            this.strError = dbAcces.getErrorDB();
            bResult = false;
        }
        dbAcces.closeDataBase();
        return bResult;
    }

    public Boolean validateUsuario(String strEmail, String strPassword){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM USUARIO WHERE EMAIL='%s' AND PASSWORD ='%s' ", strEmail, strPassword);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (dbAcces.getErrorDB()==null) {
            if (crResult.moveToFirst()) {
                bResult = crResult.getInt(0) > 0;
            }
        }
        else {
            this.strError = dbAcces.getErrorDB();
            bResult = false;
        }
        dbAcces.closeDataBase();
        return bResult;
    }


}
