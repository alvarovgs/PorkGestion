package com.example.a201495_2.porkgestion.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.example.a201495_2.porkgestion.bo_clases.LogError;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class dataBaseOpenHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "Porkgestion.db";
    private static final String DATABASE_PATH = "/data/data/com.example.a201495_2.porkgestion/databases/";
    private static final int DATABASE_VERSION=1;
    private Context mContext;
    private SQLiteDatabase dataBase;

    private String strErrorDB = null;

    public dataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME,  null  , DATABASE_VERSION);
        mContext = context;
        setForcedUpgrade();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Cuando haya cambios en la estructura deberemos
    }

    public String getErrorDB() {
        return strErrorDB;
    }

    public void createDataBase() {
        boolean dbExist = checkDataBase();
        if(dbExist){
            //la base de datos existe y no hacemos nada.
        }else{
            //Llamando a este método se crea la base de datos vacía en la ruta
            //por defecto del sistema de nuestra aplicación por lo que podremos
            //sobreescribirla con nuestra base de datos.
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                this.strErrorDB = e.getMessage();
                //throw new Error("Error copiando Base de Datos");
            }
        }
    }
    /**
     * Comprueba si la base de datos existe para evitar copiar siempre el
     * archivo cada vez que se abra la aplicación.
     * @return true si existe, false si no existe
     */
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String strPath = mContext.getDatabasePath(DATABASE_NAME).getPath();
            checkDB = SQLiteDatabase.openDatabase(strPath,null,SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){
            //si llegamos aqui es porque la base de datos no existe todavía.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null;
    }

    /**
     * Copia nuestra base de datos desde la carpeta assets a la recién creada
     * base de datos en la carpeta de sistema, desde dónde podremos acceder a ella
     * */
    private void copyDataBase() throws IOException{
        //Abrimos el fichero de base de datos como entrada
        InputStream myInput = mContext.getAssets().open(DATABASE_NAME);
        //Ruta a la base de datos vacía recién creada
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        //Abrimos la base de datos vacía como salida
        OutputStream myOutput = new FileOutputStream(outFileName);
        //Transferimos los bytes desde el fichero de entrada al de salida
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        //Liberamos los streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        //Abre la base de datos
        try {
            createDataBase();
        } catch (Exception e) {
            this.strErrorDB = e.getMessage();
            //throw new Error("Ha sido imposible crear la Base de Datos");
        }
        String strPath = DATABASE_PATH + DATABASE_NAME;
        dataBase = SQLiteDatabase.openDatabase(strPath,null,SQLiteDatabase.OPEN_READWRITE);
    }


    public void closeDataBase() {
        if(dataBase != null)
            dataBase.close();
        super.close();
    }

    public void insertDatabase(String strTableName, ContentValues ctValues){
        try {
            openDataBase();
            dataBase.insertOrThrow(strTableName, null, ctValues);
        }
        catch(Exception e){
            LogError objLogError = new LogError(mContext,"DATABASE.insertDatabase",e.getMessage());
            objLogError.addError();
            this.strErrorDB = e.getMessage();
            closeDataBase();
        }
        closeDataBase();
    }
    public Cursor qweryDatabase(String strTableName, String[] strColumns, String strValues,String[] strArgs, String strOrder){
        Cursor crResult=null;
        try {
            crResult = dataBase.query(strTableName, strColumns, strValues, strArgs, null, null, strOrder);
        }
        catch(Exception e){
            LogError objLogError = new LogError(mContext,"DATABASE.insertDatabase",e.getMessage());
            objLogError.addError();
            this.strErrorDB = e.getMessage();
        }
        return crResult;
    }

    public void updateDatabase(String strTableName, ContentValues ctValues, String strWhere, String[] strWhereArgs){
        try {
            openDataBase();
            dataBase.update(strTableName,ctValues,strWhere,strWhereArgs);
        }
        catch(Exception e){
            LogError objLogError = new LogError(mContext,"DATABASE.insertDatabase",e.getMessage());
            objLogError.addError();
            this.strErrorDB = e.getMessage();
            closeDataBase();
        }
        closeDataBase();
    }

    public void deleteDatabase(String strTableName, String strWhere, String[] strWhereArgs){
        try {
            openDataBase();
            dataBase.delete(strTableName,strWhere,strWhereArgs);
        }
        catch(Exception e){
            LogError objLogError = new LogError(mContext,"DATABASE.insertDatabase",e.getMessage());
            objLogError.addError();
            this.strErrorDB = e.getMessage();
            closeDataBase();
        }
        closeDataBase();
    }

    public Cursor qweryDatabaseBySql(String strSql){
        Cursor crResult = null;
        try {
            crResult = dataBase.rawQuery(strSql,null);
        }
        catch(Exception e){
            LogError objLogError = new LogError(mContext,"DATABASE.insertDatabase",e.getMessage());
            objLogError.addError();
            this.strErrorDB = e.getMessage();
        }
        return crResult;
    }

    public void execSqlCommand(String strSql){
        try {
            openDataBase();
            dataBase.execSQL(strSql);
        }
        catch(Exception e){
            LogError objLogError = new LogError(mContext,"DATABASE.insertDatabase",e.getMessage());
            objLogError.addError();
            this.strErrorDB = e.getMessage();
            closeDataBase();
        }
        closeDataBase();
    }


}
