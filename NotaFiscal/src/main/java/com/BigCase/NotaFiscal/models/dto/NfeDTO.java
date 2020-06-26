package com.BigCase.NotaFiscal.models.dto;

import java.math.BigDecimal;

public class NfeDTO {
    private Integer id;
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
