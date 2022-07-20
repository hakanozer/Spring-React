package com.example.odevgun9.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class AppConfigs {

    //Service,Controller > Configuration
    //Bean configurasyon altında yapılır.
    //Contex en ust sevıyededır. (configuration ve Bean , Contex altından gelır)

    //Bir class'ın Bean olabılmesı için(Injection yapabılmek ıcın) class'ın parametre almaması gerekır.!!

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
