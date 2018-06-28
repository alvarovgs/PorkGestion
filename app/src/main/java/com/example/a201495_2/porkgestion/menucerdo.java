package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menucerdo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menucerdo);
    }

    public void onClick(View view){
        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btn_back:
                miIntent = new Intent(menucerdo.this, MenuLateral.class);
                break;

            case R.id.btn_newcerdo:
                miIntent = new Intent(menucerdo.this, cerdo.class);
                break;

            case R.id.btn_cacerdo:
                miIntent = new Intent(menucerdo.this, consultacerdo.class);
                break;

            case R.id.btn_sanicerdo:
                miIntent = new Intent(menucerdo.this, MenuLateral.class);
                break;
        }
        startActivity(miIntent);
    }

}
