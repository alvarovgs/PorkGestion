package com.example.a201495_2.porkgestion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
<<<<<<< HEAD
=======

import com.example.a201495_2.porkgestion.bo_clases.Cerdo;
>>>>>>> origin/fabian
import com.example.a201495_2.porkgestion.entidades.Usuario;
import com.example.a201495_2.porkgestion.utilidades.Utilidades;



public class totalcerdos extends AppCompatActivity {

    ListView listViewCerdos;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

<<<<<<< HEAD
    ConexionSQLiteHelper conn;

=======
>>>>>>> origin/fabian
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalcerdos);

<<<<<<< HEAD
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_porcinos",null,1);

        listViewCerdos= (ListView) findViewById(R.id.listViewCerdos);

        consultarListaPersonas();
=======

        listViewCerdos= (ListView) findViewById(R.id.listViewCerdos);
        Cerdo lista = new Cerdo(getApplicationContext());
        listaInformacion = lista.consultaCerdo();
       // consultarListaPersonas();
>>>>>>> origin/fabian

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaInformacion);
        listViewCerdos.setAdapter(adaptador);

<<<<<<< HEAD
        listViewCerdos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
=======
        /*listViewCerdos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
>>>>>>> origin/fabian
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="id: "+listaUsuarios.get(pos).getId()+"\n";
                informacion+="Nombre: "+listaUsuarios.get(pos).getNombre()+"\n";


<<<<<<< HEAD
                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();
=======
                //Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();
>>>>>>> origin/fabian

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
<<<<<<< HEAD
        });
    }

    private void consultarListaPersonas() {
=======
        });*/
    }

  /*  private void consultarListaPersonas() {
>>>>>>> origin/fabian
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

<<<<<<< HEAD
    }
=======
    }*/
>>>>>>> origin/fabian
}
