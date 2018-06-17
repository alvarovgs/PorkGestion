package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class fpp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpp);
    }

    public void onClick(View view){
        Intent miIntent=new Intent(fpp.this,MenuLateral.class);
        startActivity(miIntent);
    }
}