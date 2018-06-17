package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class pajilla_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pajilla);}

        public void onClick(View view){
            Intent miIntent=null;

            switch (view.getId()) {
                case R.id.btn_regresar:
                    miIntent = new Intent(pajilla_Activity.this, reproduccion.class);
                    break;
            }
            startActivity(miIntent);
        }
}
