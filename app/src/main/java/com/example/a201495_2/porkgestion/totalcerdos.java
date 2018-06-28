package com.example.a201495_2.porkgestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import com.example.a201495_2.porkgestion.bo_clases.Cerdo;


public class totalcerdos extends AppCompatActivity {

    ListView listViewCerdos;
    ArrayList<String> listaInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalcerdos);


        listViewCerdos= findViewById(R.id.listViewCerdos);
        Cerdo lista = new Cerdo(getApplicationContext());
        listaInformacion = lista.consultaCerdo();
       // consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaInformacion);
        listViewCerdos.setAdapter(adaptador);

        /*listViewCerdos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="id: "+listaUsuarios.get(pos).getId()+"\n";
                informacion+="Nombre: "+listaUsuarios.get(pos).getNombre()+"\n";


                //Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();

//                Usuario user=listaUsuarios.get(pos);
//
//                Intent intent=new Intent(ConsultarListaListViewActivity.this,DetalleUsuarioActivity.class);
//
//                Bundle bundle=new Bundle();
//                bundle.putSerializable("usuario",user);
//
//                intent.putExtras(bundle);
//                startActivity(intent);

            }
        });*/
    }

  /*  private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            listaUsuarios.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size();i++){
            listaInformacion.add(listaUsuarios.get(i).getId()+" - "
                    +listaUsuarios.get(i).getNombre());
        }

    }*/
}
