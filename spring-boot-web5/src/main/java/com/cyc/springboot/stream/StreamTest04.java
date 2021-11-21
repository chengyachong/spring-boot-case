package com.cyc.springboot.stream;

import java.util.HashMap;
import java.util.Map;/**
 map接口没有实现stream流，使用时可以使用 一下方法
 */
public class StreamTest04 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.keySet().stream();
        map.entrySet().stream();
        map.values().stream();

    }
}
