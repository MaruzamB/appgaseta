package com.maruzamjunior.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.maruzamjunior.appgaseta.model.Pessoa;
import com.maruzamjunior.appgaseta.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listvip";
    SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

    }

    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciada: ");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("Sobrenome", pessoa.getSobreNome());
        listaVip.putString("CursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("TelefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("Sobrenome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado", "NA"));
        pessoa.setTelefoneContato(preferences.getString("TelefoneContato", "NA"));
        return pessoa;
    }

}
