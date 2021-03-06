package com.example.justgo.Drawer;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.justgo.R;

public class Experiencias extends AppCompatActivity {

    private static final String TAG = "Experencias";

    private Secoes secoes;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiencias);
        Log.d(TAG,"onCreate: Starting");

        secoes = new Secoes(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager)
    {
        Secoes adaptador = new Secoes(getSupportFragmentManager());
        adaptador.adicionaFragmento(new Experiencia1Fragment(), "Inserir");
        adaptador.adicionaFragmento(new Experiencia2Fragment(),"Pesquisar");
        adaptador.adicionaFragmento(new Experiencia3Fragment(),"Sugestões");
        viewPager.setAdapter(adaptador);
    }
}
