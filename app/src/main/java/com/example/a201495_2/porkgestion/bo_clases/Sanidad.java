package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

import java.util.ArrayList;

public class Sanidad {
    private Context appContext;
    private dataBaseOpenHelper dbAcces;
    private int idSanidad;
    private String strTipoMedicamento, strNombreMedicamento, strObservaciones, strError;

    public Sanidad(Context appContext, int idSanidad, String strTipoMedicamento, String strNombreMedicamento, String strObservaciones) {
        this.appContext = appContext;
        this.idSanidad = idSanidad;
        this.strTipoMedicamento = strTipoMedicamento;
        this.strNombreMedicamento = strNombreMedicamento;
        this.strObservaciones = strObservaciones;
    }


    public Sanidad(Context appContext) {
        this.appContext = appContext;
    }

    public int getIdSanidad() {
        return idSanidad;
    }

    public void setIdSanidad(int idSanidad) {
        this.idSanidad = idSanidad;
    }

    public String getStrTipoMedicamento() {
        return strTipoMedicamento;
    }

    public void setStrTipoMedicamento(String strTipoMedicamento) {
        this.strTipoMedicamento = strTipoMedicamento;
    }

    public String getStrNombreMedicamento() {
        return strNombreMedicamento;
    }

    public void setStrNombreMedicamento(String strNombreMedicamento) {
        this.strNombreMedicamento = strNombreMedicamento;
    }

    public String getStrObservaciones() {
        return strObservaciones;
    }

    public void setStrObservaciones(String strObservaciones) {
        this.strObservaciones = strObservaciones;
    }

    public String getStrError() {
        return strError;
    }

    public boolean insertSanidad(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("TIPOMEDICAMENTO",this.strTipoMedicamento);
        ctValores.put("NOMBREMEDICAMENTO",this.strNombreMedicamento);
        ctValores.put("OBSERVACIONES",this.strObservaciones);
        dbAcces.insertDatabase("SANIDAD",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateSanidad(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("TIPOMEDICAMENTO",this.strTipoMedicamento);
        ctValores.put("NOMBREMEDICAMENTO",this.strNombreMedicamento);
        ctValores.put("OBSERVACIONES",this.strObservaciones);
        String strArgs[] = new String[]{String.valueOf(this.idSanidad)};
        dbAcces.updateDatabase("SANIDAD",ctValores,"IDSANIDAD=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteSanidad(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idSanidad)};
        dbAcces.deleteDatabase ("SANIDAD","IDSANIDAD=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public Object getSanidad(String strNombreMedicamento){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDSANIDAD","TIPOMEDICAMENTO","NOMBREMEDICAMENTO","OBSERVACIONES"};
        String strArgs[] = new String[]{strNombreMedicamento};
        Sanidad tmpObject = new Sanidad(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("SANIDAD", strColumns, "NOMBREMEDICAMENTO=?", strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdSanidad(crResult.getInt(0));
            tmpObject.setStrTipoMedicamento(crResult.getString(1));
            tmpObject.setStrNombreMedicamento(crResult.getString(2));
            tmpObject.setStrObservaciones(crResult.getString(3));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<Sanidad> getAllSanidad(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDSANIDAD","TIPOMEDICAMENTO","NOMBREMEDICAMENTO","OBSERVACIONES"};
        Cursor crResult;
        ArrayList<Sanidad> listObject = new ArrayList<Sanidad>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("SANIDAD", strColumns, null, null, "IDSANIDAD");
        if (crResult.moveToFirst()) {
            do {
                Sanidad tmpObject = new Sanidad(appContext);
                tmpObject.setIdSanidad(crResult.getInt(0));
                tmpObject.setStrTipoMedicamento(crResult.getString(1));
                tmpObject.setStrNombreMedicamento(crResult.getString(2));
                tmpObject.setStrObservaciones(crResult.getString(3));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<Sanidad>  getSanidadByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        ArrayList<Sanidad> listObject = new ArrayList<Sanidad>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                Sanidad tmpObject = new Sanidad(appContext);
                tmpObject.setIdSanidad(crResult.getInt(0));
                tmpObject.setStrTipoMedicamento(crResult.getString(1));
                tmpObject.setStrNombreMedicamento(crResult.getString(2));
                tmpObject.setStrObservaciones(crResult.getString(3));
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

    public Boolean existSanidad(String strNombreMedicamento){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM SANIDAD WHERE NOMBREMEDICAMENTO='%s'",strNombreMedicamento);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }


}
