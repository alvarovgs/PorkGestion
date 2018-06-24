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



    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIOS+" ("+CAMPO_IDCERDA+" INTEGER, "+CAMPO_NOMBRECERDA+" TEXT, "+CAMPO_FECHAMONTA+" TEXT, " +
            ""+CAMPO_PRIMERCELO+" TXT, "+CAMPO_PESOMONTA+" TEXT, "+CAMPO_IDPAJILLA+" TEXT, "+CAMPO_NOMBREVERRACO+" TXT, "+CAMPO_ESTADO+" TEXT)";

    public static final String CREAR_TABLA_PAJILLAS="CREATE TABLE "+TABLA_PAJILLAS+" ("+CAMPO_NUMPAJILLA+" TEXT, "+CAMPO_NOMVERRACO+" TEXT, "+CAMPO_NOMRAZA+" TEXT, " +
            ""+CAMPO_VENCIMIENTO+" TXT, "+CAMPO_PROVEEDOR+" TEXT, "+CAMPO_OBSERVACIONES+" TEXT)";

    public static final String CREAR_TABLA_VERRACOS="CREATE TABLE "+TABLA_VERRACOS+" ("+CAMPO_IDVERRACO+" INTEGER, "+CAMPO_NAMEVERRACO+" TEXT, "+CAMPO_NAMERAZA+" TEXT, " +
            ""+CAMPO_NACIMIENTOV+" TXT, "+CAMPO_PESOVERRACO+" TEXT, "+CAMPO_OBSERVACIONESV+" TEXT)";

}
