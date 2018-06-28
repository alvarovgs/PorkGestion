package com.example.a201495_2.porkgestion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDatos) {
        BaseDatos.execSQL("Create table parto (campo_codigoparto int primary key, campo_numerocerda int, campo_nombrecerda text," +
                " campo_fechaparto text, campo_totallechones int, campo_hembrasvivas int, campo_hembrasmuertas int," +
                " campo_machosvivos int, campo_machosmuertos int )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
