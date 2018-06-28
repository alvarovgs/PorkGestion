package com.example.a201495_2.porkgestion.utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String TABLA_RAZAS="newrazas";
    public static final String TABLA_VENTA="venta";
    public static final String TABLA_PRENEZ="prenez";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_IDNUEVARAZA="idnuevaraza";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_FECHANACE="fechanace";
    public static final String CAMPO_PESONACE="pesonace";
    public static final String CAMPO_SEXO="sexo";
    public static final String CAMPO_RAZA="raza";
    public static final String CAMPO_NOMBREMADRE="nombremadre";
    public static final String CAMPO_NOMBREPADRE="nombrepadre";
    public static final String CAMPO_NUEVARAZA="nuevaraza";
    public static final String CAMPO_IDANIMALVENTA="idanimalventa";
    public static final String CAMPO_NOMBREVENTA="nombreventa";
    public static final String CAMPO_FECHAVENTA="fechaventa";
    public static final String CAMPO_PESOVENTA="pesoventa";
    public static final String CAMPO_PRECIOVENTA="precioventa";
    public static final String CAMPO_IDANIMONTA="idanimonta";
    public static final String CAMPO_NOMBREMONTA="nombremonta";
    public static final String CAMPO_EDADMONTA="edadmonta";
    public static final String CAMPO_PESOMONTA="pesomonta";
    public static final String CAMPO_FECHA1CELO="fecha1celo";
    public static final String CAMPO_FECHA2CELO="fecha2celo";
    public static final String CAMPO_TIPOPRENEZ="tipoprenez";
    public static final String CAMPO_NOMVERRACO="nomverraco";
    public static final String CAMPO_NUMPAJILLA="numpajilla";
    public static final String CAMPO_FECHAECO="fechaeco";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_FECHANACE+" TEXT, "+CAMPO_PESONACE+" INTEGER, "+CAMPO_SEXO+" "+
            "TEXT, "+CAMPO_RAZA+" TEXT, "+CAMPO_NOMBREMADRE+" TEXT, "+CAMPO_NOMBREPADRE+" TEXT)";

    public static final String CREAR_TABLA_RAZAS="CREATE TABLE " +
            ""+TABLA_RAZAS+"("+CAMPO_IDNUEVARAZA+" INTEGER,"+CAMPO_NUEVARAZA+" TEXT)";

    public static final String CREAR_TABLA_VENTA="CREATE TABLE " +
            ""+TABLA_VENTA+" ("+CAMPO_IDANIMALVENTA+" INTEGER, "+CAMPO_NOMBREVENTA+" TEXT, "+CAMPO_FECHAVENTA+" "+
            "TEXT, "+CAMPO_PESOVENTA+" INTEGER, "+CAMPO_PRECIOVENTA+" INTEGER)";

    public static final String CREAR_TABLA_PRENEZ="CREATE TABLE " +
            ""+TABLA_PRENEZ+"("+CAMPO_IDANIMONTA+" INTEGER, "+CAMPO_NOMBREMONTA+" TEXT, "+CAMPO_EDADMONTA+" INTEGER, "+CAMPO_PESOMONTA+" INTEGER, "+CAMPO_FECHA1CELO+" " +
            "TEXT, "+CAMPO_FECHA2CELO+" TEXT, "+CAMPO_TIPOPRENEZ+" TEXT, "+CAMPO_NOMVERRACO+" TEXT, "+CAMPO_NUMPAJILLA+"" +
            "INTEGER, "+CAMPO_FECHAECO+" TEXT)";


    public static final String TABLA_PAJILLA="pajilla";
    public static final String CAMPO_IDPAJILLA="idpajilla";
    public static final String CAMPO_FECHACOMPRAPAJILLA="fechacomprapajilla";
    public static final String CAMPO_RAZAPAJILLA="razapajilla";
    public static final String CAMPO_NOMPROVEPAJILLA="nomprovepajilla";
    public static final String CAMPO_OBSEPAJILLA="obserpajilla";

    public static final String CREAR_TABLA_PAJILLA="CREATE TABLE"+
            ""+TABLA_PAJILLA+"("+CAMPO_IDPAJILLA+" INTEGER, "+CAMPO_FECHACOMPRAPAJILLA+" TEXT, "+CAMPO_RAZAPAJILLA+" " +
            "TEXT, "+CAMPO_NOMPROVEPAJILLA+" TEXT, "+CAMPO_OBSEPAJILLA+" TEXT)";
}
