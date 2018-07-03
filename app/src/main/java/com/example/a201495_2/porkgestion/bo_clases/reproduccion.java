package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;
import java.util.ArrayList;

public class reproduccion {
    private int idHembra, idVerraco, idPajilla, idReproduccion;
    private String strError;
    private String strFechaMonta;
    private String strTipoMonta;
    private String strCodigoVerraco;
    private String strCodigoHembra;
    private String strCodigoPajilla;
    private String strEstado;
    private int idEstado;
    private Context appContext;
    public boolean expanded = false;
    private dataBaseOpenHelper dbAcces;

    public reproduccion(int idHembra, int idVerraco, int idPajilla, int idReproduccion, String strFechaMonta, String strTipoMonta, String strCodigoVerraco, String strCodigoHembra, String strCodigoPajilla, String strEstado, int idEstado) {
        this.idHembra = idHembra;
        this.idVerraco = idVerraco;
        this.idPajilla = idPajilla;
        this.idReproduccion = idReproduccion;
        this.strFechaMonta = strFechaMonta;
        this.strTipoMonta = strTipoMonta;
        this.strCodigoVerraco = strCodigoVerraco;
        this.strCodigoHembra = strCodigoHembra;
        this.strCodigoPajilla = strCodigoPajilla;
        this.strEstado = strEstado;
        this.idEstado = idEstado;
    }

    public reproduccion(Context appContext){
        this.appContext = appContext;
    }

    public int getIdHembra() {
        return idHembra;
    }

    public void setIdHembra(int idHembra) {
        this.idHembra = idHembra;
    }

    public int getIdVerraco() {
        return idVerraco;
    }

    public void setIdVerraco(int idVerraco) {
        this.idVerraco = idVerraco;
    }

    public int getIdPajilla() {
        return idPajilla;
    }

    public void setIdPajilla(int idPajilla) {
        this.idPajilla = idPajilla;
    }

    public int getIdReproduccion() {
        return idReproduccion;
    }

    public void setIdReproduccion(int idReproduccion) {
        this.idReproduccion = idReproduccion;
    }

    public String getStrError() {
        return strError;
    }

    public void setStrError(String strError) {
        this.strError = strError;
    }

    public String getStrFechaMonta() {
        return strFechaMonta;
    }

    public void setStrFechaMonta(String strFechaMonta) {
        this.strFechaMonta = strFechaMonta;
    }

    public String getStrTipoMonta() {
        return strTipoMonta;
    }

    public void setStrTipoMonta(String strTipoMonta) {
        this.strTipoMonta = strTipoMonta;
    }

    public String getStrCodigoVerraco() {
        return strCodigoVerraco;
    }

    public void setStrCodigoVerraco(String strCodigoVerraco) {
        this.strCodigoVerraco = strCodigoVerraco;
    }

    public String getStrCodigoHembra() {
        return strCodigoHembra;
    }

    public void setStrCodigoHembra(String strCodigoHembra) {
        this.strCodigoHembra = strCodigoHembra;
    }

    public String getStrCodigoPajilla() {
        return strCodigoPajilla;
    }

