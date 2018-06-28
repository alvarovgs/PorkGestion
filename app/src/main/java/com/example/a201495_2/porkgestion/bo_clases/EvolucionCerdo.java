package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;
import java.util.ArrayList;

public class EvolucionCerdo {
    private int idCerdo;
    private String edad, peso, observacion, estado, fecharegistro,strError;
    private Context appContext;
    public boolean expanded = false;
    private dataBaseOpenHelper dbAcces;

    public EvolucionCerdo(Context appContext) {

    }

    public int getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(int idCerdo) {
        this.idCerdo = idCerdo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getStrError() {
        return strError;
    }

    public void setStrError(String strError) {
        this.strError = strError;
    }

    public Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context appContext) {
        this.appContext = appContext;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public dataBaseOpenHelper getDbAcces() {
        return dbAcces;
    }

    public void setDbAcces(dataBaseOpenHelper dbAcces) {
        this.dbAcces = dbAcces;
    }

    public EvolucionCerdo(int idCerdo, String edad, String peso, String observacion, String estado, String fecharegistro, String strError, Context appContext, boolean expanded, dataBaseOpenHelper dbAcces) {
        this.idCerdo = idCerdo;
        this.edad = edad;
        this.peso = peso;
        this.observacion = observacion;
        this.estado = estado;
        this.fecharegistro = fecharegistro;
        this.strError = strError;
        this.appContext = appContext;
        this.expanded = expanded;
        this.dbAcces = dbAcces;
    }

    public boolean insertEvolucion(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("EDAD",this.edad);
        ctValores.put("PESO",this.peso);
        ctValores.put("OBSERVACION",this.observacion);
        ctValores.put("ESTADO",this.estado);
        ctValores.put("FECHAREGISTRO",this.fecharegistro);
        dbAcces.insertDatabase("EVOLUCIONCERDO",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateEvolucion(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("EDAD",this.edad);
        ctValores.put("PESO",this.peso);
        ctValores.put("OBSERVACION",this.observacion);
        ctValores.put("ESTADO",this.estado);
        ctValores.put("FECHAREGISTRO",this.fecharegistro);
        String strArgs[] = new String[]{String.valueOf(this.idCerdo)};
        dbAcces.updateDatabase("EVOLUCIONCERDO",ctValores,"IDCERDO=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteEvolucion(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idCerdo)};
        dbAcces.deleteDatabase ("EVOLUCIONCERDO","IDCERDO=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public Object getEvolucionByView(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","EDAD","PESO","OBSERVACION","ESTADO","FECHAREGISTRO"};
        String strArgs[] = new String[]{strCodigo,strCodigo};
        EvolucionCerdo tmpObject = new EvolucionCerdo(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_EVOLUCIONCERDO", strColumns, "(IDCERDO=?)",null, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdCerdo(crResult.getInt(0));
            tmpObject.setEdad(crResult.getString(1));
            tmpObject.setPeso(crResult.getString(2));
            tmpObject.setObservacion(crResult.getString(3));
            tmpObject.setEstado(crResult.getString(4));
            tmpObject.setFecharegistro(crResult.getString(5));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return dbAcces.getErrorDB()==null;
    }

    public Object getEvolucionByTable(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","EDAD","PESO","OBSERVACION","ESTADO","FECHAREGISTRO"};
        String strArgs[] = new String[]{strCodigo,strCodigo};
        EvolucionCerdo tmpObject = new EvolucionCerdo(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("EVOLUCIONCERDO", strColumns, "(IDCERDO=?)",null,null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdCerdo(crResult.getInt(0));
            tmpObject.setEdad(crResult.getString(1));
            tmpObject.setPeso(crResult.getString(2));
            tmpObject.setObservacion(crResult.getString(3));
            tmpObject.setEstado(crResult.getString(4));
            tmpObject.setFecharegistro(crResult.getString(5));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<EvolucionCerdo> getAllEvolucionByView(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","EDAD","PESO","OBSERVACION","ESTADO","FECHAREGISTRO"};
        Cursor crResult;
        ArrayList<EvolucionCerdo> listRaza = new ArrayList<EvolucionCerdo>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_EVOLUCIONCERDO", strColumns, null,null,null);
        if (crResult.moveToFirst()) {
            do {
                EvolucionCerdo tmpObject = new EvolucionCerdo(appContext);
                tmpObject.setIdCerdo(crResult.getInt(0));
                tmpObject.setEdad(crResult.getString(1));
                tmpObject.setPeso(crResult.getString(2));
                tmpObject.setObservacion(crResult.getString(3));
                tmpObject.setEstado(crResult.getString(4));
                tmpObject.setFecharegistro(crResult.getString(5));
                listRaza.add(tmpObject);
            } while (crResult.moveToNext());

        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listRaza;
    }

    public ArrayList<EvolucionCerdo> getAllCerdoByTable(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO,EDAD,PESO,OBSERVACION,ESTADO,FECHAREGISTRO"};
        Cursor crResult;
        ArrayList<EvolucionCerdo> listObject = new ArrayList<EvolucionCerdo>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("EVOLUCIONCERDO", strColumns, null,null,null);
        if (crResult.moveToFirst()) {
            do {
                EvolucionCerdo tmpObject = new EvolucionCerdo(appContext);
                tmpObject.setIdCerdo(crResult.getInt(0));
                tmpObject.setEdad(crResult.getString(1));
                tmpObject.setPeso(crResult.getString(2));
                tmpObject.setObservacion(crResult.getString(3));
                tmpObject.setEstado(crResult.getString(4));
                tmpObject.setFecharegistro(crResult.getString(5));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<EvolucionCerdo> getEvolucionByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        ArrayList<EvolucionCerdo> listCerdo = new ArrayList<EvolucionCerdo>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                EvolucionCerdo tmpObject = new EvolucionCerdo(appContext);
                tmpObject.setIdCerdo(crResult.getInt(0));
                tmpObject.setEdad(crResult.getString(1));
                tmpObject.setPeso(crResult.getString(2));
                tmpObject.setObservacion(crResult.getString(3));
                tmpObject.setEstado(crResult.getString(4));
                tmpObject.setFecharegistro(crResult.getString(5));
                listCerdo.add(tmpObject);
            } while (crResult.moveToNext());
        }

        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listCerdo;
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

}
