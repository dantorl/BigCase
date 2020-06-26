package com.BigCase.CalcularImpostos.client;

import com.BigCase.CalcularImpostos.client.ConsultaCapitalFallback;
import feign.Feign;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class ConsultaCapitalConfiguration {
    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(ConsultaCapitalFallback::new)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
