package com.BigCase.NotaFiscal.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "NotaFiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min=11, max=14, message = "Tamanho invalido do CPF/CNPJ")
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

    public NotaFiscal() {
    }

    public NotaFiscal(Integer id, @Size(min = 11, max = 14, message = "Tamanho invalido do CPF/CNPJ") String identidade, String tpPessoa, BigDecimal valor, String status, BigDecimal valorInicial, BigDecimal valorIRRF, BigDecimal valorCSLL, BigDecimal valorCofins, BigDecimal valorFinal) {
        this.id = id;
        this.identidade = identidade;
        this.tpPessoa = tpPessoa;
        this.valor = valor;
        this.status = status;
        this.valorInicial = valorInicial;
        this.valorIRRF = valorIRRF;
        this.valorCSLL = valorCSLL;
        this.valorCofins = valorCofins;
        this.valorFinal = valorFinal;
    }
}
