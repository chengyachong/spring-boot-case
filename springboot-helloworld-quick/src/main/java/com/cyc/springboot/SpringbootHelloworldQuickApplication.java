package com.cyc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringbootHelloworldQuickApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloworldQuickApplication.class, args);
    }

}
