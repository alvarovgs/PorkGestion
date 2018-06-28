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

import com.example.a201495_2.porkgestion.bo_clases.Sanidad;
import com.facebook.stetho.Stetho;


public class MenuLateral extends AppCompatActivity {
    private ActionBar actionBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);
        Stetho.initializeWithDefaults(getApplicationContext());
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
                Toast.makeText(getApplicationContext(), " Seleccionado: " + item.getTitle(), Toast.LENGTH_SHORT).show();

                if (item.getTitle().toString().equals("Cerdo")) {
                    Intent miIntent = new Intent(MenuLateral.this, menucerdo.class);
                    startActivity(miIntent);
                    return false;
                }

                else if (item.getTitle().toString().equals("Raza")) {
                    Intent miIntent = new Intent(MenuLateral.this, RazaActivity.class);
                    startActivity(miIntent);
                    return false;
                }

                else if (item.getTitle().toString().equals("Reproducción")) {
                    Intent miIntent = new Intent(MenuLateral.this, prenez.class);
                    startActivity(miIntent);
                    return false;
                }

                else if(item.getTitle().toString().equals("Reproducción")) {
                    Intent miIntent = new Intent(MenuLateral.this, DashReproductivo.class);
                    startActivity(miIntent);
                    return false;
                }

                else if(item.getTitle().toString().equals("Sanidad")) {
                    Intent miIntent = new Intent(MenuLateral.this, SanidadActivity.class);
                    startActivity(miIntent);
                    actionBar.setTitle("Gestión Sanidad");
                    return false;
                }

                else if (item.getTitle().toString().equals("Ventas")) {
                    Intent miIntent = new Intent(MenuLateral.this, ventas.class);
                    startActivity(miIntent);
                    return false;
                }
                else if (item.getTitle().toString().equals("Parto")) {
                    Intent miIntent = new Intent(MenuLateral.this, PartoActivity.class);
                    startActivity(miIntent);
                    return false;
                }

                else if (item.getTitle().toString().equals("Reportes")) {
                    Intent miIntent = new Intent(MenuLateral.this, reportes.class);
                    startActivity(miIntent);
                    return false;
                }

                else if (item.getTitle().toString().equals("Informacion")) {
                    Intent miIntent = new Intent(MenuLateral.this, MainInformacion.class);
                    startActivity(miIntent);
                    return false;
                }

                else if (item.getTitle().toString().equals("Edit. Usuario")) {
                    Intent miIntent = new Intent(MenuLateral.this, MainEditusuario.class);
                    startActivity(miIntent);
                    return false;
                }

                else if (item.getTitle().toString().equals("Cerrar")) {
                    finish();
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                drawer.closeDrawers();
                return true;
            }
        });

        drawer.openDrawer(GravityCompat.START);

    }

}
