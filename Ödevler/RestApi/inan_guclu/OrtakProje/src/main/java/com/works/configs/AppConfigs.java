package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigs {


    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
