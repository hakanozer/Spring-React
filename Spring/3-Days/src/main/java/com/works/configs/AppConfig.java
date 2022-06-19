package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppConfig {

    @Bean(name = "randomBeanName" )
    public Random rnd() {
        System.out.println("Random Call");
        return new Random();
    }


}
