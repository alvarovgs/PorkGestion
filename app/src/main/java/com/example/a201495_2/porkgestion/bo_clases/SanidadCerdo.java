package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

import java.util.ArrayList;

public class SanidadCerdo {
    private Context appContext;
    private dataBaseOpenHelper dbAcces;
    private int idCerdo, idSanidad;
    private int idCerdoPK, idSanidadPK;
    private String strDosis;
    private String strFechaAdministracionPK;
    private String strTipoMedicamento, strNombreMedicamento, strViaAdministracion, strFechaAdministracion;
    private String strCodigoCerdo, strSexoCerdo, strError;

    public SanidadCerdo(int idCerdo, int idSanidad, String strDosis, String strTipoMedicamento, String strNombreMedicamento, String strViaAdministracion, String strFechaAdministracion, String strCodigoCerdo, String strSexoCerdo) {
        this.idCerdo = idCerdo;
        this.idSanidad = idSanidad;
        this.strDosis = strDosis;
        this.strTipoMedicamento = strTipoMedicamento;
        this.strNombreMedicamento = strNombreMedicamento;
        this.strViaAdministracion = strViaAdministracion;
        this.strFechaAdministracion = strFechaAdministracion;
        this.strCodigoCerdo = strCodigoCerdo;
        this.strSexoCerdo = strSexoCerdo;
    }



    public SanidadCerdo(Context appContext) {
        this.appContext = appContext;
    }

    public int getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(int idCerdo) {
        this.idCerdo = idCerdo;
    }

    public int getIdSanidad() {
        return idSanidad;
    }

    public void setIdSanidad(int idSanidad) {
        this.idSanidad = idSanidad;
    }

    public String getStrDosis() {
        return strDosis;
    }

