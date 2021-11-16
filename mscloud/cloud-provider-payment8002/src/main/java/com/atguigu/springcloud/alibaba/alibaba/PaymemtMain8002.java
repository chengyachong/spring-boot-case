package com.atguigu.springcloud.alibaba.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chengyachong
 * @create
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymemtMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymemtMain8002.class,args);
    }
}
