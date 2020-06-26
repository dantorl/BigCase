package com.BigCase.NotaFiscal.services.producers;

import com.BigCase.NotaFiscal.models.RegistroLog;
import com.BigCase.NotaFiscal.models.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GeraLogProducer {
    @Autowired
    private KafkaTemplate<String, RegistroLog> producer;

    public void geraLogSolicitacaoNFE(RequestDTO requestDTO) {
        RegistroLog registroLog = new RegistroLog();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String datefmt = fmtDate.format(date);
        String hora = fmtHora.format(date);

        registroLog.setDataFormatada("[" + datefmt + "T" + hora + "Z]");
        registroLog.setTipoOperacao("[" + "Emissão]: ");

        registroLog.setIdentidade(requestDTO.getIdentidade());
        //String.format("%.2f", requestDTO.getValor());
        registroLog.setMensagem(" acaba de pedir a emissão de uma NF no valor de R$ " + requestDTO.getValor() + "!");
        //registroLog.setMensagem(" caba de pedir a emissão de uma NF no valor de R$ " + String.format("%.2f", requestDTO.getValor()) + "!");

        System.out.println(registroLog);
        producer.send("spec2-daniel-torquato-2", registroLog);

    }

    public void geraLogConsultaNFE(String cpf_cnpj) {
        RegistroLog registroLog = new RegistroLog();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String datefmt = fmtDate.format(date);
        String hora = fmtHora.format(date);

        registroLog.setDataFormatada("[" + datefmt + "T" + hora + "Z]");
        registroLog.setTipoOperacao("[" + "Consulta]: ");

        registroLog.setIdentidade(cpf_cnpj);
        registroLog.setMensagem(" acaba de pedir os dados das suas notas fiscais.");
        System.out.println(registroLog.getDataFormatada());
        producer.send("spec2-daniel-torquato-2", registroLog);

    }
}
