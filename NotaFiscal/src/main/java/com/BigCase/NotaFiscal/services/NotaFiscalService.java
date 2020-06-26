package com.BigCase.NotaFiscal.services;

import com.BigCase.NotaFiscal.models.NotaFiscal;
import com.BigCase.NotaFiscal.models.dto.NfeDTO;
import com.BigCase.NotaFiscal.models.dto.RequestDTO;
import com.BigCase.NotaFiscal.models.dto.RespostaConsultaNfeDTO;
import com.BigCase.NotaFiscal.models.dto.RespostaRequestDTO;
import com.BigCase.NotaFiscal.repositories.NotaFiscalRepository;
import com.BigCase.NotaFiscal.services.producers.CalculaImpostosProducer;
import com.BigCase.NotaFiscal.services.producers.GeraLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaFiscalService {
    @Autowired
    GeraLogProducer geraLogProducer;

    @Autowired
    CalculaImpostosProducer calculaImpostosProducer;

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    public RespostaRequestDTO solicitarNFE(RequestDTO requestDTO) {

        NotaFiscal notaFiscal = new NotaFiscal();

        notaFiscal.setIdentidade(requestDTO.getIdentidade());
        notaFiscal.setValor(requestDTO.getValor());
        notaFiscal.setStatus("pending");

        if(notaFiscal.getIdentidade().length() > 11){
            notaFiscal.setTpPessoa("PJ");
        }else {
            notaFiscal.setTpPessoa("PF");
        }

        NotaFiscal notaFiscalObj = notaFiscalRepository.save(notaFiscal);

        calculaImpostosProducer.enviarAoKafka(notaFiscalObj);

        geraLogProducer.geraLogSolicitacaoNFE(requestDTO);

        RespostaRequestDTO respostaRequestDTO = new RespostaRequestDTO();
        respostaRequestDTO.setStatus(notaFiscalObj.getStatus());

        return respostaRequestDTO;
    }

    public List<RespostaConsultaNfeDTO> consultarNFE(String cpf_cnpj) {
        List<NotaFiscal> listaNotas = notaFiscalRepository.findByIdentidade(cpf_cnpj);

        List<RespostaConsultaNfeDTO> listaRespostaConsulta = new ArrayList<>();

        for(NotaFiscal notaFiscal: listaNotas){
            RespostaConsultaNfeDTO respostaConsultaNfeDTO= new RespostaConsultaNfeDTO();
            NfeDTO nfeDTO = new NfeDTO();
            respostaConsultaNfeDTO.setIdentidade(notaFiscal.getIdentidade());
            respostaConsultaNfeDTO.setValor(notaFiscal.getValor());
            respostaConsultaNfeDTO.setStatus(notaFiscal.getStatus());

            if(respostaConsultaNfeDTO.getStatus().equals("pending")){
                respostaConsultaNfeDTO.setNfeDTO(null);
                System.out.println("1 " + respostaConsultaNfeDTO.getStatus());
            }else{
                System.out.println("2 " + respostaConsultaNfeDTO.getStatus());
                nfeDTO.setId(notaFiscal.getId());
                nfeDTO.setValorInicial(notaFiscal.getValorInicial());
                nfeDTO.setValorCofins(notaFiscal.getValorCofins());
                nfeDTO.setValorCSLL(notaFiscal.getValorCSLL());
                nfeDTO.setValorFinal(notaFiscal.getValorFinal());
                nfeDTO.setValorIRRF(notaFiscal.getValorIRRF());
                respostaConsultaNfeDTO.setNfeDTO(nfeDTO);
            }
            listaRespostaConsulta.add(respostaConsultaNfeDTO);
        }

        geraLogProducer.geraLogConsultaNFE(cpf_cnpj);

        return listaRespostaConsulta;
    }

    public void atualizarNfe(NotaFiscal notaFiscal) {

        notaFiscalRepository.save(notaFiscal);
    }
}
