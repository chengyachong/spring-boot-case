package com.cyc.bootcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 搭建基础环境
 * 1.创建数据库
 * 2.创建bean封装数据
 */
@SpringBootApplication
public class SpringBootCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCaseApplication.class, args);
    }

}
