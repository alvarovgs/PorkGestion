package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.IdRes;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;
import java.util.ArrayList;

public class Cerdo {
    private int idCerdo, idPadre, idMadre, idRaza;
    private String strFechaNace, strSexo, strCodigo, strCodPadre, strCodMadre, strRaza, strError;
    private long lPesoNace;
    private Context appContext;
    public boolean expanded = false;
    private dataBaseOpenHelper dbAcces;

    public Cerdo(Context appContext, int idCerdo, String strFechaNace, String strSexo, long lPesoNace, int idPadre , int idMadre, int idRaza, String strCodigo) {
        this.appContext = appContext;
        this.idCerdo = idCerdo;
        this.idMadre = idMadre;
        this.idPadre = idPadre;
        this.idRaza = idRaza;
        this.strCodigo = strCodigo;
        this.strFechaNace = strFechaNace;
        this.strSexo = strSexo;
        this.lPesoNace = lPesoNace;
    }

    public Cerdo(Context appContext){
        this.appContext = appContext;
    }

    public void setIdCerdo(int idCerdo) {
        this.idCerdo = idCerdo;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public void setIdMadre(int idMadre) {
        this.idMadre = idMadre;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public void setStrFechaNace(String strFechaNace) {
        this.strFechaNace = strFechaNace;
    }

    public void setStrSexo(String strSexo) {
        this.strSexo = strSexo;
    }

    public void setStrCodigo(String strCodigo) {
        this.strCodigo = strCodigo;
    }

    public void setlPesoNace(long lPesoNace) {
        this.lPesoNace = lPesoNace;
    }

    public void setStrCodPadre(String strCodPadre) {
        this.strCodPadre = strCodPadre;
    }

    public void setStrCodMadre(String strCodMadre) {
        this.strCodMadre = strCodMadre;
    }

    public void setStrRaza(String strRaza) {
        this.strRaza= strRaza;
    }

    public int getIdCerdo() {
        return idCerdo;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public int getIdMadre() {
        return idMadre;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public String getStrFechaNace() {
        return strFechaNace;
    }

    public String getStrSexo() {
        return strSexo;
    }

    public String getStrCodigo() {
        return strCodigo;
    }

    public long getlPesoNace() {
        return lPesoNace;
    }

    public String getStrCodPadre() {
        return strCodPadre;
    }

    public String getStrCodMadre() {
        return strCodMadre;
    }

    public String getStrRaza() {
        return strRaza;
    }

    public String getStrError() {
        return strError;
    }

    public boolean insertCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("FECHANACIMIENTO",this.strFechaNace);
        ctValores.put("SEXO",this.strSexo);
        ctValores.put("PESONACIMIENTO",this.lPesoNace);
        ctValores.put("IDPADRE",this.idPadre);
        ctValores.put("IDMADRE",this.idMadre);
        ctValores.put("IDRAZA",this.idRaza);
        ctValores.put("CODIGO",this.strCodigo);
        dbAcces.insertDatabase("CERDO",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("FECHANACIMIENTO",this.strFechaNace);
        ctValores.put("SEXO",this.strSexo);
        ctValores.put("PESONACIMIENTO",this.lPesoNace);
        ctValores.put("IDPADRE",this.idPadre);
        ctValores.put("IDMADRE",this.idMadre);
        ctValores.put("IDRAZA",this.idRaza);
        ctValores.put("CODIGO",this.strCodigo);
        String strArgs[] = new String[]{String.valueOf(this.idCerdo)};
        dbAcces.updateDatabase("CERDO",ctValores,"IDCERDO=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idCerdo)};
        dbAcces.deleteDatabase ("CERDO","IDCERDO=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }


    public Object getCerdoByView(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","FECHANACIMIENTO","SEXO","PESONACIMIENTO","IDPADRE","IDMADRE","IDRAZA","CODIGO","PADRE","MADRE","NOMBRERAZA"};
        String strArgs[] = new String[]{strCodigo,strCodigo};
        Cerdo tmpObject = new Cerdo(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_CERDO", strColumns, "(CODIGO=? OR IDCERDO=?)", strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdCerdo(crResult.getInt(0));
            tmpObject.setStrFechaNace(crResult.getString(1));
            tmpObject.setStrSexo(crResult.getString(2));
            tmpObject.setlPesoNace(crResult.getLong(3));
            tmpObject.setIdPadre(crResult.getInt(4));
            tmpObject.setIdMadre(crResult.getInt(5));
            tmpObject.setIdRaza(crResult.getInt(6));
            tmpObject.setStrCodigo(crResult.getString(7));
            tmpObject.setStrCodPadre(crResult.getString(8));
            tmpObject.setStrCodMadre(crResult.getString(9));
            tmpObject.setStrRaza(crResult.getString(10));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return dbAcces.getErrorDB()==null;
    }

    public Object getCerdoByTable(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","FECHANACIMIENTO","SEXO","PESONACIMIENTO","IDPADRE","IDMADRE","IDRAZA","CODIGO"};
        String strArgs[] = new String[]{strCodigo,strCodigo};
        Cerdo tmpObject = new Cerdo(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("CERDO", strColumns, "(CODIGO=? OR IDCERDO=?)", strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdCerdo(crResult.getInt(0));
            tmpObject.setStrFechaNace(crResult.getString(1));
            tmpObject.setStrSexo(crResult.getString(2));
            tmpObject.setlPesoNace(crResult.getLong(3));
            tmpObject.setIdPadre(crResult.getInt(4));
            tmpObject.setIdMadre(crResult.getInt(5));
            tmpObject.setIdRaza(crResult.getInt(6));
            tmpObject.setStrCodigo(crResult.getString(7));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<Cerdo> getAllCerdoByView(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","FECHANACIMIENTO","SEXO","PESONACIMIENTO","IDPADRE","IDMADRE","IDRAZA","CODIGO","PADRE","MADRE","NOMBRERAZA"};
        Cursor crResult;
        ArrayList<Cerdo> listRaza = new ArrayList<Cerdo>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_CERDO", strColumns, null, null, "CODIGO");
        if (crResult.moveToFirst()) {
            do {
                Cerdo tmpObject = new Cerdo(appContext);
                tmpObject.setIdCerdo(crResult.getInt(0));
                tmpObject.setStrFechaNace(crResult.getString(1));
                tmpObject.setStrSexo(crResult.getString(2));
                tmpObject.setlPesoNace(crResult.getLong(3));
                tmpObject.setIdPadre(crResult.getInt(4));
                tmpObject.setIdMadre(crResult.getInt(5));
                tmpObject.setIdRaza(crResult.getInt(6));
                tmpObject.setStrCodigo(crResult.getString(7));
                tmpObject.setStrCodPadre(crResult.getString(8));
                this.setStrCodMadre(crResult.getString(9));
                tmpObject.setStrRaza(crResult.getString(10));
                listRaza.add(tmpObject);
            } while (crResult.moveToNext());

        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listRaza;
    }

    public ArrayList<Cerdo> getAllCerdoByTable(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO,FECHANACIMIENTO,SEXO,PESONACIMIENTO,IDPADRE,IDMADRE,IDRAZA,CODIGO"};
        Cursor crResult;
        ArrayList<Cerdo> listObject = new ArrayList<Cerdo>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("CERDO", strColumns, null, null, "CODIGO");
        if (crResult.moveToFirst()) {
            do {
                Cerdo tmpObject = new Cerdo(appContext);
                tmpObject.setIdCerdo(crResult.getInt(0));
                tmpObject.setStrFechaNace(crResult.getString(1));
                tmpObject.setStrSexo(crResult.getString(2));
                tmpObject.setlPesoNace(crResult.getLong(3));
                tmpObject.setIdPadre(crResult.getInt(4));
                tmpObject.setIdMadre(crResult.getInt(5));
                tmpObject.setIdRaza(crResult.getInt(6));
                tmpObject.setStrCodigo(crResult.getString(7));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<Cerdo>  getCerdoByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        ArrayList<Cerdo> listCerdo = new ArrayList<Cerdo>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                Cerdo tmpObject = new Cerdo(appContext);
                tmpObject.setIdCerdo(crResult.getInt(0));
                tmpObject.setStrFechaNace(crResult.getString(1));
                tmpObject.setStrSexo(crResult.getString(2));
                tmpObject.setlPesoNace(crResult.getLong(3));
                tmpObject.setIdPadre(crResult.getInt(4));
                tmpObject.setIdMadre(crResult.getInt(5));
                tmpObject.setIdRaza(crResult.getInt(6));
                tmpObject.setStrCodigo(crResult.getString(7));
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

    public Boolean existCerdo(String StrCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM CERDO WHERE CODIGO='%s'",strCodigo);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (dbAcces.getErrorDB()==null) {
            if (crResult.moveToFirst()) {
                bResult = crResult.getInt(0) > 0;
            }
        }
        else{
            this.strError = dbAcces.getErrorDB();
            bResult = false;
        }
        dbAcces.closeDataBase();
        return bResult;
    }

    public Boolean existCerdoByRaza(int idRaza){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM CERDO WHERE IDRAZA='%s'", idRaza);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (dbAcces.getErrorDB()==null) {
            if (crResult.moveToFirst()) {
                bResult = crResult.getInt(0) > 0;
            }
        }
        else{
            this.strError = dbAcces.getErrorDB();
            bResult = false;
        }
        dbAcces.closeDataBase();
        return bResult;
    }




}
