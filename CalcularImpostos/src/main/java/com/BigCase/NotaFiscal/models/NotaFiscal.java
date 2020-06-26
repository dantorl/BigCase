package com.BigCase.NotaFiscal.models;

import java.math.BigDecimal;

public class NotaFiscal {
    private Integer id;
    private String identidade;
    private String tpPessoa;
    private BigDecimal valor;
    private String status;
    private BigDecimal valorInicial;
    private BigDecimal valorIRRF;
    private BigDecimal valorCSLL;
    private BigDecimal valorCofins;
    private BigDecimal valorFinal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getTpPessoa() {
        return tpPessoa;
    }

    public void setTpPessoa(String tpPessoa) {
        this.tpPessoa = tpPessoa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorIRRF() {
        return valorIRRF;
    }

    public void setValorIRRF(BigDecimal valorIRRF) {
        this.valorIRRF = valorIRRF;
    }

    public BigDecimal getValorCSLL() {
        return valorCSLL;
    }

    public void setValorCSLL(BigDecimal valorCSLL) {
        this.valorCSLL = valorCSLL;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }
}