    public void setStrDosis(String strDosis) {
        this.strDosis = strDosis;
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

    public String getStrViaAdministracion() {
        return strViaAdministracion;
    }

    public void setStrViaAdministracion(String strViaAdministracion) {
        this.strViaAdministracion = strViaAdministracion;
    }

    public String getStrFechaAdministracion() {
        return strFechaAdministracion;
    }

    public void setStrFechaAdministracion(String strFechaAdministracion) {
        this.strFechaAdministracion = strFechaAdministracion;
    }

    public String getStrCodigoCerdo() {
        return strCodigoCerdo;
    }

    public void setStrCodigoCerdo(String strCodigoCerdo) {
        this.strCodigoCerdo = strCodigoCerdo;
    }

    public String getStrSexoCerdo() {
        return strSexoCerdo;
    }

    public void setStrSexoCerdo(String strSexoCerdo) {
        this.strSexoCerdo = strSexoCerdo;
    }

    public String getStrError() {
        return strError;
    }

    public void setIdCerdoPK(int idCerdoPK) {
        this.idCerdoPK = idCerdoPK;
    }

    public void setIdSanidadPK(int idSanidadPK) {
        this.idSanidadPK = idSanidadPK;
    }

    public void setStrFechaAdministracionPK(String strFechaAdministracionPK) {
        this.strFechaAdministracionPK = strFechaAdministracionPK;
    }

    public boolean insertSanidadCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("IDSANIDAD",this.idSanidad);
        ctValores.put("VIAADMINISTRACION",this.strViaAdministracion);
        ctValores.put("FECHAADMINISTRACION",this.strFechaAdministracion);
        ctValores.put("DOSIS",this.strDosis);
        dbAcces.insertDatabase("SANIDADCERDO",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateSanidadCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("IDSANIDAD",this.idSanidad);
        ctValores.put("VIAADMINISTRACION",this.strViaAdministracion);
        ctValores.put("FECHAADMINISTRACION",this.strFechaAdministracion);
        ctValores.put("DOSIS",this.strDosis);
        String strArgs[] = new String[]{String.valueOf(this.idSanidadPK),String.valueOf(this.idCerdoPK),String.valueOf(this.strFechaAdministracionPK)};
        dbAcces.updateDatabase("SANIDADCERDO",ctValores,"IDSANIDAD=? AND IDCERDO=? AND FECHAADMINISTRACION=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteSanidadCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idSanidadPK),String.valueOf(this.idCerdoPK),String.valueOf(this.strFechaAdministracionPK)};
        dbAcces.deleteDatabase ("SANIDADCERDO","IDSANIDAD=? AND IDCERDO=? AND FECHAADMINISTRACION=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public SanidadCerdo getSanidadCerdo(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        SanidadCerdo tmpObject = new SanidadCerdo(appContext);
        String strSql = String.format("SELECT SANIDAD.IDSANIDAD,CERDO.IDCERDO, CERDO.CODIGO,CERDO.SEXO,SANIDAD.TIPOMEDICAMENTO,SANIDAD.NOMBREMEDICAMENTO,SANIDAD.OBSERVACIONES,SANIDADCERDO.FECHAADMINISTRACION,SANIDADCERDO.VIAADMINISTRACION,SANIDADCERDO.DOSIS FROM SANIDADCERDO LEFT JOIN CERDO ON SANIDADCERDO.IDCERDO = CERDO.IDCERDO LEFT JOIN SANIDAD ON SANIDAD.IDSANIDAD=SANIDADCERDO.IDSANIDAD WHERE IDCERDO = '%s'",String.valueOf(idCerdo));
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql (strSql);
        if (crResult.moveToFirst()) {
            tmpObject.setIdSanidad(crResult.getInt(0));
            tmpObject.setIdCerdo(crResult.getInt(1));
            tmpObject.setStrCodigoCerdo(crResult.getString(2));
            tmpObject.setStrSexoCerdo(crResult.getString(3));
            tmpObject.setStrTipoMedicamento(crResult.getString(4));
            tmpObject.setStrNombreMedicamento(crResult.getString(5));
            tmpObject.setStrFechaAdministracion(crResult.getString(7));
            tmpObject.setStrViaAdministracion(crResult.getString(8));
            tmpObject.setStrDosis(crResult.getString(9));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<SanidadCerdo> getAllSanidadCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        ArrayList<SanidadCerdo> listObject = new ArrayList<SanidadCerdo>();
        String strSsql="SELECT SANIDAD.IDSANIDAD,CERDO.IDCERDO, CERDO.CODIGO,CERDO.SEXO,SANIDAD.TIPOMEDICAMENTO,SANIDAD.NOMBREMEDICAMENTO,SANIDAD.OBSERVACIONES,SANIDADCERDO.FECHAADMINISTRACION,SANIDADCERDO.VIAADMINISTRACION,SANIDADCERDO.DOSIS FROM SANIDADCERDO LEFT JOIN CERDO ON SANIDADCERDO.IDCERDO = CERDO.IDCERDO LEFT JOIN SANIDAD ON SANIDAD.IDSANIDAD=SANIDADCERDO.IDSANIDAD ORDER BY CERDO.IDCERDO";
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql (strSsql);

        if (crResult.moveToFirst()) {
            do {
                SanidadCerdo tmpObject = new SanidadCerdo(appContext);
                tmpObject.setIdSanidad(crResult.getInt(0));
                tmpObject.setIdCerdo(crResult.getInt(1));
                tmpObject.setStrCodigoCerdo(crResult.getString(2));
                tmpObject.setStrSexoCerdo(crResult.getString(3));
                tmpObject.setStrTipoMedicamento(crResult.getString(4));
                tmpObject.setStrNombreMedicamento(crResult.getString(5));
                tmpObject.setStrFechaAdministracion(crResult.getString(7));
                tmpObject.setStrViaAdministracion(crResult.getString(8));
                tmpObject.setStrDosis(crResult.getString(9));
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

    public Boolean existSanidadCerdoByIdSanidad(int idSanidad){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM SanidadCerdo WHERE IDSANIDAD='%s'",idSanidad);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }

    public Boolean existSanidadCerdoByIdSanidadCerdo(int idSanidad, int idCerdo, String strFechaAdmin){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM SanidadCerdo WHERE IDSANIDAD='%s' AND IDCERDO='%s' AND FECHAADMINISTRACION='%s' ",idSanidad, idCerdo, strFechaAdmin);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }

    public Boolean existSanidadCerdoByIdCerdo(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM SanidadCerdo WHERE IDCERDO='%s'",idCerdo);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }



}
