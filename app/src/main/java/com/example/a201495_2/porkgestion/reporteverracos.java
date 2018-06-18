package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.a201495_2.porkgestion.database.dataBaseOpenHelper;

public class reporteverracos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporteverracos);

        dataBaseOpenHelper miDB = new dataBaseOpenHelper(getApplicationContext());
        miDB.openDataBase();
        Cursor resultado;
        resultado = miDB.qweryDatabaseBySql("SELECT * from REPRODUCCION INNER JOIN CERDO ON CERDO.IDCERDO=REPRODUCCION.IDVERRACO INNER JOIN Raza ON RAZA.idRaza = Cerdo.IDRAZA ");
        if (resultado.moveToFirst()){


        }
    }

    public void onClick(View view){
        Intent miIntent=new Intent(reporteverracos.this,reportes.class);
        startActivity(miIntent);







    }
}
