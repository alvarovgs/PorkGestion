package com.example.a201495_2.porkgestion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a201495_2.porkgestion.utilidades.Utilidades;

<<<<<<< HEAD

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

=======
public class ConexionSQLiteHelper extends SQLiteOpenHelper{
>>>>>>> origin/fabian

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
<<<<<<< HEAD
        db.execSQL(Utilidades.CREAR_TABLA_PAJILLAS);
        db.execSQL(Utilidades.CREAR_TABLA_VERRACOS);

=======
        db.execSQL(Utilidades.CREAR_TABLA_RAZAS);
        db.execSQL(Utilidades.CREAR_TABLA_VENTA);
        db.execSQL(Utilidades.CREAR_TABLA_PRENEZ);
        db.execSQL(Utilidades.CREAR_TABLA_PAJILLA);
>>>>>>> origin/fabian
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
<<<<<<< HEAD
    db.execSQL("DROP TABLE IF EXISTS utilidades.Usuarios");
    db.execSQL("DROP TABLE IF EXISTS utilidades.pajillas");
    db.execSQL("DROP TABLE IF EXISTS utilidades.verracos");

    onCreate(db);
    }
=======
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_RAZAS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_VENTA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRENEZ);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PAJILLA);
        onCreate(db);
    }


>>>>>>> origin/fabian
}
