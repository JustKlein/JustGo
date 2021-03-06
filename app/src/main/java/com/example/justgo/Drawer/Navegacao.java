package com.example.justgo.Drawer;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.justgo.CadastroRota.NovaRota;
import com.example.justgo.Mapa.HomePageMaps;
import com.example.justgo.MapsHome;
import com.example.justgo.R;

public class Navegacao extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegacao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //   setContentView(R.layout.activity_sobre);
            //    return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_experiencia) {
            // abrir experiencias
            Intent exp = new Intent(this, Experiencias.class);
            startActivity(exp);
        } else if (id == R.id.nav_pesquisar) {
            // abrir activity para pesquisa
        } else if (id == R.id.nav_sugestoes) {
            // abrir as sugestões
        } else if (id == R.id.nav_config) {
            //abrir as configuracoes
            Intent config = new Intent(this, Configuracoes.class);
            startActivity(config);

            //setContentView(R.layout.activity_configuracoes);
            return true;
        } else if (id == R.id.nav_sair) {
            // deslogar
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClickHomePage(View v) {
        Intent homepage =  new Intent(this, MapsHome.class);
        startActivity(homepage);


    }



    public void onClickAddRota(View v) {
        Intent Address = new Intent(this, NovaRota.class);
        startActivity(Address);
    }

    public void onClickNavegacao(View v) {
        Intent navegacao = new Intent(this, Navegacao.class);
        startActivity(navegacao);
    }

}