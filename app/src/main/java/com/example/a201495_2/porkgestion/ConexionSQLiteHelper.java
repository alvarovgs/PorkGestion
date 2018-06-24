package com.example.a201495_2.porkgestion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a201495_2.porkgestion.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper{

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_RAZAS);
        db.execSQL(Utilidades.CREAR_TABLA_VENTA);
        db.execSQL(Utilidades.CREAR_TABLA_PRENEZ);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_RAZAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_VENTA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRENEZ);
        onCreate(db);
    }


}
