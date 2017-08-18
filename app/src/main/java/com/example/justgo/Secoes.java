package com.example.justgo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larys on 17/08/2017.
 */

public class Secoes extends FragmentPagerAdapter {
private final List<Fragment> listaDeFragmentos = new ArrayList<>();
private final List<String>  listaDeTitulos = new ArrayList<>();

    public void adicionaFragmento(Fragment fragmento, String titulo)
    {
        listaDeFragmentos.add(fragmento);
        listaDeTitulos.add(titulo);
    }

    public Secoes(FragmentManager fm)
    {
        super(fm);
    }

    public CharSequence getTituloPagina(int posicao)
    {
        return listaDeTitulos.get(posicao);
    }

    @Override
    public Fragment getItem(int posicao)
    {
        return listaDeFragmentos.get(posicao);
    }

    @Override
    public int getCount(){
        return listaDeFragmentos.size();
    }
}
