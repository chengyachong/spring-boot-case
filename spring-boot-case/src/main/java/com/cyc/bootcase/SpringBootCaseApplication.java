package com.cyc.bootcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基础环境
 * 1.创建数据库
 * 2.创建bean封装数据
 * 3.整合mybatis
 *   1.配置数据源信息
 * 快速体验缓存
 *   步骤：
 *      开启继续注解的缓存
 *      标注缓存即可
 */
@SpringBootApplication
@EnableCaching

public class SpringBootCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCaseApplication.class, args);
    }

}
