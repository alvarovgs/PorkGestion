package com.example.a201495_2.porkgestion;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.DatePicker;

import java.util.Calendar;

import static java.util.Calendar.YEAR;

public class fpp extends AppCompatActivity implements View.OnClickListener {
    Button bfecha;
    EditText efecha;
    EditText efpp;
    private  int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpp);

        efecha= findViewById(R.id.efecha);
        efpp= findViewById(R.id.efpp);
        efecha.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==efecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    efecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    int fpp;
                    fpp=year;
                    fpp=(monthOfYear-1)+(fpp*12);
                    fpp=(dayOfMonth-1)+(fpp*31);
                    fpp=fpp+114;
                    dayOfMonth=(short)(fpp%31+1);fpp/=31;
                    monthOfYear = (short)(fpp % 12 + 1); fpp /= 12;
                    year= (short)(fpp);
                    efpp.setText("La fecha probable de parto de la cerda es "+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                   }
            }
                    , dia, mes, ano);



            c.add(Calendar.MONTH, -3);
            dpd.getDatePicker().setMinDate(c.getTimeInMillis());

            dpd.show();
        }



    }
    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(fpp.this, reproduccion.class);
        startActivity(miIntent);
    }
}
