package com.cyc.springboot.test;

import java.util.Locale;
import java.util.function.Consumer;

public class ConsumeTest {
    public static void main(String[] args) {
        test(mag->{
            System.out.println(mag+"转换成小写"+mag.toLowerCase());
        });
    }
    private static void test(Consumer<String> consumer){
        consumer.accept("Hello world");
    }
}
