package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class reporteverracos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporteverracos);
    }

    public void onClick(View view){
        Intent miIntent=new Intent(reporteverracos.this,reportes.class);
        startActivity(miIntent);
    }
}
