package com.example.a201495_2.porkgestion.utils;

import android.content.Context;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.a201495_2.porkgestion.bo_clases.Raza;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class clsUtilidades {

    public  boolean bValidaString(String strString, int iTipo){
        switch (iTipo){
            case 1://cadena vacía
                return !strString.trim().equals("");
            case 2: //cadena numerica
                return validarNumerico(strString);
            case 3: //email
                Pattern emailPattern = Patterns.EMAIL_ADDRESS;
                return emailPattern.matcher(strString).matches();
            case 4: //fecha
                return validarFecha(strString);
        }
        return true;
    }
    private static boolean validarNumerico(String strString){
        try {
            Integer.parseInt(strString);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    private static boolean validarFecha(String strString) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(strString);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public int obtenerPosicionItem(Spinner spinner, String strItem) {
        int posicion = 0;
        String valor;
        for (int i = 0; i < spinner.getCount(); i++) {
            SpinData sp_item = (SpinData)spinner.getItemAtPosition(i);
            if (sp_item.getValor().equalsIgnoreCase(strItem)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public ArrayList listItemSpinner(Context appContext, int idObject){
        ArrayList listObject = new ArrayList();
        switch (idObject){
            case 1: //Raza
                ArrayList listRazaSql =new ArrayList<Raza>();
                Raza objRaza = new Raza(appContext);
                listRazaSql = objRaza.getAllRaza();
                ArrayList listRaza=new ArrayList<>();
                for(int i = 0; i < listRazaSql.size() ; i++){
                    Raza objItemRaza = (Raza)listRazaSql.get(i);
                    listRaza.add(objItemRaza.getStrRaza());
                }
                listObject=listRaza;
            break;
        }
        return listObject;
    }

}
