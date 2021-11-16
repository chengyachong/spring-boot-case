package com.service;

import com.service.impl.HelloServiceImpl;

import java.lang.reflect.Method;

public class TestApp {
    public static void main(String[] args) throws  Exception{
        HelloService hello = new HelloServiceImpl();
        hello.sayHello("张三");

        Method method = HelloService.class.getMethod("sayHello", String.class);
       Object ref =  method.invoke(hello,"lisi");
    }
}
