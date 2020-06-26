package com.BigCase.GravarLog.Consumer;

import com.BigCase.NotaFiscal.models.RegistroLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class GravarLogConsumer {
    @KafkaListener(topics = "spec2-daniel-torquato-2", groupId = "batman")
    public void receber(@Payload RegistroLog registroLog) throws IOException {

        try {
            // O parametro é que indica se deve sobrescrever ou continua no
            // arquivo.
            FileWriter fw = new FileWriter("/home/a2/Documentos/Daniel Torquato - Itau/BigCase/LogNfe.txt", true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(registroLog.getDataFormatada() + registroLog.getTipoOperacao() + registroLog.getIdentidade() + registroLog.getMensagem());
            conexao.newLine();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
