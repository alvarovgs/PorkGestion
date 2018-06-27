package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

import java.util.ArrayList;

public class Venta {
    private Context appContext;
    private int idRegistro, idCerdo, Edad;
    private double Precioventa;
    private long PesoVivo;
    private String strError;
    private dataBaseOpenHelper dbAcces;

    public Venta(Context appContext, int idRegistro, int idCerdo, int edad, double precioventa, long pesoVivo) {
        this.appContext = appContext;
        this.idRegistro = idRegistro;
        this.idCerdo = idCerdo;
        this.Edad = edad;
        this.Precioventa = precioventa;
        this.PesoVivo = pesoVivo;
    }

    public Venta(Context appContext) {
        this.appContext = appContext;
    }

    public Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context appContext) {
        this.appContext = appContext;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(int idCerdo) {
        this.idCerdo = idCerdo;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public double getPrecioventa() {
        return Precioventa;
    }

    public void setPrecioventa(double precioventa) {
        Precioventa = precioventa;
    }

    public long getPesoVivo() {
        return PesoVivo;
    }

    public void setPesoVivo(long pesoVivo) {
        PesoVivo = pesoVivo;
    }

    public String getStrError() {
        return strError;
    }

    public void setStrError(String strError) {
        this.strError = strError;
    }

    public boolean insertVenta(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDVENTA",0);
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("EDAD",this.Edad);
        ctValores.put("PESOVIVO",this.PesoVivo);
        ctValores.put("PRECIOVENTA",this.Precioventa);
        dbAcces.insertDatabase("VENTACERDO",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateVenta(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("EDAD",this.Edad);
        ctValores.put("PESOVIVO",this.PesoVivo);
        ctValores.put("PRECIOVENTA",this.Precioventa);

        String strArgs[] = new String[]{String.valueOf(this.idRegistro)};
        dbAcces.updateDatabase("VENTACERDO",ctValores,"IDREGISTRSO=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteVenta(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idRegistro)};
        dbAcces.deleteDatabase ("VENTACERDO","IDREGISTRSO=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public Venta getVenta(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"PESOVIVO","EDAD","PRECIOVENTA", "IDCERDO", "IDREGISTRSO"};
        String strArgs[] = new String[]{String.valueOf(idCerdo)};
        Venta tmpObject = new Venta(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VENTACERDO", strColumns, "(IDCERDO=?)", strArgs, null);
        if (crResult.moveToFirst()) {
                tmpObject.setIdCerdo(crResult.getInt(3));
                tmpObject.setPesoVivo(Long.parseLong(crResult.getString(0)));
                tmpObject.setEdad(Integer.parseInt( crResult.getString(1)));
                tmpObject.setPrecioventa(Double.parseDouble(crResult.getString(2)));
                tmpObject.setIdRegistro(crResult.getInt(4));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<Venta> getAllVenta(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"PESOVIVO","EDAD","PRECIOVENTA", "IDCERDO"};
        Cursor crResult;
        ArrayList<Venta> listObject = new ArrayList<Venta>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VENTACERDO", strColumns, null, null, "IDCERDO");
        if (crResult.moveToFirst()) {
            do {
                Venta tmpObject = new Venta(appContext);
                tmpObject.setIdCerdo(crResult.getInt(3));
                tmpObject.setPesoVivo(Long.parseLong(crResult.getString(0)));
                tmpObject.setEdad(Integer.parseInt( crResult.getString(1)));
                tmpObject.setPrecioventa(Double.parseDouble(crResult.getString(2)));
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

    public Boolean existVenta(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM VENTACERDO WHERE IDCERDO='%s'",idCerdo);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }





}
