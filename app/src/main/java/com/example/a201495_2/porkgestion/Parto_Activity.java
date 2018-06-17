package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Parto_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parto_);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_regresar3:
                miIntent = new Intent(Parto_Activity.this, Partolact.class);
                break;
        }
        startActivity(miIntent);
    }
}
