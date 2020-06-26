package com.BigCase.NotaFiscal.models.dto;

public class RespostaRequestDTO {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RespostaRequestDTO() {
    }

    public RespostaRequestDTO(String status) {
        this.status = status;
    }
}
