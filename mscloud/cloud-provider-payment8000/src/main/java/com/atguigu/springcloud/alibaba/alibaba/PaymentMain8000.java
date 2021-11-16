package com.atguigu.springcloud.alibaba.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8000.class,args);
    }
}
