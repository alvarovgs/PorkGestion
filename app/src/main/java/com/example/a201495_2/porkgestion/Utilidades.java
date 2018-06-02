package com.example.a201495_2.porkgestion;

import android.util.Patterns;
import android.widget.Switch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Utilidades {

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

}
