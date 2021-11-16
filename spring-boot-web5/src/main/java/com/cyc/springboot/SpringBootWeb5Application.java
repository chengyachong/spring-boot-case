package com.cyc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class SpringBootWeb5Application {

    public static void main(String[] args) {

      ConfigurableApplicationContext run =  SpringApplication.run(SpringBootWeb5Application.class, args);
     Map<String,Object> map  =
             run.getEnvironment().getSystemEnvironment();
        System.out.println(map);
    }

}
