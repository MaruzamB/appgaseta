package com.maruzamjunior.appgaseta.util;

public class UtilGasEta {

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal){
            mensagemDeRetorno = "Abastecer  Com Etanol";
        }
        else {
            mensagemDeRetorno = "Abastecer Com Gasolina";
        }
        return mensagemDeRetorno;
    }
}
