package com.maruzamjunior.appgaseta.model;

public class Pessoa {

    private String primeiroNome;
    private String SobreNome;
    private String CursoDesejado;
    private String telefoneContato;

    public Pessoa() {
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return SobreNome;
    }

    public void setSobreNome(String sobreNome) {
        SobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return CursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        CursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", SobreNome='" + SobreNome + '\'' +
                ", CursoDesejado='" + CursoDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }
}
