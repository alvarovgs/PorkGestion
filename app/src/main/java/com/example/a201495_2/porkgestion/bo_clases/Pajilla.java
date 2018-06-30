package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;
import java.util.ArrayList;


public class Pajilla {
    private int idPajilla, idRaza;
    private String strCodigoPajilla, strFechaVence, strNombreRaza, strError;
    private Context appContext;
    public boolean expanded = false;
    private dataBaseOpenHelper dbAcces;


    public Pajilla(Context appContext, int idPajilla, int idRaa, String strCodigoPajilla, String strFechaVence, String strNombreRaza) {
        this.appContext = appContext;
        this.idPajilla = idPajilla;
        this.idRaza = idRaza;
        this.strCodigoPajilla = strCodigoPajilla;
        this.strFechaVence = strFechaVence;
        this.strNombreRaza = strNombreRaza;
    }

    public Pajilla(Context appContext) {
        this.appContext = appContext;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getStrCodigoPajilla() {
        return strCodigoPajilla;
    }

    public void setStrCodigoPajilla(String strCodigoPajilla) {
        this.strCodigoPajilla = strCodigoPajilla;
    }

    public String getStrFechaVence() {
        return strFechaVence;
    }

    public void setStrFechaVence(String strFechaVence) {
        this.strFechaVence = strFechaVence;
    }

    public String getStrError() {
        return strError;
    }

    public int getIdPajilla() {
        return idPajilla;
    }

    public void setIdPajilla(int idpPajilla) {
        this.idPajilla = idpPajilla;
    }

    public String getStrNombreRaza() {
        return strNombreRaza;
    }

    public void setStrNombreRaza(String strNombreRaza) {
        this.strNombreRaza = strNombreRaza;
    }


    public boolean insertPajilla() {
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("CODIGOPAJILLA", this.strCodigoPajilla);
        ctValores.put("FECHAVENCIMIENTO", this.strFechaVence);
        ctValores.put("IDRAZA", this.idRaza);
        dbAcces.insertDatabase("PAJILLA", ctValores);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB() == null;
    }

    public Boolean updatePajilla() {
        dbAcces = new dataBaseOpenHelper(appContext);
        ContentValues ctValores = new ContentValues();
        ctValores.put("CODIGOPAJILLA", this.strCodigoPajilla);
        ctValores.put("FECHAVENCIMIENTO", this.strFechaVence);
        ctValores.put("IDRAZA", this.idRaza);
        String strArgs[] = new String[]{String.valueOf(this.idPajilla)};
        dbAcces.updateDatabase("PAJILLA", ctValores, "IDPAJILLA=?", strArgs);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB() == null;
    }

    public Boolean deletePajilla() {
        dbAcces = new dataBaseOpenHelper(appContext);
        String strArgs[] = new String[]{String.valueOf(this.idPajilla)};
        dbAcces.deleteDatabase("PAJILLA", "IDPAJILLA=?", strArgs);
        return dbAcces.getErrorDB() == null;
    }

    public Object getPajillaByTable(String strCodigo) {
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDPAJILLA", "CODIGOPAJILLA", "FECHAVENCIMIENTO", "IDRAZA"};
        String strArgs[] = new String[]{strCodigo, strCodigo};
        Pajilla tmpObject = new Pajilla(appContext);
        Cursor crResult;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("PAJILLA", strColumns, "(CODIGOPAJILLA=? OR IDPAJILLA=?)", strArgs, null);
        if (crResult.moveToFirst()) {
            tmpObject.setIdPajilla(crResult.getInt(0));
            tmpObject.setStrCodigoPajilla(crResult.getString(1));
            tmpObject.setStrFechaVence(crResult.getString(2));
            tmpObject.setIdRaza(crResult.getInt(3));
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return tmpObject;
    }

    public ArrayList<Pajilla> getAllPajillaByView() {
        dbAcces = new dataBaseOpenHelper(appContext);
        String strSql = "SELECT IDPAJILLA, CODIGOPAJILLA,FECHAVENCIMIENTO,NOMBRERAZA,RAZA.IDRAZA \n" +
                "FROM PAJILLA \n" +
                "INNER JOIN RAZA \n" +
                "ON PAJILLA.IDRAZA = RAZA.IDRAZA \n" +
                "ORDER BY IDPAJILLA";
        Cursor crResult;
        ArrayList<Pajilla> listObject = new ArrayList<Pajilla>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (crResult.moveToFirst()) {
            do {
                Pajilla tmpObject = new Pajilla(appContext);
                tmpObject.setIdPajilla(crResult.getInt(0));
                tmpObject.setStrCodigoPajilla(crResult.getString(1));
                tmpObject.setStrFechaVence(crResult.getString(2));
                tmpObject.setStrNombreRaza(crResult.getString(3));
                tmpObject.setIdRaza(crResult.getInt(4));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());

        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<Pajilla> getAllPajillaByTable() {
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDPAJILLA", "CODIGOPAJILLA", "FECHAVENCIMIENTO", "IDRAZA"};
        Cursor crResult;
        ArrayList<Pajilla> listObject = new ArrayList<Pajilla>();
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("PAJILLA", strColumns, null, null, "IDPAJILLA");
        if (crResult.moveToFirst()) {
            do {
                Pajilla tmpObject = new Pajilla(appContext);
                tmpObject.setIdPajilla(crResult.getInt(0));
                tmpObject.setStrCodigoPajilla(crResult.getString(1));
                tmpObject.setStrFechaVence(crResult.getString(2));
                tmpObject.setIdRaza(crResult.getInt(3));
                listObject.add(tmpObject);
            } while (crResult.moveToNext());
        }
        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listObject;
    }

    public ArrayList<Pajilla> getPajillaByQwery(String strvalor1, String strValor2, String strVaslor3) {
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql = null;
        ArrayList<Pajilla> listPajilla = new ArrayList<Pajilla>();
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        //TODO: Crear el arraylist a partir de los resultados
        if (crResult.moveToFirst()) {
            do {
                Pajilla tmpObject = new Pajilla(appContext);
                tmpObject.setIdPajilla(crResult.getInt(0));
                tmpObject.setStrCodigoPajilla(crResult.getString(1));
                tmpObject.setStrFechaVence(crResult.getString(2));
                tmpObject.setIdRaza(crResult.getInt(3));
                listPajilla.add(tmpObject);
            } while (crResult.moveToNext());
        }

        this.strError = dbAcces.getErrorDB();
        dbAcces.closeDataBase();
        return listPajilla;
    }

    public Boolean execDatabaseByQwery(String strvalor1, String strValor2, String strVaslor3) {
        dbAcces = new dataBaseOpenHelper(appContext);
        Cursor crResult;
        String strSql = null;
        //TODO:  A partir de los los campos recibido, se arma el Qhery y se actualiza la variable strSql;
        dbAcces.execSqlCommand(strSql);
        this.strError = dbAcces.getErrorDB();
        return dbAcces.getErrorDB() == null;
    }

    public Boolean existPajilla(String strCodigo) {
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM PAJILLA WHERE CODIGOPAJILLA='%s'", strCodigo);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (dbAcces.getErrorDB() == null) {
            if (crResult.moveToFirst()) {
                bResult = crResult.getInt(0) > 0;
            }
        } else {
            this.strError = dbAcces.getErrorDB();
            bResult = false;
        }
        dbAcces.closeDataBase();
        return bResult;
    }

    public Boolean existPajillaByRaza(int idRaza) {
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM PAJILLA WHERE IDRAZA='%s'", idRaza);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (dbAcces.getErrorDB() == null) {
            if (crResult.moveToFirst()) {
                bResult = crResult.getInt(0) > 0;
            }
        } else {
            this.strError = dbAcces.getErrorDB();
            bResult = false;
        }
        dbAcces.closeDataBase();
        return bResult;
    }
    public Boolean existPajillaByReproduccion(int idPajilla) {
        dbAcces = new dataBaseOpenHelper(appContext);
        Boolean bResult = false;
        Cursor crResult;
        String strSql = String.format("SELECT COUNT(*) AS TOTAL FROM REPRODUCCION WHERE IDPAJILLA='%s'", idPajilla);
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabaseBySql(strSql);
        if (dbAcces.getErrorDB() == null) {
            if (crResult.moveToFirst()) {
                bResult = crResult.getInt(0) > 0;
            }
        } else {
            this.strError = dbAcces.getErrorDB();
            bResult = false;
        }
        dbAcces.closeDataBase();
        return bResult;
    }
}




