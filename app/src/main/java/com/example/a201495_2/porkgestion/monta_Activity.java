package com.example.a201495_2.porkgestion;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class monta_Activity extends AppCompatActivity {

    private Spinner sptipomonta1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monta);

        sptipomonta1 = (Spinner) findViewById(R.id.sp_tipomonta);
        //decalaracion del vector unidimensional
        String[] opcmonta = {"Monta Directa", "Inseminación Artificial"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcmonta);
        sptipomonta1.setAdapter(adapter1);
    }
    // Creacción de método
    public void selecionmonta(View view){
            sptipomonta1.getSelectedItem().toString();


    }


}
