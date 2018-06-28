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
    private double dDosis;
    private String strTipoMedicamento, strNombreMedicamento, strViaAdministracion, strFechaAdministracion;;
    private String strCodigoCerdo, strSexoCerdo, strError;;

    public SanidadCerdo(int idCerdo, int idSanidad, double dDosis, String strTipoMedicamento, String strNombreMedicamento, String strViaAdministracion, String strFechaAdministracion, String strCodigoCerdo, String strSexoCerdo) {
        this.idCerdo = idCerdo;
        this.idSanidad = idSanidad;
        this.dDosis = dDosis;
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

    public double getdDosis() {
        return dDosis;
    }

    public void setdDosis(double dDosis) {
        this.dDosis = dDosis;
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

    public boolean insertSanidadCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("IDSANIDAD",this.idSanidad);
        ctValores.put("VIAADMINISTRACION",this.strViaAdministracion);
        ctValores.put("FECHAADMINISTRACION",this.strFechaAdministracion);
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
        String strArgs[] = new String[]{String.valueOf(this.idSanidad),String.valueOf(this.idCerdo)};
        dbAcces.updateDatabase("SANIDADCERDO",ctValores,"IDSANIDAD=? AND IDCERDO=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteSanidadCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idSanidad),String.valueOf(this.idCerdo)};
        dbAcces.deleteDatabase ("SANIDADCERDO","IDSANIDAD=? AND IDCERDO=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public SanidadCerdo getSanidadCerdo(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDSANIDAD","IDCERDO","CODIGO","SEXO","TIPOMEDICAMENTO","NOMBREMEDICAMENTO","FECHAADMINISTRACION","VIAADMINISTRACION"};
        String strArgs[] = new String[]{String.valueOf(idCerdo)};
        SanidadCerdo tmpObject = new SanidadCerdo(appContext);
        String sql="SELECT SANIDAD.IDSANIDAD,CERDO.IDCERDO, CERDO.CODIGO,CERDO.SEXO,SANIDAD.TIPOMEDICAMENTO,SANIDAD.NOMBREMEDICAMENTO,SANIDAD.OBSERVACIONES,SANIDADCERDO.FECHAADMINISTRACION,SANIDADCERDO.VIAADMINISTRACION,SANIDADCERDO.DOSIS FROM SANIDADCERDO INNER JOIN CERDO ON SANIDADCERDO.IDCERDO = CERDO.IDCERDO INNER JOIN SANIDAD ON SANIDAD.IDSANIDAD=SANIDADCERDO.IDSANIDAD";
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql (sql);
        if (crResult.moveToFirst()) {
            tmpObject.setIdSanidad(crResult.getInt(0));
            tmpObject.setIdCerdo(crResult.getInt(1));
            tmpObject.setStrCodigoCerdo(crResult.getString(2));
            tmpObject.setStrSexoCerdo(crResult.getString(3));
            tmpObject.setStrTipoMedicamento(crResult.getString(4));
            tmpObject.setStrNombreMedicamento(crResult.getString(5));
            tmpObject.setStrFechaAdministracion(crResult.getString(7));
            tmpObject.setStrViaAdministracion(crResult.getString(8));
            tmpObject.setdDosis(crResult.getDouble(9));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<SanidadCerdo> getAllSanidadCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDSANIDAD","IDCERDO","CODIGO","SEXO","TIPOMEDICAMENTO","NOMBREMEDICAMENTO","FECHAADMINISTRACION","VIAADMINISTRACION"};
        Cursor crResult;
        ArrayList<SanidadCerdo> listObject = new ArrayList<SanidadCerdo>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_SANIDADCERDO", strColumns, null, null, "IDSanidadCerdo");
        if (crResult.moveToFirst()) {
            do {
                SanidadCerdo tmpObject = new SanidadCerdo(appContext);
                tmpObject.setIdSanidad(crResult.getInt(0));
                tmpObject.setIdCerdo(crResult.getInt(1));
                tmpObject.setStrCodigoCerdo(crResult.getString(2));
                tmpObject.setStrSexoCerdo(crResult.getString(3));
                tmpObject.setStrTipoMedicamento(crResult.getString(4));
                tmpObject.setStrNombreMedicamento(crResult.getString(5));
                tmpObject.setStrFechaAdministracion(crResult.getString(6));
                tmpObject.setStrViaAdministracion(crResult.getString(7));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<SanidadCerdo>  getSanidadCerdoByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        ArrayList<SanidadCerdo> listObject = new ArrayList<SanidadCerdo>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                SanidadCerdo tmpObject = new SanidadCerdo(appContext);
                tmpObject.setIdSanidad(crResult.getInt(0));
                tmpObject.setIdCerdo(crResult.getInt(1));
                tmpObject.setStrCodigoCerdo(crResult.getString(2));
                tmpObject.setStrSexoCerdo(crResult.getString(3));
                tmpObject.setStrTipoMedicamento(crResult.getString(4));
                tmpObject.setStrNombreMedicamento(crResult.getString(5));
                tmpObject.setStrFechaAdministracion(crResult.getString(6));
                tmpObject.setStrViaAdministracion(crResult.getString(7));
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
