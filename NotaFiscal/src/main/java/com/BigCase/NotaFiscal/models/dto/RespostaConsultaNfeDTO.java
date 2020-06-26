package com.BigCase.NotaFiscal.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class RespostaConsultaNfeDTO {
    private String identidade;
    private BigDecimal valor;
    private String status;

    @JsonProperty("nfe")
    private NfeDTO nfeDTO;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NfeDTO getNfeDTO() {
        return nfeDTO;
    }

    public void setNfeDTO(NfeDTO nfeDTO) {
        this.nfeDTO = nfeDTO;
    }
}
