package com.BigCase.CalcularImpostos.models;

public class EmpresaDTO {
    private String cnpj;
    private String nome;
    private Double capital_social;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCapital_social() {
        return capital_social;
    }

    public void setCapital_social(Double capital_social) {
        this.capital_social = capital_social;
    }
}
