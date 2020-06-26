package com.BigCase.CalcularImpostos.Consumer;

import com.BigCase.CalcularImpostos.Producer.AtualizarNotaFiscalProducer;
import com.BigCase.CalcularImpostos.client.ConsultaCapital;
import com.BigCase.CalcularImpostos.models.EmpresaDTO;
import com.BigCase.NotaFiscal.models.NotaFiscal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

@Component
public class CalcularImpostosConsumer {
    @Autowired
    private ConsultaCapital consultaCapital;

    @Autowired
    private AtualizarNotaFiscalProducer atualizarNotaFiscalProducer;

    @KafkaListener(topics = "spec2-daniel-torquato-1", groupId = "batman")
    public void receber(@Payload NotaFiscal notaFiscal) throws IOException {
        System.out.println("Recebi solicitação do CNPJ " + notaFiscal.getIdentidade()+ " com Valor " + notaFiscal.getValor());

        notaFiscal.setValorInicial(notaFiscal.getValor());

        if(notaFiscal.getTpPessoa().equals("PF")){
            notaFiscal.setValorCofins(BigDecimal.ZERO);
            notaFiscal.setValorCSLL(BigDecimal.ZERO);
            notaFiscal.setValorIRRF(BigDecimal.ZERO);
            notaFiscal.setValorFinal(notaFiscal.getValor());

        }else{
            EmpresaDTO empresaDTO;
            empresaDTO = consultaCapital.getByCnpj(notaFiscal.getIdentidade());

            if(empresaDTO.getCapital_social() >= 1000000.00){
                notaFiscal.setValorCofins(notaFiscal.getValor().multiply(new BigDecimal(0.0065)).round(new MathContext(2)));
                notaFiscal.setValorCSLL(notaFiscal.getValor().multiply(new BigDecimal(0.03)).round(new MathContext(2)));
                notaFiscal.setValorIRRF(notaFiscal.getValor().multiply(new BigDecimal(0.015)).round(new MathContext(2)));
                notaFiscal.setValorFinal(notaFiscal.getValor()
                        .subtract(notaFiscal.getValorCofins())
                        .subtract(notaFiscal.getValorCSLL())
                        .subtract(notaFiscal.getValorIRRF()));
            }else{
                notaFiscal.setValorCofins(BigDecimal.ZERO);
                notaFiscal.setValorCSLL(BigDecimal.ZERO);
                notaFiscal.setValorIRRF(notaFiscal.getValor().multiply(new BigDecimal(0.015)).round(new MathContext(2)));
                notaFiscal.setValorFinal(notaFiscal.getValor().subtract(notaFiscal.getValorIRRF()));
                //BigDecimal calcIRRF = notaFiscal.getValor();
                //calcIRRF = calcIRRF.multiply(new BigDecimal(0.015));
            }
        }
        notaFiscal.setStatus("complete");

        System.out.println(notaFiscal.getId() + "  |  "
                + notaFiscal.getIdentidade() + "  |  "
                + notaFiscal.getTpPessoa()  + "  |  "
                + notaFiscal.getValor() + "  |  "
                + notaFiscal.getStatus() + "  |  "
                + notaFiscal.getValorInicial() + "  |  "
                + notaFiscal.getValorFinal() + "  |  "
                + notaFiscal.getValorIRRF() + "  |  "
                + notaFiscal.getValorCofins() + "  |  "
                + notaFiscal.getValorCSLL());
        atualizarNotaFiscalProducer.enviarAoKafka(notaFiscal);

    }
}
