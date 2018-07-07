package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a201495_2.porkgestion.bo_clases.Cerdo;
import com.example.a201495_2.porkgestion.bo_clases.RptProduccionGeneral;
import com.example.a201495_2.porkgestion.utils.Tools;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class ReporteProduccionActivity extends AppCompatActivity {
    private String strFechaI, strFechaF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_produccion);
        limpiarCampos();
        findViewById(R.id.bt_Reporte).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strFechaI=((TextView) findViewById(R.id.et_FechaInicial)).getText().toString();
                strFechaF=((TextView) findViewById(R.id.et_FechaFinal)).getText().toString();
                if(strFechaI.equals("")||strFechaF.equals("")){
                    Toast.makeText(getApplicationContext(), "Debe seleccionar las fechas del reporte", Toast.LENGTH_SHORT).show();
                }
                else {
                    limpiarCampos();
                    consultarCerdos();
                    consultarVentas(strFechaI, strFechaF);
                    consultarPartos(strFechaI, strFechaF);
                }
            }
        });

        findViewById(R.id.bt_Regresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(ReporteProduccionActivity.this, MenuLateral.class);
                startActivity(miIntent);
            }
        });

        ((TextView) findViewById(R.id.et_FechaInicial)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDatePickerLight((TextView) view);
            }
        });
        ((TextView) findViewById(R.id.et_FechaFinal)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDatePickerLight((TextView) view);
            }
        });
    }

    private void dialogDatePickerLight(final TextView tv) {
        Calendar cur_calender = Calendar.getInstance();
        DatePickerDialog datePicker = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        long date_ship_millis = calendar.getTimeInMillis();
                        tv.setText(Tools.getFormattedDateSimple(date_ship_millis));
                    }
                },
                cur_calender.get(Calendar.YEAR),
                cur_calender.get(Calendar.MONTH),
                cur_calender.get(Calendar.DAY_OF_MONTH)
        );
        //set dark light
        datePicker.setThemeDark(false);
        datePicker.setAccentColor(getResources().getColor(R.color.colorPrimary));
        datePicker.show(getFragmentManager(), "Datepickerdialog");
    }

    private void limpiarCampos(){
        ((TextView) (findViewById(R.id.lblTotal))).setText("0");
        ((TextView) (findViewById(R.id.lblMachos))).setText("0");
        ((TextView) (findViewById(R.id.lblHembras))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalVentas))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalVentasHembras))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalVentasMachos))).setText("0");
        ((TextView) (findViewById(R.id.lblPromedioPesoventa))).setText("0");
        ((TextView) (findViewById(R.id.lblValorTotalVentas))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalHembrasVivas))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalHembrasMuertas))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalMachosVivos))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalMachosMuertos))).setText("0");
        ((TextView) (findViewById(R.id.lblTotalpartos))).setText("0");
        ((TextView) (findViewById(R.id.lblIM))).setText("0");

    }

    private void consultarCerdos(){
        RptProduccionGeneral objRpt = new RptProduccionGeneral(getApplicationContext());
        objRpt = objRpt.getDataCerdo();
        ((TextView) (findViewById(R.id.lblTotal))).setText(String.valueOf(objRpt.getTotalCerdos()));
        ((TextView) (findViewById(R.id.lblMachos))).setText(String.valueOf(objRpt.getTotalMachos()));
        ((TextView) (findViewById(R.id.lblHembras))).setText(String.valueOf(objRpt.getTotalHembras()));

    }
    private void consultarVentas(String strFechaI, String strFechaF){
        RptProduccionGeneral objRpt = new RptProduccionGeneral(getApplicationContext());
        objRpt = objRpt.getRptVenta(strFechaI,strFechaF);
        ((TextView) (findViewById(R.id.lblTotalVentas))).setText(String.valueOf(objRpt.getTotalVentas()));
        ((TextView) (findViewById(R.id.lblTotalVentasHembras))).setText(String.valueOf(objRpt.getVentaHembras()));
        ((TextView) (findViewById(R.id.lblTotalVentasMachos))).setText(String.valueOf(objRpt.getVentaMachos()));
        ((TextView) (findViewById(R.id.lblPromedioPesoventa))).setText(objRpt.getStrPesoVenta());
        ((TextView) (findViewById(R.id.lblValorTotalVentas))).setText(objRpt.getStrTotalPrecio());
    }
    private void consultarPartos(String strFechaI, String strFechaF){
        RptProduccionGeneral objRpt = new RptProduccionGeneral(getApplicationContext());
        objRpt = objRpt.getRptParto(strFechaI,strFechaF);
        ((TextView) (findViewById(R.id.lblTotalHembrasVivas))).setText(String.valueOf(objRpt.getPartoHembrasV()));
        ((TextView) (findViewById(R.id.lblTotalHembrasMuertas))).setText(String.valueOf(objRpt.getPartoHembrasM()));
        ((TextView) (findViewById(R.id.lblTotalMachosVivos))).setText(String.valueOf(objRpt.getPartoMachosV()));
        ((TextView) (findViewById(R.id.lblTotalMachosMuertos))).setText(String.valueOf(objRpt.getPartoMachosM()));
        ((TextView) (findViewById(R.id.lblTotalpartos))).setText(String.valueOf(objRpt.getTotalParto()));
        float IM = ((objRpt.getPartoHembrasM()+objRpt.getPartoMachosM()) / objRpt.getTotalParto());
        ((TextView) (findViewById(R.id.lblIM))).setText(String.valueOf(IM));

    }

}
