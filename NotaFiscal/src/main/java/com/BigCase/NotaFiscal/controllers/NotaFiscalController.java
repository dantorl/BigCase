package com.BigCase.NotaFiscal.controllers;

import com.BigCase.NotaFiscal.models.dto.RequestDTO;
import com.BigCase.NotaFiscal.models.dto.RespostaConsultaNfeDTO;
import com.BigCase.NotaFiscal.models.dto.RespostaRequestDTO;
import com.BigCase.NotaFiscal.services.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotaFiscalController {
    @Autowired
    NotaFiscalService notaFiscalService;

    @PostMapping("/nfe/emitir")
    public RespostaRequestDTO solicitarNFE(@RequestBody RequestDTO requestDTO){

        return notaFiscalService.solicitarNFE(requestDTO);
    }

    @GetMapping("/nfe/consultar/{cpf_cnpj}")
    public List<RespostaConsultaNfeDTO> solicitarNFE(@PathVariable String cpf_cnpj){

        return notaFiscalService.consultarNFE(cpf_cnpj);
    }
}
