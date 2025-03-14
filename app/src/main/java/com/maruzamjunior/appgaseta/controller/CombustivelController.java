package com.maruzamjunior.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import com.maruzamjunior.appgaseta.database.GasetaDB;
import com.maruzamjunior.appgaseta.model.Combustivel;
import com.maruzamjunior.appgaseta.view.GasEtaActivity;

import java.util.List;

public class CombustivelController extends GasetaDB {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity) {
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel) {

        ContentValues dados = new ContentValues();

        dadosPreferences.putString
                ("combustivel", combustivel.getNomeCombustivel());
        dadosPreferences.putFloat
                ("precoDoCombustivel", (float) combustivel.getPrecoCombustivel());
        dadosPreferences.putString
                ("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());


        salvarObjeto("Combustivel", dados);
    }


    public List<Combustivel> getListaDeDados() {
        return listarDados();
    }

    public void alterar(Combustivel combustivel) {

        ContentValues dados = new ContentValues();

        dados.put("id", combustivel.getId());
        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        alterarObjeto("Combustivel", dados);

    }

    public void deletar(int id) {
        deletarObjeto("Combustivel", id);
    }

    public void limpar() {
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
