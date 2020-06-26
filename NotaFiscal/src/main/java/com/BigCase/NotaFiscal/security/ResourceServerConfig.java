package com.BigCase.NotaFiscal.security;

import com.BigCase.NotaFiscal.security.principal.UsuarioPrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated();
              //  .anyRequest().permitAll();
             //   .antMatchers("/teste").permitAll()
            //    .anyRequest().authenticated();
    }

    @Bean
    public PrincipalExtractor principalExtractor() {
        return new UsuarioPrincipalExtractor();
    }

}
