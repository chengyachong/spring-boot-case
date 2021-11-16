package com.dfe.xjar;

import io.xjar.XCryptos;
/**
 * @author     ：任登凯
 * @date       ：Created in 2021-08-12 11:05:00
 * @description：jar包加密类
 */
public class EncryptJar {
    public static void main(String[] args) throws Exception {
        XCryptos.encryption()
                .from("D:\\workspace\\eureka.jar")  // 原始jar包路径
                .use("ytdf000!")    // 加密密码
                .include("/com/dfe/**/*.class") // 需要加密的class
                .include("/mapper/**/*Mapper.xml")// 需要加密的xml
                .exclude("/static/**/*")    // 排除目录
                .exclude("/conf/*") // 排除目录
                .to("D:\\workspace\\eureka-xjar.jar");  // 生成jar包路径
    }


}
