package com.BigCase.NotaFiscal.models.dto;

import java.math.BigDecimal;

public class RequestDTO {
    private String identidade;
    private BigDecimal valor;

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public RequestDTO() {
    }

    public RequestDTO(String identidade, BigDecimal valor) {
        this.identidade = identidade;
        this.valor = valor;
    }
}
