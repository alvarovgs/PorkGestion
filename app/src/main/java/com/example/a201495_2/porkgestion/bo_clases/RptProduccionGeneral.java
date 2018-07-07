package com.example.a201495_2.porkgestion.bo_clases;

import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

public class RptProduccionGeneral {
    private int totalMachos, totalHembras, totalCerdos;
    private int ventaMachos, ventaHembras, totalVentas;
    private int partoMachosV, partoHembrasV, totalParto,partoMachosM, partoHembrasM;
    private String strTotalPrecio, strPesoVenta, strError;
    private Context appContext;
    public boolean expanded = false;
    private dataBaseOpenHelper dbAcces;

    public RptProduccionGeneral(int totalMachos, int totalHembras, int totalCerdos, int ventaMachos, int ventaHembras, int totalVentas, int partoMachosV, int partoHembrasV, int totalParto, int partoMachosM, int partoHembrasM, String strTotalPrecio, String strPesoVenta, Context appContext) {
        this.totalMachos = totalMachos;
        this.totalHembras = totalHembras;
        this.totalCerdos = totalCerdos;
        this.ventaMachos = ventaMachos;
        this.ventaHembras = ventaHembras;
        this.totalVentas = totalVentas;
        this.partoMachosV = partoMachosV;
        this.partoHembrasV = partoHembrasV;
        this.totalParto = totalParto;
        this.partoMachosM = partoMachosM;
        this.partoHembrasM = partoHembrasM;
        this.strTotalPrecio = strTotalPrecio;
        this.strPesoVenta = strPesoVenta;
        this.appContext = appContext;
    }

    public int getPartoMachosV() {
        return partoMachosV;
    }

    public void setPartoMachosV(int partoMachosV) {
        this.partoMachosV = partoMachosV;
    }

    public int getPartoHembrasV() {
        return partoHembrasV;
    }

    public void setPartoHembrasV(int partoHembrasV) {
        this.partoHembrasV = partoHembrasV;
    }

    public int getTotalParto() {
        return totalParto;
    }

    public void setTotalParto(int totalParto) {
        this.totalParto = totalParto;
    }

    public int getPartoMachosM() {
        return partoMachosM;
    }

    public void setPartoMachosM(int partoMachosM) {
        this.partoMachosM = partoMachosM;
    }

    public int getPartoHembrasM() {
        return partoHembrasM;
    }

    public void setPartoHembrasM(int partoHembrasM) {
        this.partoHembrasM = partoHembrasM;
    }

    public String getStrError() {
        return strError;
    }

    public void setStrError(String strError) {
        this.strError = strError;
    }

    public RptProduccionGeneral(Context appContext) {
        this.appContext= appContext;
    }

    public int getVentaMachos() {
        return ventaMachos;
    }

    public void setVentaMachos(int ventaMachos) {
        this.ventaMachos = ventaMachos;
    }

    public int getVentaHembras() {
        return ventaHembras;
    }

    public void setVentaHembras(int ventaHembras) {
        this.ventaHembras = ventaHembras;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getStrTotalPrecio() {
        return strTotalPrecio;
    }

    public void setStrTotalPrecio(String strTotalPrecio) {
        this.strTotalPrecio = strTotalPrecio;
    }

    public String getStrPesoVenta() {
        return strPesoVenta;
    }

    public void setStrPesoVenta(String strPesoVenta) {
        this.strPesoVenta = strPesoVenta;
    }

    public int getTotalMachos() {
        return totalMachos;
    }

    public void setTotalMachos(int totalMachos) {
        this.totalMachos = totalMachos;
    }

    public int getTotalHembras() {
        return totalHembras;
    }

    public void setTotalHembras(int totalHembras) {
        this.totalHembras = totalHembras;
    }

    public int getTotalCerdos() {
        return totalCerdos;
    }

    public void setTotalCerdos(int totalCerdos) {
        this.totalCerdos = totalCerdos;
    }

    public RptProduccionGeneral getDataCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        RptProduccionGeneral tmpObject = new RptProduccionGeneral(appContext);
        String strSql = "SELECT SUM(CASE WHEN(SEXO ='HEMBRA') THEN 1 ELSE 0 END) AS HEMBRAS, SUM(CASE WHEN(SEXO ='MACHO') THEN 1 ELSE 0 END) AS MACHOS, COUNT(*) AS TOTAL FROM CERDO";
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            tmpObject.setTotalHembras(crResult.getInt(0));
            tmpObject.setTotalMachos(crResult.getInt(1));
            tmpObject.setTotalCerdos(crResult.getInt(2));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public RptProduccionGeneral getRptVenta(String strFechaI, String strFechaF){
        dbAcces = new dataBaseOpenHelper(appContext);
        RptProduccionGeneral tmpObject = new RptProduccionGeneral(appContext);
        String strSql = String.format("SELECT SUM(CASE WHEN(SEXO ='HEMBRA') THEN 1 ELSE 0 END) AS HEMBRAS, SUM(CASE WHEN(SEXO ='MACHO') THEN 1 ELSE 0 END) AS MACHOS ,COUNT(VENTACERDO.IDCERDO) AS TOTAL, SUM(PRECIOVENTA) AS PRECIO, AVG(PESOVIVO) AS PESO \n" +
                "FROM VENTACERDO INNER JOIN CERDO ON CERDO.IDCERDO=VENTACERDO.IDCERDO \n" +
                "GROUP BY SEXO\n",strFechaI,strFechaF);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            tmpObject.setVentaHembras(crResult.getInt(0));
            tmpObject.setVentaMachos(crResult.getInt(1));
            tmpObject.setTotalVentas(crResult.getInt(2));
            tmpObject.setStrTotalPrecio(crResult.getString(3));
            tmpObject.setStrPesoVenta(crResult.getString(4));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public RptProduccionGeneral getRptParto(String strFechaI, String strFechaF){
        dbAcces = new dataBaseOpenHelper(appContext);
        RptProduccionGeneral tmpObject = new RptProduccionGeneral(appContext);
        String strSql = String.format("SELECT COUNT(*) AS TOTAL, SUM(LECHONESVIVOSMACHOS) AS MVIVOS, SUM(LECHONESVIVOSHEMBRAS) AS HVIVOS, SUM(LECHONESMUERTOSMACHOS) AS MMUERTOS,SUM(LECHONESMUERTOSHEMBRAS) AS HMUERTOS \n" +
                "FROM PARTO \n" +
                "WHERE SUBSTR(FECHAPARTO,7,4)||SUBSTR(FECHAPARTO,4,2)|| SUBSTR(FECHAPARTO,1,2) BETWEEN '%s' AND '%s' \n",strFechaI,strFechaF);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            tmpObject.setTotalParto(crResult.getInt(0));
            tmpObject.setPartoMachosV(crResult.getInt(1));
            tmpObject.setPartoHembrasV(crResult.getInt(2));
            tmpObject.setPartoMachosM(crResult.getInt(3));
            tmpObject.setPartoHembrasM(crResult.getInt(4));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

}
