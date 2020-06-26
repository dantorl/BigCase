package com.BigCase.CalcularImpostos.Producer;

import com.BigCase.NotaFiscal.models.NotaFiscal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AtualizarNotaFiscalProducer {

    @Autowired
    private KafkaTemplate<String, NotaFiscal> producer;

    public void enviarAoKafka(NotaFiscal notaFiscal) {

        producer.send("spec2-daniel-torquato-3", notaFiscal);

        //System.out.println("Atualizei o cadastro da empresa" + empresa.getNome() + " CNPJ " + empresa.getCnpj() + " Status " + empresa.getStatus());
    }

}
