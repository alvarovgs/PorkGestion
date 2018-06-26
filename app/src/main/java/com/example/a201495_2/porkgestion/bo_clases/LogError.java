package com.example.a201495_2.porkgestion.bo_clases;

import android.content.ContentValues;
import android.content.Context;

import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

public class LogError {
    private Context appContext;
    private String strModule;
    private String strErrDescription;

    public LogError(Context appContext, String strModule, String strErrDescription) {
        this.strErrDescription = strErrDescription;
        this.strModule = strModule;
        this.appContext = appContext;

    }


    public String getStrModule() {
        return strModule;
    }

    public String getStrErrDescription() {
        return strErrDescription;
    }

    public void setStrModule(String strModule) {
        this.strModule = strModule;
    }

    public void setStrErrDescription(String strErrDescription) {
        this.strErrDescription = strErrDescription;
    }

    public void addError(){
        dataBaseOpenHelper dbAcces = new dataBaseOpenHelper(this.appContext);
        ContentValues ctValues = new ContentValues();
        ctValues.put("MODULO",this.strModule);
        ctValues.put("DESCRIPCION",this.strErrDescription);
        dbAcces.openDataBase();
        dbAcces.insertDatabase("LOGERROR",ctValues);
        dbAcces.closeDataBase();
    }


}
