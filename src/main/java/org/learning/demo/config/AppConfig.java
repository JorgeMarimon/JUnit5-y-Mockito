package org.learning.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class AppConfig {

    @Bean
    public DateFormat dateFormat(){
        return new SimpleDateFormat("HH");
    }

    @Bean
    public Date date(){
        return new Date();
    }
}
