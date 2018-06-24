package com.example.a201495_2.porkgestion;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import static java.util.Calendar.YEAR;

public class fpp extends AppCompatActivity implements View.OnClickListener {
    Button bfecha;
    EditText efecha;
    EditText efpp;
    private  int dia,mes,ano;
    public EditText partes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpp);

        bfecha=(Button)findViewById(R.id.bfecha);
        efecha=(EditText)findViewById(R.id.efecha);
        efpp=(EditText)findViewById(R.id.efpp);
        bfecha.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==bfecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    efecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
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


            datePickerDialog.show();
        }

    }
    public void Regresar(View view) {
        Intent miIntent=null;
        miIntent = new Intent(fpp.this, Partolact.class);
        startActivity(miIntent);
    }
}
