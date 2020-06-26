package com.BigCase.NotaFiscal.services.producers;

import com.BigCase.NotaFiscal.models.NotaFiscal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CalculaImpostosProducer {
    @Autowired
    private KafkaTemplate<String, NotaFiscal> producer;

    public void enviarAoKafka(NotaFiscal notaFiscal) {

        producer.send("spec2-daniel-torquato-1", notaFiscal);

    }
}
