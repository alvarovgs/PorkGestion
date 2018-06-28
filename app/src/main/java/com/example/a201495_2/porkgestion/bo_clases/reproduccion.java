package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;
import java.util.ArrayList;

public class reproduccion {
    private int idHembra, idVerraco, idPajilla;
    private String strError;
    private String strFechaMonta;
    private String strTipoMonta;
    private String strEstado;
    private Context appContext;
    public boolean expanded = false;
    private dataBaseOpenHelper dbAcces;



    public reproduccion(Context appContext, int idHembra, String strEstado, String strFechaMonta, String strTipoMonta, int idVerraco, int idPajilla) {
        this.appContext = appContext;
        this.idHembra = idHembra;
        this.idVerraco = idVerraco;
        this.idPajilla = idPajilla;
        this.strFechaMonta = strFechaMonta;
        this.strTipoMonta = strTipoMonta;
        this.strEstado = strEstado;
    }

    public reproduccion(Context appContext){
        this.appContext = appContext;
    }

    public void setIdHembra(int idHembra) {
        this.idHembra = idHembra;
    }

    public void setIdVerraco(int idVerraco) {
        this.idVerraco = idVerraco;
    }

    public void setIdPajilla(int idPajilla) {
        this.idPajilla = idPajilla;
    }

    public void setStrFechaMonta(String strFechaMonta) {
        this.strFechaMonta = strFechaMonta;
    }

    public void setStrTipoMonta(String strTipoMonta) {
        this.strTipoMonta = strTipoMonta;
    }

    public int getIdHembra() {
        return idHembra;
    }

    public int getIdVerraco() {
        return idVerraco;
    }

    public int getIdPajilla() {
        return idPajilla;
    }

    public String getStrFechaMonta() {
        return strFechaMonta;
    }

    public String getStrTipoMonta() {
        return strTipoMonta;
    }

    public String getStrError() {
        return strError;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }


    public boolean regprenez(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("TIPO",this.strTipoMonta);
        ctValores.put("IDHEMBRA",this.idHembra);
        ctValores.put("IDVERRACO",this.idVerraco);
        ctValores.put("IDPAJILLA",this.idPajilla);
        ctValores.put("FECHA",this.strFechaMonta);
        ctValores.put("ESTADO",this.strEstado);
        dbAcces.insertDatabase("REPRODUCCION",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateprenez(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("TIPO",this.strTipoMonta);
        ctValores.put("IDHEMBRA",this.idHembra);
        ctValores.put("IDVERRACO",this.idVerraco);
        ctValores.put("IDPAJILLA",this.idPajilla);
        ctValores.put("FECHA",this.strFechaMonta);
        ctValores.put("ESTADO",this.strEstado);
        String strArgs[] = new String[]{String.valueOf(this.idHembra)};
        dbAcces.updateDatabase("REPRODUCCION",ctValores,"IDHEMBRA=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteprenez(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idHembra)};
        dbAcces.deleteDatabase ("REPRODUCCION","IDHEMBRA=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public reproduccion getPrenezByView(String strIdCerda){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"TIPO","IDHEMBRA","IDVERRACO","IDPAJILLA","FECHA","ESTADO"};
        reproduccion tmpObject = new reproduccion(appContext);
        String strArgs[] = new String[]{strIdCerda};

        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, "(IDHEMBRA=?)",strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setStrTipoMonta(crResult.getString(0));
            tmpObject.setIdHembra(crResult.getInt(1));
            tmpObject.setIdVerraco(crResult.getInt(2));
            tmpObject.setIdPajilla(crResult.getInt(3));
            tmpObject.setStrFechaMonta(crResult.getString(4));
            tmpObject.setStrEstado(crResult.getString(5));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public reproduccion getPrenezByTable(String stridhembra){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"TIPO","IDHEMBRA","IDVERRACO","IDPAJILLA","FECHA","ESTADO"};
        reproduccion tmpObject = new reproduccion(appContext);
        String strArgs[] = new String[]{stridhembra};
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, "(IDHEMBRA=?)",strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setStrTipoMonta(crResult.getString(0));
            tmpObject.setIdHembra(crResult.getInt(1));
            tmpObject.setIdVerraco(crResult.getInt(2));
            tmpObject.setIdPajilla(crResult.getInt(3));
            tmpObject.setStrFechaMonta(crResult.getString(4));
            tmpObject.setStrEstado(crResult.getString(5));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<reproduccion> getAllPrenezByView(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"TIPO","IDHEMBRA","IDVERRACO","IDPAJILLA","FECHA","ESTADO"};
        Cursor crResult;
        ArrayList<reproduccion> listprenez = new ArrayList<>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_REPRODUCCION", strColumns, "(IDHEMBRA=?",null,null);
        if (crResult.moveToFirst()) {
            do {
                reproduccion tmpObject = new reproduccion(appContext);
                tmpObject.setStrTipoMonta(crResult.getString(0));
                tmpObject.setIdHembra(crResult.getInt(1));
                tmpObject.setIdVerraco(crResult.getInt(2));
                tmpObject.setIdPajilla(crResult.getInt(3));
                tmpObject.setStrFechaMonta(crResult.getString(4));
                tmpObject.setStrEstado(crResult.getString(5));
                listprenez.add(tmpObject);
            } while (crResult.moveToNext());

        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listprenez;
    }

    public ArrayList<reproduccion> getAllPrenezByTable(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"TIPO","IDHEMBRA","IDVERRACO","IDPAJILLA","FECHA","ESTADO"};
        Cursor crResult;
        ArrayList<reproduccion> listObject = new ArrayList<reproduccion>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, null,null, null);
        if (crResult.moveToFirst()) {
            do {
                reproduccion tmpObject = new reproduccion(appContext);
                tmpObject.setStrTipoMonta(crResult.getString(0));
                tmpObject.setIdHembra(crResult.getInt(1));
                tmpObject.setIdVerraco(crResult.getInt(2));
                tmpObject.setIdPajilla(crResult.getInt(3));
                tmpObject.setStrFechaMonta(crResult.getString(4));
                tmpObject.setStrEstado(crResult.getString(5));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<reproduccion>  getPrenezByQwery(String strvalor1, String strValor2, String strVaslor3){
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql=null;
        ArrayList<reproduccion> listreproduccion = new ArrayList<reproduccion>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                reproduccion tmpObject = new reproduccion(appContext);
                tmpObject.setStrTipoMonta(crResult.getString(0));
                tmpObject.setIdHembra(crResult.getInt(1));
                tmpObject.setIdVerraco(crResult.getInt(2));
                tmpObject.setIdPajilla(crResult.getInt(3));
                tmpObject.setStrFechaMonta(crResult.getString(4));
                tmpObject.setStrEstado(crResult.getString(5));
            } while (crResult.moveToNext());
        }

        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listreproduccion;
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
