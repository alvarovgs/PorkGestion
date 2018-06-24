package com.example.a201495_2.porkgestion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a201495_2.porkgestion.utilidades.Utilidades;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIOS);
        db.execSQL(Utilidades.CREAR_TABLA_PAJILLAS);
        db.execSQL(Utilidades.CREAR_TABLA_VERRACOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS utilidades.Usuarios");
    db.execSQL("DROP TABLE IF EXISTS utilidades.pajillas");
    db.execSQL("DROP TABLE IF EXISTS utilidades.verracos");

    onCreate(db);
    }
}
