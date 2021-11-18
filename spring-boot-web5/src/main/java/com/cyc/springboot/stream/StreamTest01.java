package com.cyc.springboot.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest01 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张珊","lisi","张山峰");
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);
    }
}
