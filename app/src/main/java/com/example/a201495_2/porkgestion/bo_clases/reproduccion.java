package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;
import java.util.ArrayList;

public class reproduccion {
    private int idHembra, idVerraco, idPajilla;
    private String strFechaCelo, strError;
    private String strFechaMonta;
    private String strTipoMonta;
    private Context appContext;
    public boolean expanded = false;
    private dataBaseOpenHelper dbAcces;

    public reproduccion(Context appContext, int idCerdo, String strFechaCelo, String strFechaMonta, String strTipoMonta, int numeroVerraco, int numeroPajilla) {
        this.appContext = appContext;
        this.idHembra = idCerdo;
        this.idVerraco = numeroVerraco;
        this.idPajilla = numeroPajilla;
        this.strFechaCelo = strFechaCelo;
        this.strFechaMonta = strFechaMonta;
        this.strTipoMonta = strTipoMonta;
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

    public void setStrFechaCelo(String strFechaCelo) {
        this.strFechaCelo = strFechaCelo;
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

    public String getStrFechaCelo() {
        return strFechaCelo;
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

    public boolean insertMonta(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("FECHACELO",this.strFechaCelo);
        ctValores.put("FECHAMONTA",this.strFechaMonta);
        ctValores.put("TIPOMONTA",this.strTipoMonta);
        ctValores.put("IDHEMBRA",this.idHembra);
        ctValores.put("IDVERRACO",this.idVerraco);
        ctValores.put("IDPAJILLA",this.idPajilla);
        dbAcces.insertDatabase("REPRODUCCION",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateMonta(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("FECHACELO",this.strFechaCelo);
        ctValores.put("FECHAMONTA",this.strFechaMonta);
        ctValores.put("TIPOMONTA",this.strTipoMonta);
        ctValores.put("IDHEMBRA",this.idHembra);
        ctValores.put("IDVERRACO",this.idVerraco);
        ctValores.put("IDPAJILLA",this.idPajilla);
        String strArgs[] = new String[]{String.valueOf(this.idHembra)};
        dbAcces.updateDatabase("REPRODUCCION",ctValores,"IDHEMBRA=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean deleteMonta(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idHembra)};
        dbAcces.deleteDatabase ("REPRODUCCION","IDHEMBRA=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public Object getMontaByView(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDHEMBRA","IDVERRACO","IDPAJILLA","FECHACELO","FECHAMONTA","TIPOMONTA"};
        reproduccion tmpObject = new reproduccion(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_REPRODUCCION", strColumns, "(IDHEMBRA=?)", null, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdHembra(crResult.getInt(0));
            tmpObject.setIdVerraco(crResult.getInt(1));
            tmpObject.setIdPajilla(crResult.getInt(2));
            tmpObject.setStrFechaCelo(crResult.getString(3));
            tmpObject.setStrFechaMonta(crResult.getString(4));
            tmpObject.setStrTipoMonta(crResult.getString(5));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return dbAcces.getErrorDB()==null;
    }

    public Object getreproduccionByTable(String strCodigo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDHEMBRA","IDVERRACO","IDPAJILLA","FECHACELO","FECHAMONTA","TIPOMONTA"};
        reproduccion tmpObject = new reproduccion(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, "(IDHEMBRA=?)" , null, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdHembra(crResult.getInt(0));
            tmpObject.setIdVerraco(crResult.getInt(1));
            tmpObject.setIdPajilla(crResult.getInt(2));
            tmpObject.setStrFechaCelo(crResult.getString(3));
            tmpObject.setStrFechaMonta(crResult.getString(4));
            tmpObject.setStrTipoMonta(crResult.getString(5));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<reproduccion> getAllreproduccionByView(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDHEMBRA","IDVERRACO","IDPAJILLA","FECHACELO","FECHAMONTA","TIPOMONTA"};
        Cursor crResult;
        ArrayList<reproduccion> listMonta = new ArrayList<>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("VW_REPRODUCCION", strColumns, null, null, null);
        if (crResult.moveToFirst()) {
            do {
                reproduccion tmpObject = new reproduccion(appContext);
                tmpObject.setIdHembra(crResult.getInt(0));
                tmpObject.setIdVerraco(crResult.getInt(1));
                tmpObject.setIdPajilla(crResult.getInt(2));
                tmpObject.setStrFechaCelo(crResult.getString(3));
                tmpObject.setStrFechaMonta(crResult.getString(4));
                tmpObject.setStrTipoMonta(crResult.getString(5));
                listMonta.add(tmpObject);
            } while (crResult.moveToNext());

        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listMonta;
    }

    public ArrayList<reproduccion> getAllreproduccionByTable(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDHEMBRA","IDVERRACO","IDPAJILLA","FECHACELO","FECHAMONTA","TIPOMONTA"};
        Cursor crResult;
        ArrayList<reproduccion> listObject = new ArrayList<reproduccion>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("REPRODUCCION", strColumns, null, null, null);
        if (crResult.moveToFirst()) {
            do {
                reproduccion tmpObject = new reproduccion(appContext);
                tmpObject.setIdHembra(crResult.getInt(0));
                tmpObject.setIdVerraco(crResult.getInt(1));
                tmpObject.setIdPajilla(crResult.getInt(2));
                tmpObject.setStrFechaCelo(crResult.getString(3));
                tmpObject.setStrFechaMonta(crResult.getString(4));
                tmpObject.setStrTipoMonta(crResult.getString(5));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<reproduccion>  getCerdoByQwery(String strvalor1, String strValor2, String strVaslor3){
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
                tmpObject.setIdHembra(crResult.getInt(0));
                tmpObject.setIdVerraco(crResult.getInt(1));
                tmpObject.setIdPajilla(crResult.getInt(2));
                tmpObject.setStrFechaCelo(crResult.getString(3));
                tmpObject.setStrFechaMonta(crResult.getString(4));
                tmpObject.setStrTipoMonta(crResult.getString(5));
                listreproduccion.add(tmpObject);
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
