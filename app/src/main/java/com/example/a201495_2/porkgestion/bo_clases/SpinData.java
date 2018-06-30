package com.example.a201495_2.porkgestion.bo_clases;
import android.content.Context;
import android.database.Cursor;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

import java.util.ArrayList;

public class SpinData {
    private Context appContext;
    private dataBaseOpenHelper dbAcces;
    int id;
    String Valor;

    public SpinData(int id, String Valor) {
        this.id = id;
        this.Valor = Valor;
    }
    public SpinData(Context appContext) {
        this.appContext =appContext;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = Valor;
    }


    public SpinData[] getRaza(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDRAZA","NOMBRERAZA"};
        Cursor crResult;
        SpinData[] collData=new SpinData[0];
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("RAZA", strColumns, null, null, "NOMBRERAZA");
        if (crResult.moveToFirst()) {
            collData = new SpinData[crResult.getCount()];
            int i=0;
            do {
                collData[i] = new SpinData(crResult.getInt(0),crResult.getString(1));
                i=i+1;
            } while (crResult.moveToNext());
        }
        dbAcces.closeDataBase();
        return collData;
    }

    public SpinData[] getCerdo(){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","CODIGO"};
        Cursor crResult;
        SpinData[] collData=new SpinData[0];
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("CERDO", strColumns, null, null, "CODIGO");
        if (crResult.moveToFirst()) {
            collData = new SpinData[crResult.getCount()];
            int i=0;
            do {
                collData[i] = new SpinData(crResult.getInt(0),crResult.getString(1));
                i=i+1;
            } while (crResult.moveToNext());
        }
        dbAcces.closeDataBase();
        return collData;
    }
    public SpinData[] getCerdobySexo(String strSexo){
        dbAcces = new dataBaseOpenHelper(appContext);
        String strColumns[] = new String[]{"IDCERDO","CODIGO"};
        String strArgs[] = new String[]{strSexo};
        Cursor crResult;
        SpinData[] collData=new SpinData[0];
        dbAcces.openDataBase();
        crResult = dbAcces.qweryDatabase("CERDO", strColumns, "SEXO=?", strArgs, "CODIGO");
        if (crResult.moveToFirst()) {
            collData = new SpinData[crResult.getCount()];
            int i=0;
            do {
                collData[i] = new SpinData(crResult.getInt(0),crResult.getString(1));
                i=i+1;
            } while (crResult.moveToNext());
        }
        dbAcces.closeDataBase();
        return collData;
    }
    public SpinData[] getTipoMed(){
        SpinData[] collData=new SpinData[0];
        collData = new SpinData[3];
        collData[0] = new SpinData(1,"Desparasitacion");
        collData[1] = new SpinData(2,"Minerales");
        collData[2] = new SpinData(3,"Vacuna");
        return collData;
    }

    public SpinData[] getSexoCerdo(){
        SpinData[] collData=new SpinData[0];
        collData = new SpinData[3];
        collData[0] = new SpinData(1,"MACHO");
        collData[1] = new SpinData(2,"HEMBRA");
        return collData;
    }


}
