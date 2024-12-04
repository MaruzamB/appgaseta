package com.maruzamjunior.appgaseta.controller;

import com.maruzamjunior.appgaseta.model.Curso;

import java.util.ArrayList;
import java.util.List;



public class CursoController {

    private List listCursos;

    public List getListaCursos(){
        listCursos = new ArrayList <Curso>();
        listCursos.add(new Curso("JAVA"));
        listCursos.add(new Curso("PYTHON"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("C"));
        listCursos.add(new Curso("KOTLIN"));

        return listCursos;
    }
    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size();i++){
            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }
        return dados;

    }
}
