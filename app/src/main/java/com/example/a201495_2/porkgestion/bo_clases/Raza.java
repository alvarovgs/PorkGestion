package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

import java.util.ArrayList;

public class Raza {
    private Context appContext;
    private int idRaza;
    private String strRaza, strOrigen, strDescripcion, strError;
    private dataBaseOpenHelper dbAcces;

    public Raza(Context appOntext, int idRaza, String strRaza, String strOrigern, String strDescripcion) {
        this.appContext=appContext;
        this.idRaza=idRaza;
        this.strOrigen=strOrigern;
        this.strDescripcion=strDescripcion;
    }

    public Raza(Context appPCOntext) {

    }

    public int getIdRaza() {
        return idRaza;
    }

    public String getStrRaza() {
        return strRaza;
    }

    public String getStrOrigen() {
        return strOrigen;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public void setStrRaza(String strRaza) {
        this.strRaza = strRaza;
    }

    public void setStrOrigen(String strOrigen) {
        this.strOrigen = strOrigen;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public boolean insertRaza(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("NOMBRERAZA",this.strRaza);
        ctValores.put("ORIGEN",this.strOrigen);
        ctValores.put("DESCRIPCION",this.strDescripcion);
        dbAcces.insertDatabase("RAZA",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateRaza(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("NOMBRERAZA",this.strRaza);
        ctValores.put("ORIGEN",this.strOrigen);
        ctValores.put("DESCRIPCION",this.strDescripcion);
        ctValores.put("IDRAZA",this.idRaza);

        String strArgs[] = new String[]{String.valueOf(this.idRaza)};
        dbAcces.updateDatabase("RAZA",ctValores,"IDRAZA=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteRaza(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idRaza)};
        dbAcces.deleteDatabase ("RAZA","IDRaza=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public Object getRaza(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDRAZA","NOMBRERAZA","ORIGEN","DESCRIPCION"};
        String strArgs[] = new String[]{strCodigo,strCodigo};
        Raza tmpObject = new Raza(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("RAZA", strColumns, "(IDRAZA=? OR NOMBRERAZA=?)");
        if (crResult.moveToFirst()) {
                tmpObject.setIdRaza(crResult.getInt(0));
                tmpObject.setStrRaza(crResult.getString(1));
                tmpObject.setStrOrigen(crResult.getString(2));
                tmpObject.setStrDescripcion(crResult.getString(3));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<Raza> getAllRaza(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDRAZA","NOMBRERAZA","ORIGEN","DESCRIPCION"};
        Cursor crResult;
        ArrayList<Raza> listObject = new ArrayList<Raza>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("RAZA", strColumns, null);
        if (crResult.moveToFirst()) {
            do {
                Raza tmpObject = new Raza(appContext);
                tmpObject.setIdRaza(crResult.getInt(0));
                tmpObject.setStrRaza(crResult.getString(1));
                tmpObject.setStrOrigen(crResult.getString(2));
                tmpObject.setStrDescripcion(crResult.getString(3));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<Raza>  getRazaByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        ArrayList<Raza> listObject = new ArrayList<Raza>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                Raza tmpObject = new Raza(appContext);
                tmpObject.setIdRaza(crResult.getInt(0));
                tmpObject.setStrRaza(crResult.getString(1));
                tmpObject.setStrOrigen(crResult.getString(2));
                tmpObject.setStrDescripcion(crResult.getString(3));
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

    public Boolean existRaza(String strNombreRaza){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM RAZA WHERE CODIGO='%s'",strNombreRaza);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }





}
