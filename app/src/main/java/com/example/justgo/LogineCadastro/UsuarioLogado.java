package com.example.justgo.LogineCadastro;

/**
 * Created by Keven on 8/13/2017.
 */

public class UsuarioLogado {
    public static String usuariocod;

    public static void setUsuario(String email){
        usuariocod = email;
    }
    public static String getUsuario(){
        return usuariocod;
    }
}
