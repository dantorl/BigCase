package com.BigCase.NotaFiscal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NotaFiscalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotaFiscalApplication.class, args);
	}

}