    public void setStrCodigoPajilla(String strCodigoPajilla) {
        this.strCodigoPajilla = strCodigoPajilla;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getstrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    public boolean insertReproduccion(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("TIPO",this.strTipoMonta);
        ctValores.put("IDHEMBRA",this.idHembra);
        ctValores.put("IDVERRACO",this.idVerraco);
        ctValores.put("IDPAJILLA",this.idPajilla);
        ctValores.put("FECHA",this.strFechaMonta);
        ctValores.put("ESTADO",this.idEstado);
        dbAcces.insertDatabase("REPRODUCCION",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateReproduccion(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("TIPO",this.strTipoMonta);
        ctValores.put("IDHEMBRA",this.idHembra);
        ctValores.put("IDVERRACO",this.idVerraco);
        ctValores.put("IDPAJILLA",this.idPajilla);
        ctValores.put("FECHA",this.strFechaMonta);
        ctValores.put("ESTADO",this.idEstado);
        String strArgs[] = new String[]{String.valueOf(this.idReproduccion)};
        dbAcces.updateDatabase("REPRODUCCION",ctValores,"IDREPRODUCCION=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteReproduccion(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idReproduccion)};
        dbAcces.deleteDatabase ("REPRODUCCION","IDREPRODUCCION=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public reproduccion getReroduccionByView(String strIdHembra){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"TIPO","IDHEMBRA","IDVERRACO","IDPAJILLA","FECHA","ESTADO","IDREPRODUCCION"};
        reproduccion tmpObject = new reproduccion(appContext);
        String strArgs[] = new String[]{strIdHembra};

        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, "(IDHEMBRA=?)",strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setStrTipoMonta(crResult.getString(0));
            tmpObject.setIdHembra(crResult.getInt(1));
            tmpObject.setIdVerraco(crResult.getInt(2));
            tmpObject.setIdPajilla(crResult.getInt(3));
            tmpObject.setStrFechaMonta(crResult.getString(4));
            tmpObject.setIdEstado(crResult.getInt(5));
            tmpObject.setIdReproduccion(crResult.getInt(6));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }
    
    public reproduccion getReproduccionByTable(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"TIPO","IDHEMBRA","IDVERRACO","IDPAJILLA","FECHA","ESTADO","IDREPRODUCCION"};
        reproduccion tmpObject = new reproduccion(appContext);
        String strArgs[] = new String[]{strCodigo};
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, "(IDHEMBRA=?)" , strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setStrTipoMonta(crResult.getString(0));
            tmpObject.setIdHembra(crResult.getInt(1));
            tmpObject.setIdVerraco(crResult.getInt(2));
            tmpObject.setIdPajilla(crResult.getInt(3));
            tmpObject.setStrFechaMonta(crResult.getString(4));
            tmpObject.setIdEstado(crResult.getInt(5));
            tmpObject.setIdReproduccion(crResult.getInt(6));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<reproduccion> getAllReproduccionByTable(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"TIPO","IDHEMBRA","IDVERRACO","IDPAJILLA","FECHA","ESTADO","IDREPRODUCCION"};
        Cursor crResult;
        ArrayList<reproduccion> listObject = new ArrayList<reproduccion>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, null,null, "IDHEMBRA");
        if (crResult.moveToFirst()) {
            do {
                reproduccion tmpObject = new reproduccion(appContext);
                tmpObject.setStrTipoMonta(crResult.getString(0));
                tmpObject.setIdHembra(crResult.getInt(1));
                tmpObject.setIdVerraco(crResult.getInt(2));
                tmpObject.setIdPajilla(crResult.getInt(3));
                tmpObject.setStrFechaMonta(crResult.getString(4));
                tmpObject.setIdEstado(crResult.getInt(5));
                tmpObject.setIdReproduccion(crResult.getInt(6));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<reproduccion> getAllReproduccionByView(){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql = "SELECT IDREPRODUCCION, TIPO, IDHEMBRA, IDVERRACO, IFNULL(R.IDPAJILLA,0) AS IDPAJILLA, FECHA, ESTADO, VERRACO.CODIGO AS NOMBREVERRACO, HEMBRA.CODIGO AS NOMBREHEMBRA,IFNULL(PAJILLA.CODIGOPAJILLA,0) AS CODIGOPAJILLA, CASE (ESTADO) WHEN 1 THEN 'CONFIRMADA' WHEN 2 THEN 'SIN CONFIRMAR' ELSE ESTADO END AS ESTADO \n" +
                "FROM REPRODUCCION R \n" +
                "LEFT JOIN CERDO AS VERRACO \n" +
                "ON VERRACO.IDCERDO = R.IDVERRACO \n" +
                "LEFT JOIN CERDO AS HEMBRA \n" +
                "ON HEMBRA.IDCERDO = R.IDHEMBRA \n" +
                "LEFT JOIN PAJILLA \n" +
                "ON PAJILLA.IDPAJILLA = R.IDPAJILLA ORDER BY R.IDHEMBRA\n";
        ArrayList<reproduccion> listObject = new ArrayList<reproduccion>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            do {
                reproduccion tmpObject = new reproduccion(appContext);
                tmpObject.setIdReproduccion(crResult.getInt(0));
                tmpObject.setStrTipoMonta(crResult.getString(1));
                tmpObject.setIdHembra(crResult.getInt(2));
                tmpObject.setIdVerraco(crResult.getInt(3));
                tmpObject.setIdPajilla(crResult.getInt(4));
                tmpObject.setStrFechaMonta(crResult.getString(5));
                tmpObject.setIdEstado(crResult.getInt(6));
                tmpObject.setStrCodigoVerraco(crResult.getString(7));
                tmpObject.setStrCodigoHembra(crResult.getString(8));
                tmpObject.setStrCodigoPajilla(crResult.getString(9));
                tmpObject.setStrEstado(crResult.getString(10));
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

    public Boolean existReproduccion(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM REPRODUCCION WHERE IDHEMBRA='%s'",idCerdo);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }

    public ArrayList<String> consultagestantes() {
        ArrayList<String> listagestantes=new ArrayList<String>();
        dbAcces = new dataBaseOpenHelper(appContext);
        dbAcces.openDataBase();
        String strSql = "SELECT IDHEMBRA, TIPO, IDVERRACO,IDPAJILLA,FECHA,ESTADO FROM REPRODUCCION";
        Cursor cursor;
        cursor = dbAcces.qweryDatabaseBySql(strSql);
        while (cursor.moveToNext()){
            listagestantes.add("ID HEMBRA: " +cursor.getInt(0));
            listagestantes.add("Tipo de Monta: " +cursor.getString(1));
            listagestantes.add("Id del Verraco o Pajilla: " + cursor.getInt(2)+" - "+ cursor.getInt(3));
            listagestantes.add("Fecha de Monta: "+cursor.getString(4));
            listagestantes.add("Estado de Prenez: " + cursor.getString(5));
            listagestantes.add("");
        }
        return listagestantes;
    }

}
