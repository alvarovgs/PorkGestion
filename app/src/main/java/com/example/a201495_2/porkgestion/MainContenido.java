package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainContenido extends AppCompatActivity {
    TextView tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido_inicio);
        tv_info=findViewById(R.id.tv_info);

        tv_info.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent IntentReg = new Intent (MainContenido.this, MainInformacion.class);
            startActivity(IntentReg);
        }
    });
    }
}
