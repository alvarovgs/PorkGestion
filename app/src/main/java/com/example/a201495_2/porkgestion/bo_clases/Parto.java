package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

import java.util.ArrayList;

public class Parto {

    private Context appContext;
    private dataBaseOpenHelper dbAcces;
    private int idParto,idCerdo, vivosMachos,vivosHembras,muertosMachos,muertosHembras;
    private long promediPeso;
    private float indicemortalidad;
    private String strFechaParto, strCodigoCerdo,strError;

    public Parto(Context appContext, int idParto, int idCerdo, int vivosMachos, int vivosHembras, int muertosMachos, int muertosHembras, long promediPeso, float indicemortalidad, String strFechaParto, String strCodigoCerdo) {
        this.appContext = appContext;

        this.idParto = idParto;
        this.idCerdo = idCerdo;
        this.vivosMachos = vivosMachos;
        this.vivosHembras = vivosHembras;
        this.muertosMachos = muertosMachos;
        this.muertosHembras = muertosHembras;
        this.promediPeso = promediPeso;
        this.indicemortalidad = indicemortalidad;
        this.strFechaParto = strFechaParto;
        this.strCodigoCerdo = strCodigoCerdo;
    }
    public Parto(Context appContext){
        this.appContext = appContext;
    }

    public int getIdParto() {
        return idParto;
    }

    public void setIdParto(int idParto) {
        this.idParto = idParto;
    }

    public int getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(int idCerdo) {
        this.idCerdo = idCerdo;
    }

    public int getVivosMachos() {
        return vivosMachos;
    }

    public void setVivosMachos(int vivosMachos) {
        this.vivosMachos = vivosMachos;
    }

    public int getVivosHembras() {
        return vivosHembras;
    }

    public void setVivosHembras(int vivosHembras) {
        this.vivosHembras = vivosHembras;
    }

    public int getMuertosMachos() {
        return muertosMachos;
    }

    public void setMuertosMachos(int muertosMachos) {
        this.muertosMachos = muertosMachos;
    }

    public int getMuertosHembras() {
        return muertosHembras;
    }

    public void setMuertosHembras(int muertosHembras) {
        this.muertosHembras = muertosHembras;
    }

    public long getPromediPeso() {
        return promediPeso;
    }

    public void setPromediPeso(long promediPeso) {
        this.promediPeso = promediPeso;
    }

    public float getIndicemortalidad() {
        return indicemortalidad;
    }

    public void setIndicemortalidad(float indicemortalidad) {
        this.indicemortalidad = indicemortalidad;
    }

    public String getStrFechaParto() {
        return strFechaParto;
    }

    public void setStrFechaParto(String strFechaParto) {
        this.strFechaParto = strFechaParto;
    }

    public String getStrError() {
        return strError;
    }

    public void setStrError(String strError) {
        this.strError = strError;
    }

    public String getStrCodigoCerdo() {
        return strCodigoCerdo;
    }

    public void setStrCodigoCerdo(String strCodigoCerdo) {
        this.strCodigoCerdo = strCodigoCerdo;
    }


