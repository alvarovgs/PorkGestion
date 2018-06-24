package com.example.a201495_2.porkgestion.utilidades;

public class Utilidades {

    public static String TABLA_USUARIOS="Usuarios";
    public static String CAMPO_IDCERDA="idcerda";
    public static String CAMPO_NOMBRECERDA="nombrecerda";
    public static String CAMPO_FECHAMONTA="fechamonta";
    public static String CAMPO_PRIMERCELO="primercelo";
    public static String CAMPO_PESOMONTA="pesomonta";
    public static String CAMPO_IDPAJILLA="idpajilla";
    public static String CAMPO_NOMBREVERRACO="nombreverraco";
    public static String CAMPO_ESTADO="estado";

    public static String TABLA_PAJILLAS="pajillas";
    public static String CAMPO_NUMPAJILLA="numpajilla";
    public static String CAMPO_NOMVERRACO="nomverraco";
    public static String CAMPO_NOMRAZA="nomraza";
    public static String CAMPO_VENCIMIENTO="vencimiento";
    public static String CAMPO_PROVEEDOR="proveedor";
    public static String CAMPO_OBSERVACIONES="observaciones";

    public static String TABLA_VERRACOS="verracos";
    public static String CAMPO_IDVERRACO="id_verraco";
    public static String CAMPO_NAMEVERRACO="nameverraco";
    public static String CAMPO_NAMERAZA="nameraza";
    public static String CAMPO_NACIMIENTOV="nacimientov";
    public static String CAMPO_PESOVERRACO="pesoverraco";
    public static String CAMPO_OBSERVACIONESV="observacionesv";

    //Constantes campos tabla usuario
    public static String TABLA_USUARIO = "usuario";
    public static String TABLA_RAZAS = "newrazas";
    public static String TABLA_VENTA = "venta";
    public static String CAMPO_ID = "id";
    public static String CAMPO_IDNUEVARAZA = "idnuevaraza";
    public static String CAMPO_NOMBRE = "nombre";
    public static String CAMPO_FECHANACE = "fechanace";
    public static String CAMPO_PESONACE = "pesonace";
    public static String CAMPO_SEXO = "sexo";
    public static String CAMPO_RAZA = "raza";
    public static String CAMPO_NOMBREMADRE = "nombremadre";
    public static String CAMPO_NOMBREPADRE = "nombrepadre";
    public static String CAMPO_NUEVARAZA = "nuevaraza";
    public static String CAMPO_IDANIMALVENTA = "idanimalventa";
    public static String CAMPO_NOMBREVENTA = "nombreventa";
    public static String CAMPO_FECHAVENTA = "fechaventa";
    public static String CAMPO_PESOVENTA = "pesoventa";
    public static String CAMPO_PRECIOVENTA = "precioventa";



    public static final String CREAR_TABLA_USUARIOS ="CREATE TABLE "+TABLA_USUARIOS+" ("+CAMPO_IDCERDA+" INTEGER, "+CAMPO_NOMBRECERDA+" TEXT, "+CAMPO_FECHAMONTA+" TEXT, " +
            ""+CAMPO_PRIMERCELO+" TXT, "+CAMPO_PESOMONTA+" TEXT, "+CAMPO_IDPAJILLA+" TEXT, "+CAMPO_NOMBREVERRACO+" TXT, "+CAMPO_ESTADO+" TEXT)";

    public static final String CREAR_TABLA_PAJILLAS="CREATE TABLE "+TABLA_PAJILLAS+" ("+CAMPO_NUMPAJILLA+" TEXT, "+CAMPO_NOMVERRACO+" TEXT, "+CAMPO_NOMRAZA+" TEXT, " +
            ""+CAMPO_VENCIMIENTO+" TXT, "+CAMPO_PROVEEDOR+" TEXT, "+CAMPO_OBSERVACIONES+" TEXT)";

    public static final String CREAR_TABLA_VERRACOS="CREATE TABLE "+TABLA_VERRACOS+" ("+CAMPO_IDVERRACO+" INTEGER, "+CAMPO_NAMEVERRACO+" TEXT, "+CAMPO_NAMERAZA+" TEXT, " +
            ""+CAMPO_NACIMIENTOV+" TXT, "+CAMPO_PESOVERRACO+" TEXT, "+CAMPO_OBSERVACIONESV+" TEXT)";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " +
            "" + TABLA_USUARIO + " (" + CAMPO_ID + " " +
            "INTEGER, " + CAMPO_NOMBRE + " TEXT," + CAMPO_FECHANACE + " TEXT, " + CAMPO_PESONACE + " INTEGER, " + CAMPO_SEXO + " " +
            "TEXT, " + CAMPO_RAZA + " TEXT, " + CAMPO_NOMBREMADRE + " TEXT, " + CAMPO_NOMBREPADRE + " TEXT)";

    public static final String CREAR_TABLA_RAZAS = "CREATE TABLE " +
            "" + TABLA_RAZAS + "(" + CAMPO_IDNUEVARAZA + " INTEGER," + CAMPO_NUEVARAZA + " TEXT)";

    public static final String CREAR_TABLA_VENTA = "CREATE TABLE " +
            "" + TABLA_VENTA + " (" + CAMPO_IDANIMALVENTA + " INTEGER, " + CAMPO_NOMBREVENTA + " TEXT, " + CAMPO_FECHAVENTA + " " +
            "TEXT, " + CAMPO_PESOVENTA + " INTEGER, " + CAMPO_PRECIOVENTA + " INTEGER)";


}
