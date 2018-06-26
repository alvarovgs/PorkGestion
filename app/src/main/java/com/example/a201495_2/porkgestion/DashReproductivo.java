package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class DashReproductivo extends AppCompatActivity {
//ImageButton ibparto, ibmonta, ibpajilla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashreproductivo);
        ImageButton ibparto =(ImageButton) findViewById(R.id.ib_parto);
        ibparto.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ibparto =new Intent(DashReproductivo.this, Parto_Activity.class);
            startActivity(ibparto);
            Toast mostrar  = Toast.makeText(DashReproductivo.this, "Registo de Partos",Toast.LENGTH_LONG);
            mostrar.show();
        }
        });
        ImageButton ibmonta=(ImageButton) findViewById(R.id.ib_monta);
        ibmonta.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Intent ibmonta = new Intent(DashReproductivo.this, monta_Activity.class);
            startActivity(ibmonta);
            Toast mostrar = Toast.makeText(DashReproductivo.this, "Regsito de Montas", Toast.LENGTH_LONG);
            mostrar.show();        }
         });

        ImageButton ibpajilla =(ImageButton)findViewById(R.id.ib_pajilla);
        ibpajilla.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent ibpajilla =new Intent(DashReproductivo.this, PajillaActivity.class);
               startActivity(ibpajilla);
               Toast mostarar =Toast.makeText(DashReproductivo.this, "Regstro de Pajillas", Toast.LENGTH_LONG);
               mostarar.show();

           }
       });

    }
}