    public boolean insertParto(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("FECHAPARTO",this.strFechaParto);
        ctValores.put("LECHONESVIVOSMACHOS",this.vivosMachos);
        ctValores.put("LECHONESVIVOSHEMBRAS",this.vivosHembras);
        ctValores.put("LECHONESMUERTOSMACHOS",this.muertosMachos);
        ctValores.put("LECHONESMUERTOSHEMBRAS",this.muertosHembras);
        ctValores.put("INDICEMORTALIDAD",this.indicemortalidad);
        ctValores.put("PROMEDIOPESO",this.promediPeso);
        dbAcces.insertDatabase("PARTO",ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public Boolean updateParto(){
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("IDCERDO",this.idCerdo);
        ctValores.put("FECHAPARTO",this.strFechaParto);
        ctValores.put("LECHONESVIVOSMACHOS",this.vivosMachos);
        ctValores.put("LECHONESVIVOSHEMBRAS",this.vivosHembras);
        ctValores.put("LECHONESMUERTOSMACHOS",this.muertosMachos);
        ctValores.put("LECHONESMUERTOSHEMBRAS",this.muertosHembras);
        ctValores.put("INDICEMORTALIDAD",this.indicemortalidad);
        ctValores.put("PROMEDIOPESO",this.promediPeso);
        String strArgs[] = new String[]{String.valueOf(this.idParto)};
        dbAcces.updateDatabase("PARTO",ctValores,"IDPARTO=?",strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB()==null;
    }

    public ArrayList<String> consultaparto() {
        // SQLiteDatabase db=conn.getReadableDatabase();

        ArrayList<String> listapartos=new ArrayList<String>();
        dbAcces = new dataBaseOpenHelper(appContext);
        dbAcces.openDataBase();
        // com.example.a201495_2.porkgestion.entidades.Usuario usuario=null;
        //select * from usuarios
        String strSql = "SELECT IDPARTO, IDCERDO, FECHAPARTO,LECHONESVIVOSMACHOS,LECHONESVIVOSHEMBRAS,LECHONESMUERTOSMACHOS,LECHONESMUERTOSHEMBRAS, PROMEDIOPESO FROM PARTO";
        Cursor cursor;
        cursor = dbAcces.qweryDatabaseBySql(strSql);
        while (cursor.moveToNext()){
            /*Cerdo marrano=new Cerdo(appContext);
            marrano.setIdCerdo(cursor.getInt(0));
            marrano.setStrCodigo(cursor.getString(1));*/
            listapartos.add("ID PARTO: " +cursor.getInt(0));
            listapartos.add("Id Cerda: " +cursor.getInt(1));
            listapartos.add("Fecha de Parto: " + cursor.getString(2));
            listapartos.add("Lechones Vivos Machos: "+cursor.getString(3));
            listapartos.add("Lechones Vivos Hembras: " + cursor.getString(4));
            listapartos.add("Lechones Muertos Machos: "+cursor.getString(5));
            listapartos.add("Lechones Muertos Hembras: " + cursor.getString(6));
            listapartos.add("Peso Promedio: " + cursor.getString(7)+"KG");
            listapartos.add("");
        }
        return listapartos;
    }


    public Boolean deleteParto(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idParto)};
        dbAcces.deleteDatabase ("PARTO","IDPARTO=?",strArgs);
        return dbAcces.getErrorDB()==null;
    }

    public Parto getParto(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDPARTO","IDCERDO","FECHAPARTO","LECHONESVIVOSMACHOS","LECHONESVIVOSHEMBRAS","LECHONESMUERTOSMACHOS","LECHONESMUERTOSHEMBRAS","INDICEMORTALIDAD","PROMEDIOPESO"};
        String strArgs[] = new String[]{String.valueOf(idCerdo)};
        Parto tmpObject = new Parto(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("PARTO", strColumns, "IDCERDO=?", strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdParto(crResult.getInt(0));
            tmpObject.setIdCerdo(crResult.getInt(1));
            tmpObject.setStrFechaParto(crResult.getString(2));
            tmpObject.setVivosMachos(Integer.parseInt(crResult.getString(3)));
            tmpObject.setVivosHembras(Integer.parseInt(crResult.getString(4)));
            tmpObject.setMuertosMachos(Integer.parseInt(crResult.getString(5)));
            tmpObject.setMuertosHembras(Integer.parseInt(crResult.getString(6)));
            tmpObject.setIndicemortalidad(Integer.parseInt(crResult.getString(7)));
            tmpObject.setPromediPeso(Long.parseLong(crResult.getString(8)));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public Parto getPartoByView(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        Parto tmpObject = new Parto(appContext);
        String strSql = String.format("SELECT IDPARTO, PARTO.IDCERDO,  FECHAPARTO,LECHONESVIVOSMACHOS,LECHONESVIVOSHEMBRAS,LECHONESMUERTOSMACHOS,LECHONESMUERTOSHEMBRAS,INDICEMORTALIDAD,PROMEDIOPESO,CERDO.CODIGO FROM PARTO INNER JOIN CERDO ON CERDO.IDCERDO=PARTO.IDCERDO WHERE PARTO.IDCERDO='%s'",idCerdo);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            tmpObject.setIdParto(crResult.getInt(0));
            tmpObject.setIdCerdo(crResult.getInt(1));
            tmpObject.setStrFechaParto(crResult.getString(2));
            tmpObject.setVivosMachos(Integer.parseInt(crResult.getString(3)));
            tmpObject.setVivosHembras(Integer.parseInt(crResult.getString(4)));
            tmpObject.setMuertosMachos(Integer.parseInt(crResult.getString(5)));
            tmpObject.setMuertosHembras(Integer.parseInt(crResult.getString(6)));
            tmpObject.setIndicemortalidad(Integer.parseInt(crResult.getString(7)));
            tmpObject.setPromediPeso(Long.parseLong(crResult.getString(8)));
            tmpObject.setStrCodigoCerdo(crResult.getString(9));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }
    public ArrayList<Parto> getAllParto(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDPARTO","IDCERDO","FECHAPARTO","LECHONESVIVOSMACHOS","LECHONESVIVOSHEMBRAS","LECHONESMUERTOSMACHOS","LECHONESMUERTOSHEMBRAS","INDICEMORTALIDAD"};
        Cursor crResult;
        ArrayList<Parto> listObject = new ArrayList<Parto>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("Parto", strColumns, null, null, "IDParto");
        if (crResult.moveToFirst()) {
            do {
                Parto tmpObject = new Parto(appContext);
                tmpObject.setIdParto(crResult.getInt(0));
                tmpObject.setIdCerdo(crResult.getInt(1));
                tmpObject.setStrFechaParto(crResult.getString(2));
                tmpObject.setVivosMachos(Integer.parseInt(crResult.getString(3)));
                tmpObject.setVivosHembras(Integer.parseInt(crResult.getString(4)));
                tmpObject.setMuertosMachos(Integer.parseInt(crResult.getString(5)));
                tmpObject.setMuertosHembras(Integer.parseInt(crResult.getString(6)));
                tmpObject.setIndicemortalidad(Integer.parseInt(crResult.getString(7)));
                tmpObject.setPromediPeso(Long.parseLong(crResult.getString(8)));
                tmpObject.setStrCodigoCerdo(crResult.getString(9));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }
    public ArrayList<Parto> getAllPartoByView(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strSql = "SELECT IDPARTO, PARTO.IDCERDO, FECHAPARTO, IFNULL(LECHONESVIVOSMACHOS,0), IFNULL(LECHONESVIVOSHEMBRAS,0), IFNULL(LECHONESMUERTOSMACHOS,0), IFNULL(LECHONESMUERTOSHEMBRAS,0), IFNULL(INDICEMORTALIDAD,0), IFNULL(PROMEDIOPESO,0), CERDO.CODIGO FROM PARTO INNER JOIN CERDO ON CERDO.IDCERDO=PARTO.IDCERDO";
        Cursor crResult;
        ArrayList<Parto> listObject = new ArrayList<Parto>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            do {
                Parto tmpObject = new Parto(appContext);
                tmpObject.setIdParto(crResult.getInt(0));
                tmpObject.setIdCerdo(crResult.getInt(1));
                tmpObject.setStrFechaParto(crResult.getString(2));
                tmpObject.setVivosMachos(Integer.parseInt(crResult.getString(3)));
                tmpObject.setVivosHembras(Integer.parseInt(crResult.getString(4)));
                tmpObject.setMuertosMachos(Integer.parseInt(crResult.getString(5)));
                tmpObject.setMuertosHembras(Integer.parseInt(crResult.getString(6)));
                tmpObject.setIndicemortalidad(Integer.parseInt(crResult.getString(7)));
                tmpObject.setPromediPeso(Long.parseLong(crResult.getString(8)));
                tmpObject.setStrCodigoCerdo(crResult.getString(9));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public float indiceMortalidad(){
        int TotalCerdos;
        int totalMuertos;
        float indice;
        TotalCerdos = this.muertosHembras + this.muertosMachos + this.vivosHembras + this.vivosHembras;
        totalMuertos = this.muertosHembras + this.muertosMachos;
        indice = ((float)totalMuertos/TotalCerdos)*100;

        return indice;
    }

    public Boolean existParto(int idParto){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM PARTO WHERE IDPARTO='%s'",idParto);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }
    public Boolean existPartobyidCerdo(int idCerdo){
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult  = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM PARTO WHERE IDCERDO='%s'",idCerdo);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            bResult  =  crResult.getInt(0)>0;
        }
        dbAcces.closeDataBase();
        return bResult;
    }


}


