package com.BigCase.NotaFiscal.services.consumers;

import com.BigCase.NotaFiscal.models.NotaFiscal;
import com.BigCase.NotaFiscal.services.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AtualizarNotaFiscalConsumer {
    @Autowired
    NotaFiscalService notaFiscalService;

    @KafkaListener(topics = "spec2-daniel-torquato-3", groupId = "batman")
    public void receber(@Payload NotaFiscal notaFiscal) throws IOException {
        System.out.println("Recebi atualização do CNPJ " + notaFiscal.getIdentidade()+ " com Valor " + notaFiscal.getValor());

        notaFiscalService.atualizarNfe(notaFiscal);

    }
}
