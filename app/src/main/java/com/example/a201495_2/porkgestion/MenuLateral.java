package com.example.a201495_2.porkgestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuLateral extends AppCompatActivity {

    private ActionBar actionBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);
        initToolbar();
        initNavigationMenu();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Menú PorkGestion");
    }

    private void initNavigationMenu() {
        NavigationView nav_view = findViewById(R.id.nav_view);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                Toast.makeText(getApplicationContext(),  " Seleccionado: " + item.getTitle() , Toast.LENGTH_SHORT).show();

                if(item.getTitle().toString().equals("Cerdo")) {
                    Intent miIntent=new Intent(MenuLateral.this,cerdo.class);
                    startActivity(miIntent);
                    return false;
                }

                if(item.getTitle().toString().equals("Ventas")) {
                    Intent miIntent=new Intent(MenuLateral.this,ventas.class);
                    startActivity(miIntent);
                    return false;
                }

                if(item.getTitle().toString().equals("Reproduccion")) {
                    Intent miIntent=new Intent(MenuLateral.this,reproduccion.class);
                    startActivity(miIntent);
                    return false;
                }

                if(item.getTitle().toString().equals("Cerrar")) {
                    Intent miIntent = new Intent(MenuLateral.this,MainActivity.class);
                    startActivity(miIntent);
                    System.exit(0);
                }
                actionBar.setTitle(item.getTitle());
                drawer.closeDrawers();
                return true;
            }

//            metodo para pasea a otra activity con un boton
//            public void onClick(View view){
//                Intent miIntent=new Intent(MenuLateral.this,cerdo.class);
//                startActivity(miIntent);
//            }

        });

        // open drawer at start
        drawer.openDrawer(GravityCompat.START);
    }




}
