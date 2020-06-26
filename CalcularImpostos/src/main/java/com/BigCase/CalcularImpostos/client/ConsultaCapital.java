package com.BigCase.CalcularImpostos.client;

import com.BigCase.CalcularImpostos.client.ConsultaCapitalConfiguration;
import com.BigCase.CalcularImpostos.models.EmpresaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consultacapital", url = "https://www.receitaws.com.br/v1/cnpj", configuration = ConsultaCapitalConfiguration.class)
public interface ConsultaCapital {
    @GetMapping("/{cnpj}")
    EmpresaDTO getByCnpj(@PathVariable String cnpj);
}
