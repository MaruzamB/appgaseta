package com.maruzamjunior.appgaseta.controller;

import android.content.SharedPreferences;

import com.maruzamjunior.appgaseta.model.Combustivel;
import com.maruzamjunior.appgaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String  NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity){
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences  = preferences.edit();

    }

    public void salvar(Combustivel combustivel){
        dadosPreferences.putString
                ("combustivel", combustivel.getNomeCombustivel());
        dadosPreferences.putFloat
                ("precoDoCombustivel", (float) combustivel.getPrecoCombustivel());
        dadosPreferences.putString
                ("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();
    }
    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
