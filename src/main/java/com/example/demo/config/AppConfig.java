package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfig {

    @Value("${snake.yaml.version}")
    int version;

    @PostConstruct
    public void printVersionNumberForYaml(){
        System.out.println(version);
    }
}
